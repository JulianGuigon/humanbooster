package com.topaidi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListIdeaController {
	@GetMapping("/listIdea")
	public String showListIdea(Model model) {
		model.addAttribute("navbarIndexSelected","idea");
		return "listIdea";
	}
}
