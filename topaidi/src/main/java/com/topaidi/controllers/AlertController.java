package com.topaidi.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.topaidi.enums.AlertType;
import com.topaidi.model.Alert;
import com.topaidi.service.interfaces.AlertService;
import com.topaidi.service.interfaces.CommentService;
import com.topaidi.service.interfaces.IdeaService;
import com.topaidi.service.interfaces.UserService;

@Controller
public class AlertController {

	@Autowired
	AlertService alertService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	IdeaService ideaService;
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/alertIdea")
	public String alertIdea(@ModelAttribute("Alert") Alert alert) {
		alert.setAlertType(AlertType.Idea);
		alert.setCreatedAt(LocalDate.now());
		alert.setCommentAlerted(null);
		alertService.insert(alert);
		return "redirect: /topaidi/idea/"+alert.getIdeaAlerted().getId();
	}
	
	@PostMapping("/alertComment")
	public String alertComment(@ModelAttribute("Alert") Alert alert) {
		alert.setAlertType(AlertType.Comment);
		alert.setCreatedAt(LocalDate.now());
		alert.setIdeaAlerted(null);
		alertService.insert(alert);
		return "redirect: /topaidi/listIdea";
	}
}




