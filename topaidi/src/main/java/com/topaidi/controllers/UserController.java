package com.topaidi.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.AdminService;
import com.topaidi.service.interfaces.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	AdminService adminService;
	
	@GetMapping("/user/{idUser}")
	public String showIdea(@PathVariable("idUser")int id, Model model) {
		User user = userService.findByKey(id);
		Admin admin = adminService.findByEmailAndPassword(user.getEmail(), user.getPassword());
		model.addAttribute("userDisplayed", user);
		model.addAttribute("isUserDisplayedNotAdmin", admin==null);
		model.addAttribute("isUserDisplayedActivated", user.isActive());
		model.addAttribute("isUserDisplayedValidated", user.isValid());
		return "user";
	}
	
	@GetMapping("/user/promote/{idUser}")
	public String promote(@PathVariable("idUser")int id, Model model, HttpServletRequest request) {
		adminService.insert(new Admin(userService.findByKey(id)));
		return "redirect:/user/"+id;
	}
	
	@GetMapping("/user/validate/{idUser}")
	public String validate(@PathVariable("idUser")int id, Model model, HttpServletRequest request) {
		adminService.validateUser(userService.findByKey(id));
		return "redirect:/user/"+id;
	}
	
	@GetMapping("/user/desactivate/{idUser}")
	public String desactivate(@PathVariable("idUser")int id, Model model, HttpServletRequest request) {
		adminService.desactiveUser(userService.findByKey(id));
		return "redirect:/user/"+id;
	}
	
	@GetMapping("/user/activate/{idUser}")
	public String activate(@PathVariable("idUser")int id, Model model, HttpServletRequest request) {
		adminService.activateUser(userService.findByKey(id));
		return "redirect:/user/"+id;
	}
	
	@GetMapping("/user/ban/{idUser}")
	public String ban(@PathVariable("idUser")int id, Model model, HttpServletRequest request) {
		adminService.banUser(userService.findByKey(id));
		return "redirect:/search/reset";
	}
}
