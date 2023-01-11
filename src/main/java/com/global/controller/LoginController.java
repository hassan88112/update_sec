package com.global.controller;

import com.global.Entity.Role;
import com.global.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.global.Repository.RoleRepository;
import com.global.Repository.UserRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

	
	@Autowired 
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	

	@GetMapping  ("/login")
	public String login() {
		
		return "login";
	}
	@GetMapping("/register")
	public String register() {
		
		return "register";
	}
	/*
	@PostMapping("/register")
	public String registerPost(@ModelAttribute ("user") User user , HttpServletRequest request) throws ServletException {


		String password=user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password ));
		List<Role> roles=new ArrayList<>();
		roles.add(roleRepository.findById((long) 2).get());
		user.setRoles(roles);
		userRepository.save(user);
		request.login(user.getEmail() , password);
		return  "redirect:/";


	}
	*/

	@PostMapping("/register")
	public String registerPost(@ModelAttribute ("user") User user , HttpServletRequest request) throws ServletException   {

		try{

			String password=user.getPassword();
			user.setPassword(bCryptPasswordEncoder.encode(password ));
			List<Role> roles=new ArrayList<>();
			roles.add(roleRepository.findById((long) 2).get());
			user.setRoles(roles);
			userRepository.save(user);
			request.login(user.getEmail() , password);





		}

	catch(Exception exception){ System.out.print(exception);}

		return  "redirect:/";
	}





}
