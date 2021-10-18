package com.example.springbatchtxttodb.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.springbatchtxttodb.model.Text;

@Component
public class Processor implements ItemProcessor<Text,Text>{

	@Override
	public Text process(Text item) throws Exception {
		// TODO Auto-generated method stub
		return item;
	}

}
