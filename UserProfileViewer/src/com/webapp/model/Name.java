package com.webapp.model;

import org.springframework.stereotype.Component;

@Component
public class Name {

	private String first;
	private String last;
	private String middle;

	public String getFirst() {
		return this.first;
	}

	public String getLast() {
		return this.last;
	}

	public String getMiddle() {
		return this.middle;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	@Override
	public String toString() {
		return first + " " + middle + ". " + last;
	}
}