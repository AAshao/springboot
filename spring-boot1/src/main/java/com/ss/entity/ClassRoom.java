package com.ss.entity;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
	private List<User> userList=new ArrayList<User>();

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	
	
}
