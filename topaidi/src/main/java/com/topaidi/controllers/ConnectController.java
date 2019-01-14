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
public class ConnectController {
	@Autowired
	UserService userService;
	
	@GetMapping("/connect")
	public String showConnect(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "connect";
	}
	
	@GetMapping("/connect/error")
	public String showConnectWithError(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		model.addAttribute("error",true);
		return "connect";
	}
	
	@PostMapping("/connect")
	public String connect(@ModelAttribute("user") User user, HttpServletRequest request, Model model) {
		User userFound = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if(userFound!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("isConnected", true);
			return "redirect:/home";			
		}else {
			return "redirect:/connect/error";		
		}
	}
	@GetMapping("/connect/disconnect")
	public String disconnect(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.setAttribute("isConnected", false);
		return "redirect:/home";
	}
}
