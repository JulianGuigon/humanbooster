package com.topaidi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IdeaController {
	@GetMapping("/idea")
	public String showIdea(Model model) {
		return "idea";
	}
}
