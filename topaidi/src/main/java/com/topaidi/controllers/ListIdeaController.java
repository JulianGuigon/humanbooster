package com.topaidi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.topaidi.service.interfaces.CategoryService;
import com.topaidi.service.interfaces.IdeaService;

@Controller
public class ListIdeaController {
	
	@Autowired
	IdeaService ideaService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/listIdea")
	public String showListIdea(Model model) {
		model.addAttribute("navbarIndexSelected","idea");
		model.addAttribute("listIdea", ideaService.findAll());
		return "listIdea";
	}
}
