package com.topaidi.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.UserService;
import com.topaidi.validators.SearchValidator;

@Controller
public class SearchController {
	@Autowired
	UserService userService;
	
	private List<User> users = new ArrayList<User>();
	
	@GetMapping("/search")
	public String showSearch(Model model) {
		User user = new User();
		model.addAttribute("formUser",user);
		model.addAttribute("users",users);
		return "search";
	}
	
	@GetMapping("/search/reset")
	public String reset(Model model) {
		users = new ArrayList<User>();
		return "redirect:/search";
	}
	
	@PostMapping("/search")
	public String searchUser(@ModelAttribute("user") User user, BindingResult result,  HttpServletRequest request, Model model) {
		if(!user.getName().equals("")) {
			new SearchValidator().validate(user, result);
			if(result.hasErrors()) {
				return "search";
			}
			users = userService.findAllByName(user.getName());
			return "redirect:/search";
		}else {
			return "redirect:/search";
		}
	}
}
