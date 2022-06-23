package me.powerarc.designpatterns.behavioral_patterns.command._03_java;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import me.powerarc.designpatterns.behavioral_patterns.command._02_after.Command;

public class CommandInSpring {

	private DataSource dataSource;

	public CommandInSpring(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void add(Command command) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource)
			.withTableName("command")
			.usingGeneratedKeyColumns("id");

		Map<String, Object> data = new HashMap<>();
		data.put("name", command.getClass().getSimpleName());
		data.put("when", LocalDateTime.now());
		insert.execute(data);
	}

}
