package com.webapp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.webapp.model.Name;
import com.webapp.model.UserProfile;

public class DataManagerServiceTest {

	private static DataManagerService svc;

	@BeforeClass
	public static void init() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		svc = context.getBean(DataManagerService.class);
		context.close();
	}

	@Test
	public void getAllProfileByNameTest() throws IOException {
		setUserProfiles();

		Name name = new Name();
		name.setFirst("1st");
		name.setMiddle("Mid");
		name.setLast("Last");

		assertEquals(1, svc.getAllProfileByName(name).size());

		name.setFirst("1st");
		name.setMiddle("");
		name.setLast("Last");
		assertEquals(2, svc.getAllProfileByName(name).size());

		name.setFirst(null);
		name.setMiddle("");
		name.setLast("Last");
		assertEquals(3, svc.getAllProfileByName(name).size());
	}

	@Test
	public void getSingleUserProfileTest() throws IOException {
		setUserProfiles();
		UserProfile testUP = svc.getSingleUserProfile("idOfUser2");
		assertEquals("user2@test.com", testUP.getEmail());
	}

	private void setUserProfiles() {
		UserProfile up1 = new UserProfile();
		UserProfile up2 = new UserProfile();
		UserProfile up3 = new UserProfile();
		up1.setId("idOfUser1");
		up2.setId("idOfUser2");
		up3.setId("idOfUser3");

		up1.setEmail("user1@test.com");
		up2.setEmail("user2@test.com");
		up3.setEmail("user3@test.com");

		Name name1 = new Name();
		name1.setFirst("first");
		name1.setMiddle("Mid");
		name1.setLast("Last");
		up1.setName(name1);

		Name name2 = new Name();
		name2.setFirst("1st");
		name2.setMiddle(null);
		name2.setLast("Last");
		up2.setName(name2);

		Name name3 = new Name();
		name3.setFirst("1st");
		name3.setMiddle("Mid");
		name3.setLast("Last");
		up3.setName(name3);

		svc.setAllUserProfiles(new UserProfile[] { up1, up2, up3, });
	}

	@Test
	public void testIfAbleToHandleNoUserPRofile() throws IOException {
		svc.setAllUserProfiles(null);
		assertEquals(0, svc.getAllProfile().size());
	}

	@Test
	public void testThatUrlIsLoadableIntoUserProfileObject() {
		try {
			svc.getAllUserProfilesFromUrl();
		} catch (IOException e) {
			fail();
		}
	}
}
