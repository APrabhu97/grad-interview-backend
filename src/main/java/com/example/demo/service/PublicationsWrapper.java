package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Publication;
import com.example.demo.pojo.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PublicationsWrapper {
	
	public String title;
	public Integer year;

	PublicationsWrapper(@JsonProperty("title") String title,
			@JsonProperty("year") String year) {
		this.title = title;
		this.year = Integer.parseInt(year);
	}

}
