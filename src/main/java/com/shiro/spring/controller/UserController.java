package com.shiro.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {


	/**
	 * 访问/formLogin.do，该路径被 FormAuthenticationFilter 拦截，
	 * 		如果没有username和password数据，就进入下面的方法
	 * 		如果有username和password数据，就进入自定的realm中doGetAuthenticationInfo进行身份认证
	 * 			如果认证失败，再进入下面方法，失败的异常为shiroLoginFailure
	 * 			如果认证成功，就不再进入下面方法，直接去访问之前访问的路径，如果之前访问的路径是loginUrl，那么就访问successUrl
	 *  访问/student/manage.do,该路径被 FormAuthenticationFilter 拦截，
	 * 		如果没有username和password数据，就进入下面的方法
	 * 		如果有username和password数据，就进入自定的realm中doGetAuthenticationInfo进行身份认证
	 * 			如果认证失败，再进入下面方法，失败的异常为shiroLoginFailure
	 * 			如果认证成功，被RolesAuthorizationFilter 或 PermissionsAuthorizationFilter拦截，获取访问该路径需要的角色，
	 * 				再进入自定义reaml的doGetAuthorizationInfo给当前用户授予角色和权限，
	 * 				如果有相应角色或权限，就进入地址(/student/manage.do),
	 * 				如果没有就进入配置的unauthorizedUrl
	 * 				
	 */
	@RequestMapping("/formLogin")
	public String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String errorClassName = (String)req.getAttribute("shiroLoginFailure");
        System.out.println(errorClassName);
        if(UnknownAccountException.class.getName().equals(errorClassName)) {
            req.setAttribute("error", "用户名/密码错误");
        } else if(IncorrectCredentialsException.class.getName().equals(errorClassName)) {
            req.setAttribute("error", "用户名/密码错误");
        } else if(errorClassName != null) {
            req.setAttribute("error", "未知错误：" + errorClassName);
        }
        return "login";
	}
	
	@RequestMapping("/manageIndex")
	public String success() {
		return "manageIndex";
	}
}
