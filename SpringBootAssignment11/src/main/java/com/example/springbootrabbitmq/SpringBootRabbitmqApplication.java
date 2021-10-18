package com.example.springbootrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.example.springbootrabbitmq.model.Student;
import com.example.springbootrabbitmq.service.RabbitMqConsumer;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SpringBootRabbitmqApplication implements CommandLineRunner {
	
	@Autowired
	RabbitMqConsumer consumer;
	
	Student student=new Student(105,"Dipayan",75);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRabbitmqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		consumer.recievedMessage(student);
}
	
}
