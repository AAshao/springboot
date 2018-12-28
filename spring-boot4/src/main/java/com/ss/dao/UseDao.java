package com.ss.dao;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UseDao {

	private static Logger logger=LoggerFactory.getLogger(UseDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(rollbackFor=Exception.class)
	public void addUser(String name, Integer age) throws Exception {
		addUserBatch();
	}

	
	public void addUserBatch() throws Exception {
		String sql = "insert into student_info(user_name,user_age) values(?,?)";
		for (int i = 0; i < 3; i++) {
			jdbcTemplate.update(sql, "张" + i, 16 + i);
			throw new FileNotFoundException();
		}
	}
	
	
	public void printLogger(){
		logger.debug("user dao debug log");
		logger.info("user dao info log");
		logger.warn("user dao warn log");
		logger.error("user dao error log");
		
	}
}
