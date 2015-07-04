package com.abm.web.dao.global;

import org.springframework.stereotype.Service;

import com.abm.web.pojo.User;

@Service
public class ThreadContent {

	private static ThreadLocal<User> currentUser = new ThreadLocal<User>();

	public static User getCurrentUser() {
		return currentUser.get();
	}

	public static void setCurrentUser(User user) {
		currentUser.set(user);
	}

	@Override
	public String toString() {
		return "ThreadContent [currentUser=" + currentUser + "]";
	}
	
}
