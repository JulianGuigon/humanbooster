package com.topaidi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IdeaController {
	
	@GetMapping("/idea/{idIdea}")
	public String showIdea(@PathVariable("idIdea")int id, Model model) {
		return "idea";
	}
}
