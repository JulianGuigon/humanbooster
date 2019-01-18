package com.topaidi.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.topaidi.model.Alert;
import com.topaidi.model.Comment;
import com.topaidi.model.Note;
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
		model.addAttribute("Comment", new Comment());
		model.addAttribute("Alert", new Alert());
		return "idea";
	}
	
	@GetMapping("idea/note/{idUser}/{idIdea}/{note}")
	public String noteIdea(
			@PathVariable("idUser") int idUser, 
			@PathVariable("idIdea") int idIdea,
			@PathVariable("note") String note,
			HttpServletRequest request) {
		
		if(note.equals("top")) {
			userService.noteIdea(new Note(true, ideaService.findByKey(idIdea), userService.findByKey(idUser)));
		}else {
			userService.noteIdea(new Note(false, ideaService.findByKey(idIdea), userService.findByKey(idUser)));
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", userService.findByKey(idUser));
		
		return "redirect: /topaidi/listIdea";
	}
}
