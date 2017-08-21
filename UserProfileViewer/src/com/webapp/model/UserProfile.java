package com.webapp.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProfile {

	private boolean active;
	private String address;
	private int age;
	private String balance;
	private boolean blocked;
	private Date date_registered;
	private String email;
	private String id;
	@Autowired
	private Name name;
	private String phone;
	private String picture;
	private String profile;

	public boolean getActive() {
		return this.active;
	}

	public String getAddress() {
		return this.address;
	}

	public int getAge() {
		return this.age;
	}

	public String getBalance() {
		return this.balance;
	}

	public boolean getBlocked() {
		return this.blocked;
	}

	public Date getDateRegistered() {
		return this.date_registered;
	}

	public String getEmail() {
		return this.email;
	}

	public String getId() {
		return this.id;
	}

	public Name getName() {
		return this.name;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getPicture() {
		return this.picture;
	}

	public String getProfile() {
		return this.profile;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public void setDateRegistered(Date date_registered) {
		this.date_registered = date_registered;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
}