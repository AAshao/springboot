package com.ss.entity;

public class User {
	private String username;
	private String sex;
	private String like;
	private String location;
	private String self;
	private String password;
	private String userId;
	private Integer userAge;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", sex=" + sex + ", like=" + like
				+ ", location=" + location + ", self=" + self + ", password="
				+ password + ", userId=" + userId + ", userAge=" + userAge
				+ "]";
	}
	
	
}
