package com.example.springbatchdbtotxt.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.springbatchdbtotxt.model.Text;


@Component
public class TextRowMapper implements RowMapper<Text>{

	@Override
	public Text mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Text text=new Text();
		
		text.setData(rs.getString("data"));
		
		return text;
	}

}
