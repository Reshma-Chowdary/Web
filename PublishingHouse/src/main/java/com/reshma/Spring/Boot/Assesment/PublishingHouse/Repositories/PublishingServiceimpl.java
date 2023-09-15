package com.reshma.Spring.Boot.Assesment.PublishingHouse.Repositories;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.reshma.Spring.Boot.Assesment.PublishingHouse.Contractors.PublishingServiceInterface;
import com.reshma.Spring.Boot.Assesment.PublishingHouse.Models.Books;
import com.reshma.Spring.Boot.Assesment.PublishingHouse.Models.Publishers;
import com.reshma.Spring.Boot.Assesment.PublishingHouse.RowMappers.BookMapper;
import com.reshma.Spring.Boot.Assesment.PublishingHouse.RowMappers.PublisherMapper;

@Repository
public class PublishingServiceimpl implements PublishingServiceInterface {

	JdbcTemplate jdbc;

	@Autowired
	public PublishingServiceimpl(DataSource ds) {
		this.jdbc = new JdbcTemplate(ds);

	}

	public List<Publishers> getAllPulishers() {
		return jdbc.query("select * from publishers", new PublisherMapper());
	}

	public List<Books> getAllBooks() {
		return jdbc.query("select * from Allbooks", new BookMapper());
	}

	public void addBook(Books book) {
		jdbc.update("insert into Allbooks values(?,?,?,?,?)", book.getBook_id(), book.getPub_id(), book.getBook_name(),
				book.getBook_cost(), book.getBook_author());
	}

}
