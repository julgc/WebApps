package com.checker;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;;

public class ApplicationCheckerAction extends ActionSupport {
	
	Date today;

	public Date getToday() {
		if(today==null)
			today=new Date();
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String execute(){
		return SUCCESS;
	}
}
