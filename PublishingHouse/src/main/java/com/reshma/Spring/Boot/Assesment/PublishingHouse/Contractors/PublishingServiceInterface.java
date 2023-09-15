package com.reshma.Spring.Boot.Assesment.PublishingHouse.Contractors;

import java.util.List;

import com.reshma.Spring.Boot.Assesment.PublishingHouse.Models.Books;
import com.reshma.Spring.Boot.Assesment.PublishingHouse.Models.Publishers;

public interface PublishingServiceInterface {
	List<Publishers> getAllPulishers();

	List<Books> getAllBooks();
}
