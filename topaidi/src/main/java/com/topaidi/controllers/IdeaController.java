package com.topaidi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.topaidi.service.interfaces.CommentService;
import com.topaidi.service.interfaces.IdeaService;
import com.topaidi.service.interfaces.UserService;

@Controller
public class IdeaController {
	
	@Autowired
	IdeaService ideaService;
	@Autowired
	CommentService commentService;
	@Autowired
	UserService userService;
	
	@GetMapping("/idea/{idIdea}")
	public String showIdea(@PathVariable("idIdea")int id, Model model) {
		model.addAttribute("idea", ideaService.findByKey(id));
		return "idea";
	}
	
	@GetMapping("idea/note/{idUser}/{idIdea}")
	public String noteIdea() {
		//userService.noteIdea(note);
		return "listIdea";
	}
}
