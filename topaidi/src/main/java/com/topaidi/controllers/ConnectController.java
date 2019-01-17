package com.topaidi.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.AdminService;
import com.topaidi.service.interfaces.UserService;

@Controller
public class ConnectController {
	@Autowired
	UserService userService;
	@Autowired
	AdminService adminService;
	
	@GetMapping("/connect")
	public String showConnect(@RequestParam(value="error",required=false) String error, Model model) {
		User user = new User();
		model.addAttribute("user",user);
		if(error!=null) {
			model.addAttribute("error",error);
		}
		return "connect";
	}
	
	@PostMapping("/connect")
	public String connect(@ModelAttribute("user") User user, HttpServletRequest request, Model model) {
		User userFound = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
		Admin adminFound = adminService.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if(adminFound!=null&&userFound!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userFound);
			session.setAttribute("admin", adminFound);
			session.setAttribute("isConnected", true);
			session.setAttribute("isAdmin", true);
			return "redirect:/home";
		}
		else if(adminFound==null&&userFound!=null) {
			if(userFound.isValid()) {
				HttpSession session = request.getSession();
				session.setAttribute("user", userFound);
				session.setAttribute("admin", null);
				session.setAttribute("isConnected", true);
				session.setAttribute("isAdmin", false);
				return "redirect:/home";							
			}else {
				return "redirect:/connect?error=invalidUser";	
			}
		}else {
			return "redirect:/connect?error=connectionFailed";		
		}
	}
	
	@GetMapping("/connect/disconnect")
	public String disconnect(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		session.setAttribute("admin", null);
		session.setAttribute("isConnected", false);
		session.setAttribute("isAdmin", false);
		return "redirect:/home";
	}
}
