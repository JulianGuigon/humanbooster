package com.topaidi.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.topaidi.model.Category;
import com.topaidi.model.roles.Admin;
import com.topaidi.service.interfaces.CategoryService;
import com.topaidi.validators.CategoryValidator;

@Controller
public class AdminController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/admin")
	public String showAdmin(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("isAdmin")==null||session.getAttribute("isConnected")==null) {
			return "redirect:/home";
		}
		if((boolean)session.getAttribute("isAdmin")&&(boolean)session.getAttribute("isConnected")) {			
			Category category = new Category();
			model.addAttribute(category);
			return "admin";
		}else {
			return "redirect:/home";
		}
	}
	
	@PostMapping("/admin")
	public String addCategory(@ModelAttribute("category") Category category, BindingResult result, Model model, HttpServletRequest request) {
		new CategoryValidator().validate(category, result);
		if(result.hasErrors()) {
			return "admin";
		}
		HttpSession session = request.getSession();
		category.setAdminCreating((Admin)session.getAttribute("admin"));
		categoryService.insert(category);
		return "redirect:/admin";
	}
}
