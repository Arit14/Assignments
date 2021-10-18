package com.example.springbatchdbtotxt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Text {

	private String data;

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
