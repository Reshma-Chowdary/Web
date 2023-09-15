package com.reshma.Spring.Boot.Assesment.PublishingHouse.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.reshma.Spring.Boot.Assesment.PublishingHouse.Models.Books;

public class BookMapper implements RowMapper<Books> {

	@Override
	public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
		Books book = new Books();
		book.setPub_id(rs.getInt(1));
		book.setPub_id(rs.getInt(2));
		book.setBook_name(rs.getString(3));
		book.setBook_cost(rs.getDouble(4));
		book.setBook_author(rs.getString(5));
		return book;
	}

}
