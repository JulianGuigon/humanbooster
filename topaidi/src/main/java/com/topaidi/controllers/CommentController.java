package com.topaidi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.topaidi.model.Comment;
import com.topaidi.service.interfaces.CommentService;
import com.topaidi.service.interfaces.IdeaService;
import com.topaidi.service.interfaces.UserService;

@Controller
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	IdeaService ideaService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/postComment")
	public String postComment(@ModelAttribute("Comment") Comment comment) {
		commentService.insert(comment);
		return "redirect: /topaidi/idea/"+comment.getIdeaCommented().getId();
	}

}
