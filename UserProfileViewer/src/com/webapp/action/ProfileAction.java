package com.webapp.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.webapp.service.DataManagerService;

@Component(value = "profileAction")
public class ProfileAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private List<String[]> profiles;

	@Autowired
	DataManagerService svc;

	public String getAllProfile() throws IOException {
		svc.populateUserProfiles();
		profiles = svc.getAllProfile();
		return SUCCESS;
	}

	public String getAllProfileByName() throws IOException {
		svc.populateUserProfiles();
		profiles = svc.getAllProfileByName(name);
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public List<String[]> getProfiles() {
		return profiles;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProfiles(List<String[]> profiles) {
		this.profiles = profiles;
	}

}
