package com.shiro.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/teacher")
public class TeacherController {

	
	@RequestMapping(value="/manage")
	public String manage() {
		return "manageTeacher";
	}
	
	@RequestMapping(value="/insert")
	@ResponseBody
	public Map<String, Object> insert() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("info", "insert成功");
		return map;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	public Map<String, Object> update() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("info", "update成功");
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public Map<String, Object> delete() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("info", "delete成功");
		return map;
	}

}
