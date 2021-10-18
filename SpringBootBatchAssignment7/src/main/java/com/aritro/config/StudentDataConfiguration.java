package com.aritro.config;

//import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.aritro.model.StudentData;

@Configuration
@EnableBatchProcessing
public class StudentDataConfiguration {
	
	private static final Logger Log=LoggerFactory.getLogger(StudentDataConfiguration.class);
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Value(value="input/student_*.csv")
	private Resource[] resources;
	
	@Bean
	public FlatFileItemReader<StudentData> readDataFromMultiCsv(){
		Log.info("StudentDataConfiguration - readDataFromMultiCsv() execution Started");
		FlatFileItemReader<StudentData> reader= new FlatFileItemReader<StudentData>();
		reader.setLineMapper(new DefaultLineMapper<StudentData>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer(){
					{
					setNames(StudentData.getFields());
				    }
				});
				
				setFieldSetMapper(new BeanWrapperFieldSetMapper<StudentData>() {
					{
						setTargetType(StudentData.class);
					}
				});
				
				
			}
			
			
		});
		
		Log.info("StudentDataConfiguration - readDataFromMultiCsv() execution Completed");
		return reader;
	}
	
	@Bean
	public MultiResourceItemReader<StudentData> multiResourceItemReader(){
		Log.info("StudentDataConfiguration - multiResourceItemReader() execution Started");
		MultiResourceItemReader<StudentData> read= new MultiResourceItemReader<StudentData>();
		read.setResources(resources);
		read.setDelegate(readDataFromMultiCsv());
		Log.info("StudentDataConfiguration - multiResourceItemReader() execution Completed");
		return read;
	}
	
	@Bean
	public FlatFileItemWriter<StudentData> writeDataintoCSV(){
		Log.info("StudentDataConfiguration - writeDataintoCSV() execution Started");
		FlatFileItemWriter<StudentData> writer= new FlatFileItemWriter<StudentData>();
		writer.setResource(new ClassPathResource("output/student_output.csv"));
		writer.setAppendAllowed(true);
		DelimitedLineAggregator<StudentData> aggregator= new DelimitedLineAggregator<>();
		BeanWrapperFieldExtractor<StudentData> fieldExtractor= new BeanWrapperFieldExtractor<>();
		fieldExtractor.setNames(StudentData.getFields());
		aggregator.setFieldExtractor(fieldExtractor);
		writer.setLineAggregator(aggregator);
		Log.info("StudentDataConfiguration - writeDataintoCSV() execution Completed");
		return writer;
	}
	
	@Bean
	public Step extractStudent() {
		return stepBuilderFactory.get("extractStudent").<StudentData, StudentData>chunk(10)
				.reader(multiResourceItemReader()).writer(writeDataintoCSV()).build();
	}
	
	@Bean
	public Job processStudent() {
		return jobBuilderFactory.get("processStudent").incrementer(new RunIdIncrementer()).flow((extractStudent())).end().build();
	}
	

}
