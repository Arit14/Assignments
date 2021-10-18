package com.example.springbatchrabbitmq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SpringBatchRabbitMqApplication implements CommandLineRunner{

	@Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchRabbitMqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters parameters=new JobParameters(maps);
		JobExecution jobExecution=jobLauncher.run(job, parameters);
		System.out.println("JobExecution: " + jobExecution.getStatus());
	}

}
