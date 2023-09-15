package com.reshma.Spring.Boot.Assesment.PublishingHouse.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reshma.Spring.Boot.Assesment.PublishingHouse.Models.Books;
import com.reshma.Spring.Boot.Assesment.PublishingHouse.Models.Publishers;
import com.reshma.Spring.Boot.Assesment.PublishingHouse.Service.PublishingService;

@RestController
public class PublishingController {
	@Autowired
	PublishingService pub_serv;

	@RequestMapping(value = "/publishers", method = RequestMethod.GET)
	public List<Publishers> getAllPublishers() {

		return pub_serv.getAllPublishers();
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<Books> getAllBooks() {

		return pub_serv.getAllBooks();
	}

	@PostMapping("/add")
	public void addBook(@RequestBody Books book) {
		pub_serv.addBook(book);
	}
}
