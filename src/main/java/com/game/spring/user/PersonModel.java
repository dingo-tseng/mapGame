package com.game.spring.user;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PersonModel {

	private Integer pid;
	private String username;
	private String password;
	private String email;
	private ArrayList<MoneyModel> payList;
	
	public PersonModel() {}
	public PersonModel(Integer pid, String username, String password, String email, ArrayList<MoneyModel> payList) {
		super();
		this.pid = pid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.payList = payList;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<MoneyModel> getPayList() {
		return payList;
	}
	public void setPayList(ArrayList<MoneyModel> payList) {
		this.payList = payList;
	}
	public Integer getPid() {
		return pid;
	}
	
	

}
