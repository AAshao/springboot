package com.ss.entity;

public class StudentInfo {

	private Integer id;
	private Integer userAge;
	private String userName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "StudentInfo [id=" + id + ", userAge=" + userAge + ", userName="
				+ userName + "]";
	}
	
	
	
}
