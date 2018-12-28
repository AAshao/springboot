package com.ss.entity;


public class StudentInfo {
	private Integer id;
	private String userName;
	private Integer userAge;
	
	
	public StudentInfo() {
		super();
	}
	
	public StudentInfo(String userName, Integer userAge) {
		super();
		this.userName = userName;
		this.userAge = userAge;
	}
	
	
	public StudentInfo(Integer id, String userName, Integer userAge) {
		super();
		this.id = id;
		this.userName = userName;
		this.userAge = userAge;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	@Override
	public String toString() {
		return "StudentInfo [id=" + id + ", userName=" + userName
				+ ", userAge=" + userAge + "]";
	}
	
	
}
