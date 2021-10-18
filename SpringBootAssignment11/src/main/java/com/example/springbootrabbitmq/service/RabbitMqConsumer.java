package com.example.springbootrabbitmq.service;

import java.io.FileOutputStream;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.springbootrabbitmq.model.Student;


@Component
public class RabbitMqConsumer {
	
	@RabbitListener(queues = "${student.rabbitmq.queue}")
	public void recievedMessage(Student student) {
		try {
			
			//Student s1=new Student(student);
			System.out.println("Recieved Message From RabbitMQ: " + student);
			String str=student.toString();
			FileOutputStream fos = new FileOutputStream("src/main/resources/student.txt",true);
			
			byte[] array = str.getBytes();


			fos.write(array);
			
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	@Bean
	public Jackson2JsonMessageConverter converter() {
	    return new Jackson2JsonMessageConverter();
	}

}
