package com.shiro.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/student")
public class StudentController {

	
	@RequestMapping(value="/manage")
	public String manage() {
		return "manageStudent";
	}

}
