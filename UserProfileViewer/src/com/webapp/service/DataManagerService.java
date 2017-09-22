package com.webapp.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.webapp.conversions.DateAdapter;
import com.webapp.model.Name;
import com.webapp.model.UserProfile;

@Service
public class DataManagerService {

	private static final String USER_PROFILE_URL = "https://raw.githubusercontent.com/julgc/WebApps/master/UserProfileViewer/profiles.json";
	private UserProfile[] allUserProfiles;

	private String[] constructProfileSummary(UserProfile profile) {
		String[] profileSummary = new String[] { profile.getId(), profile.getName().toString(), "" + profile.getAge(),
				profile.getActive() ? "checked" : "", profile.getBlocked() ? "checked" : "", };
		return profileSummary;
	}

	/** Returns the profile strings as list */
	public List<String[]> getAllProfile() throws IOException {
		List<String[]> allProfile = new ArrayList<String[]>();
		if (allUserProfiles != null)
			for (UserProfile profile : allUserProfiles) {
				String[] profileSummary = constructProfileSummary(profile);
				allProfile.add(profileSummary);
			}
		return allProfile;
	}

	/** Returns the profile which satisfy the searchName criteria */
	public List<String[]> getAllProfileByName(String pName) throws IOException {
		List<String[]> allProfileByName = new ArrayList<String[]>();
		if (allUserProfiles != null && !isStrEmpty(pName))
			for (UserProfile profile : allUserProfiles) {
				Name name = profile.getName();
				if (name.toString().toLowerCase().indexOf(pName.toLowerCase().trim()) != -1) {
					String[] profileSummary = constructProfileSummary(profile);
					allProfileByName.add(profileSummary);
				}
			}
		else {
			return getAllProfile();
		}
		return allProfileByName;
	}

	/** Parse UserPofiles from the URL */
	protected void getAllUserProfilesFromUrl() throws IOException {

		URL url = new URL(USER_PROFILE_URL);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuilder jsonSB = new StringBuilder();

		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			jsonSB.append(inputLine);
		}
		in.close();

		Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateAdapter()).create();
		String JsonString = jsonSB.toString();
		allUserProfiles = gson.fromJson(JsonString, UserProfile[].class);

		allUserProfiles = gson.fromJson(JsonString, UserProfile[].class);
	}

	/**
	 * Gets UserProfile By Id
	 *
	 * @throws IOException
	 */
	public UserProfile getSingleUserProfile(String id) throws IOException {
		UserProfile singleUserProfile = new UserProfile();
		if (allUserProfiles != null && id != null)
			for (UserProfile profile : allUserProfiles) {
				if (id.equals(profile.getId())) {
					singleUserProfile = profile;
					break;
				}
			}
		return singleUserProfile;
	}

	private boolean isStrEmpty(String in) {
		if (in == null || in.length() == 0) {
			return true;
		}
		return false;
	}

	public void populateUserProfiles() throws IOException {
		getAllUserProfilesFromUrl();
	}

	/** For JUNIT Purpose */
	protected void setAllUserProfiles(UserProfile[] allUserProfiles) {
		this.allUserProfiles = allUserProfiles;
	}

}
