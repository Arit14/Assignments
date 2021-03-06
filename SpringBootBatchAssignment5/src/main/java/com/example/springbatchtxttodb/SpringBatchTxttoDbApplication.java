package com.example.springbatchtxttodb;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchTxttoDbApplication implements CommandLineRunner{
	
	@Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchTxttoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters parameters=new JobParameters(maps);
		JobExecution jobExecution=jobLauncher.run(job, parameters);
		System.out.println("JobExecution: " + jobExecution.getStatus());
		
	}

}
