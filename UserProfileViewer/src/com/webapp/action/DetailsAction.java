package com.webapp.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.webapp.model.UserProfile;
import com.webapp.service.DataManagerService;

@Component(value = "detailsAction")
public class DetailsAction extends ActionSupport {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Autowired
	DataManagerService svc;

	private UserProfile userProfile;

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

}
