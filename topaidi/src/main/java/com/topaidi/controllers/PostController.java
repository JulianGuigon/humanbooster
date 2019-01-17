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

import com.topaidi.model.Idea;
import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.CategoryService;
import com.topaidi.service.interfaces.IdeaService;
import com.topaidi.validators.IdeaValidator;

@Controller
public class PostController {
	@Autowired
	IdeaService ideaService;
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/post")
	public String showPost(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("isConnected")==null) {
			return "redirect:/home";
		}
		if((boolean)session.getAttribute("isConnected")) {			
			Idea idea = new Idea();
			model.addAttribute(idea);
			model.addAttribute("categories",categoryService.findAll());
			return "post";
		}else {
			return "redirect:/home";
		}
	}
	
	@PostMapping("/post")
	public String addIdea(@ModelAttribute("idea") Idea idea, BindingResult result, HttpServletRequest request, Model model) {
		new IdeaValidator().validate(idea, result);
		if(result.hasErrors()) {
			return "admin";
		}
		HttpSession session = request.getSession();
		idea.setUserSubmitting((User)session.getAttribute("user"));
		idea.setCategory(categoryService.findByKey(idea.getCategory().getId()));
		ideaService.insert(idea);
		return "redirect:/idea/"+idea.getId();
	}
}
