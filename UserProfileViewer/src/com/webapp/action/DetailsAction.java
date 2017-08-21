package com.webapp.action;

import java.io.IOException;

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

	String id;
	@Autowired
	DataManagerService svc;

	@Autowired
	private UserProfile userProfile;

	public String getId() {
		return id;
	}

	public String getSingleUserProfile() throws IOException {
		svc.populateUserProfiles();
		userProfile = svc.getSingleUserProfile(id);
		return SUCCESS;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

}
