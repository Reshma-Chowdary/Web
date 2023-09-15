package com.reshma.Spring.Boot.Assesment.PublishingHouse.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.reshma.Spring.Boot.Assesment.PublishingHouse.Models.Publishers;

public class PublisherMapper implements RowMapper<Publishers> {

	@Override
	public Publishers mapRow(ResultSet rs, int rowNum) throws SQLException {
		Publishers publisher = new Publishers();
		publisher.setPub_id(rs.getInt(1));
		publisher.setPub_name(rs.getString(2));
		publisher.setPub_moblno(rs.getString(3));
		return publisher;
	}

}
