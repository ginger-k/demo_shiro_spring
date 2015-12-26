package com.shiro.spring.realm;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.shiro.spring.pojo.User;
import com.shiro.spring.service.UserService;

public class UserRealm extends AuthorizingRealm {

		@Autowired
		private UserService userService;
		
		/**
		 * 为当限前登录的用户授予角色和权限
		 */
		@Override
		protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
			String userName=(String)principals.getPrimaryPrincipal();
			SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
			Set<String> roles = userService.getRoles(userName);
			if (roles != null) {
				for (String role : roles) {
					System.out.println("realm-roles: " + role);
				}
			}
			authorizationInfo.setRoles(roles);
			Set<String> permissions = userService.getPermissions(userName);
			if (permissions != null) {
				for (String permission : permissions) {
					System.out.println("realm-permissions: " + permission);
				}
			}
			authorizationInfo.setStringPermissions(permissions);
			return authorizationInfo;
		}

		/**
		 * 验证当前登录的用户
		 */
		@Override
		protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
			String userName=(String)token.getPrincipal();
			System.out.println("realm-userName: " + userName);
			User user=userService.getByUserName(userName);
			if(user != null){
				AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(), super.getName());
				return authcInfo;
			}else{
				return null;				
			}
		}


}
