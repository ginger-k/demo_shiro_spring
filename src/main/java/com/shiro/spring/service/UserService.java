package com.shiro.spring.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.shiro.spring.pojo.User;

@Service
public class UserService {
	
	
	public Set<String> getRoles(String userName) {
		Set<String> roles =  new HashSet<String>();;
		if ("admin".equals(userName)) {
			roles.add("admin");
			roles.add("student");
			roles.add("teacher");
		} else if ("yao".equals(userName)) {
			roles.add("student");
		} else if ("xu".equals(userName)) {
			roles.add("teacher");
		}
		return roles;
	}
	
	public Set<String> getPermissions(String userName) {
		Set<String> permissions =  new HashSet<String>();;
		if ("admin".equals(userName)) {
			permissions.add("admin:*");
			permissions.add("student:*");
			permissions.add("teacher:*");
		} else if ("yao".equals(userName)) {
			permissions.add("student:manage");
		} else if ("xu".equals(userName)) {
			permissions.add("teacher:manage");
		}
		return permissions;
	}

	public User getByUserName(String userName) {
		User user = new User();
		if ("admin".equals(userName)) {
			user.setId("0");
			user.setUserName("admin");
			user.setPassword("admin");
		} else if ("yao".equals(userName)) {
			user.setId("1");
			user.setUserName("yao");
			user.setPassword("123");
		} else if ("xu".equals(userName)) {
			user.setId("2");
			user.setUserName("xu");
			user.setPassword("456");
		}
		return user;
	}

}
