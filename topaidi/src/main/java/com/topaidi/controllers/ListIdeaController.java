package com.topaidi.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.topaidi.model.Address;
import com.topaidi.model.Category;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.CategoryService;
import com.topaidi.service.interfaces.GenericService;
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
