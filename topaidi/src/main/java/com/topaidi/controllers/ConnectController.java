package com.topaidi.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.topaidi.model.roles.User;

@Controller
public class ConnectController {
	@GetMapping("/connect")
	public String showConnect(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "connect";
	}
	
	@PostMapping("/connect")
	public String connect(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.setAttribute("isConnected", true);
		return "redirect:/home";
	}
	@GetMapping("/connect/disconnect")
	public String disconnect(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.setAttribute("isConnected", false);
		return "redirect:/home";
	}
}
