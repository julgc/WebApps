package com.webapp.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.webapp.model.Name;
import com.webapp.service.DataManagerService;

@Component(value = "profileAction")
public class ProfileAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Name name;

	private List<String[]> profiles;

	@Autowired
	DataManagerService svc;

	public String getAllProfile() {
		try {
			svc.populateUserProfiles();
			profiles = svc.getAllProfile();
			return SUCCESS;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String getAllProfileByName(Name name) {
		try {
			profiles = svc.getAllProfileByName(name);
			return SUCCESS;
		} catch (IOException e) {
			return ERROR;
		}
	}

	public Name getName() {
		return name;
	}

	public List<String[]> getProfiles() {
		return profiles;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public void setProfiles(List<String[]> profiles) {
		this.profiles = profiles;
	}

}
