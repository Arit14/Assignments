package com.example.springbatchrabbitmq.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springbatchrabbitmq.model.Student;
import com.example.springbatchrabbitmq.service.RabbitMQSender;



@Component
public class Writer implements ItemWriter<Student>{
	
	@Autowired
	private RabbitMQSender rabbitMqSender;

	@Override
	public void write(List<? extends Student> items) throws Exception {
		// TODO Auto-generated method stub
		for(Student item:items) {
			rabbitMqSender.send(item);
		}
		
	}
}
