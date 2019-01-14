package com.topaidi.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.UserService;

@Controller
public class RegisterController {
	@Autowired
	UserService userService;
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute("user") User user, Model model, HttpServletRequest request) {
		if(user.getId()==null) {
			userService.insert(user);			
		}else{
			userService.update(user);
		}
		HttpSession session = request.getSession();
		session.setAttribute("isConnected", true);
		return "redirect:/home";
	}
}
