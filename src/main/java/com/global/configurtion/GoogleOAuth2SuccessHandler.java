/*
package com.global.configurtion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.RedirectStrategy;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.global.Entity.Role;
import com.global.Entity.User;
import com.global.Repository.RoleRepository;
import com.global.Repository.UserRepository;



@Component
public class GoogleOAuth2SuccessHandler  implements AuthenticationSuccessHandler{

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();


	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		OAuth2AuthenticationToken token=(OAuth2AuthenticationToken) authentication;
		String email=token.getPrincipal().getAttributes().get("email").toString();
		
		if(userRepository.findUserByEmail(email).isPresent()) {
			
			
		}else {
			
		User user=new User();
		user.setFirstname(token.getPrincipal().getAttributes().get("given_name").toString());
		user.setLastname(token.getPrincipal().getAttributes().get("family_name").toString());
		user.setEmail(email);
		List<Role> roles=new ArrayList<>();
		roles.add(roleRepository.findById((long) 2).get());
		user.setRoles(roles);
		userRepository.save(user);
		}
		
	  
		
	}
	
	
}
*/