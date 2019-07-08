package com.ss.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ss.dao.UserDao;

@Service
public class UserService {

	@Resource
	private  UserDao userDao;
	
	public List<Map<String, Object>> queryUsers(){
		return userDao.queryUsers();
	}
	
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED)
	public void addUserBatch() throws Exception {
		method();
	}
	
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED)
	private void method() throws Exception{
		
		userDao.addUserBatch();
		
		userDao.addUserBatch2();
	}
	
	
	
}
