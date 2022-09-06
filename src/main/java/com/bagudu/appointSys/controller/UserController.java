package com.bagudu.appointSys.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bagudu.appointSys.model.User;
import com.bagudu.appointSys.sendMail.MailService;
import com.bagudu.appointSys.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	MailService mailService;
	
	//User register for appointment
	@RequestMapping("/index")
	public String home() {
		return "register";
	}
	
	//Registration Success Page
	@RequestMapping("/success")
	public String regSuccess() {
		return "reg_success";
	}
	
	//User registration Post
	@PostMapping("/user/book")
	public String bookUser(User user) throws IOException {		
		
		String password = userService.saveUser(user);
		
		mailService.sendTextEmail(user.getEmail(), "Verification Mail", "Application ID: " + user.getUsername() +"   "+  "Reference Number: " + password);
		return "redirect:/success";		
	}
	
	//User Login Page
	@RequestMapping("/login")
	public String loginUser() {
		return "login";
	}
	
	//User logout
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}
	
	
	
	
}
