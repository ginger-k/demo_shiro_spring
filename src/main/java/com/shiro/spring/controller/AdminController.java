package com.shiro.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/admin")
public class AdminController {

	
	@RequestMapping(value="/manage")
	public String manage() {
		return "manageSystem";
	}

}
