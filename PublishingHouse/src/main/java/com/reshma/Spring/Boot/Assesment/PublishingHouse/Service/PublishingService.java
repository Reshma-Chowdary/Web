package com.reshma.Spring.Boot.Assesment.PublishingHouse.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reshma.Spring.Boot.Assesment.PublishingHouse.Models.Books;
import com.reshma.Spring.Boot.Assesment.PublishingHouse.Models.Publishers;
import com.reshma.Spring.Boot.Assesment.PublishingHouse.Repositories.PublishingServiceimpl;

@Service
public class PublishingService {
	@Autowired
	PublishingServiceimpl pserviceimpl;

	public List<Publishers> getAllPublishers() {
		return pserviceimpl.getAllPulishers();
	}

	public List<Books> getAllBooks() {
		return pserviceimpl.getAllBooks();
	}

	public void addBook(Books book) {
		pserviceimpl.addBook(book);

	}
}
