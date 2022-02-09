package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Publication;
import com.example.demo.pojo.User;

public interface PublicationService {

	public Publication getPublication(Integer id);

	public Iterable<Publication> getAllPublications();

	public Publication updatePublication(Integer id);

	public void deletePublication(Integer id);

	public User createPublication(String title, Integer year);
	
	public Iterable<Publication> createPublications(Integer studentId, List<Publication> publications);
}
