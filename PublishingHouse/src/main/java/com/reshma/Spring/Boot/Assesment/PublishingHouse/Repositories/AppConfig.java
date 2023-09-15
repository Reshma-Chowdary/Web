package com.reshma.Spring.Boot.Assesment.PublishingHouse.Repositories;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.reshma.Spring.Boot.Assesment.PublishingHouse.Repositories")
public class AppConfig {
	@Autowired
	Environment Env;

	@Bean
	DataSource datasource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("org.postgresql.Driver");
		dmds.setUrl("jdbc:postgresql://192.168.110.48:5432/plf_training");
		dmds.setUsername("plf_training_admin");
		dmds.setPassword("pff123");
		return dmds;
	}
}
