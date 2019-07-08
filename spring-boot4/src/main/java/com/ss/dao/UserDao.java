package com.ss.dao;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {

	private static Logger logger=LoggerFactory.getLogger(UserDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public void addUserBatch() throws Exception {
		String sql = "insert into student_info(user_name,user_age) values(?,?)";

		jdbcTemplate.update(sql, "张0", 16);
		//throw new FileNotFoundException();
	}
	
	public void addUserBatch2() throws Exception {
		String sql = "insert into student_info(user_name,user_age) values(?,?)";

		jdbcTemplate.update(sql, "张2", 18);
		//throw new FileNotFoundException();
	}
	
	
	public List<Map<String, Object>> queryUsers(){
		return jdbcTemplate.queryForList("select * from student_info");
	}
	
	
	public void printLogger(){
		logger.debug("user dao debug log");
		logger.info("user dao info log");
		logger.warn("user dao warn log");
		logger.error("user dao error log");
		
	}
}
