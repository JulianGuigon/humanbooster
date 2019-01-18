package com.topaidi.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.topaidi.enums.AlertType;
import com.topaidi.model.Category;
import com.topaidi.model.roles.Admin;
import com.topaidi.service.interfaces.AdminService;
import com.topaidi.service.interfaces.AlertService;
import com.topaidi.service.interfaces.CategoryService;
import com.topaidi.service.interfaces.UserService;
import com.topaidi.validators.AdminValidator;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;
	@Autowired
	AlertService alertService;
	
	@GetMapping("/admin")
	public String showAdmin(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("isAdmin")==null||session.getAttribute("isConnected")==null) {
			return "redirect:/home";
		}
		if((boolean)session.getAttribute("isAdmin")&&(boolean)session.getAttribute("isConnected")) {			
			Category category = new Category();
			model.addAttribute(category);
			model.addAttribute("categories",categoryService.findAll());
			model.addAttribute("invalidUsers",userService.findInvalidUser());
			model.addAttribute("listIdeaAlerted", alertService.findAllByCreateAtAndByType(AlertType.Idea));
			model.addAttribute("listCommentAlerted", alertService.findAllByCreateAtAndByType(AlertType.Comment));
			return "admin";
		}else {
			return "redirect:/home";
		}
	}
	
	@GetMapping("/admin/validate/{idUser}")
	public String validate(@PathVariable("idUser")int id, Model model, HttpServletRequest request) {
		adminService.validateUser(userService.findByKey(id));
		return "redirect:/admin";
	}

	
	@GetMapping("/admin/ban/{idUser}")
	public String ban(@PathVariable("idUser")int id, Model model, HttpServletRequest request) {
		adminService.banUser(userService.findByKey(id));
		return "redirect:/admin";
	}
	
	@PostMapping("/admin")
	public String addCategory(@ModelAttribute("category") Category category, BindingResult result, Model model, HttpServletRequest request) {
		new AdminValidator().validate(category, result);
		if(result.hasErrors()) {
			return "admin";
		}
		HttpSession session = request.getSession();
		category.setAdminCreating((Admin)session.getAttribute("admin"));
		categoryService.insert(category);
		return "redirect:/admin";
	}
}
