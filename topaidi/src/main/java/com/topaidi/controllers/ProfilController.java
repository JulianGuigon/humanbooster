package com.topaidi.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfilController {

	@GetMapping("/profil")
	public String showProfil(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("isConnected")==null) {
			return "redirect:/home";
		}
		if((boolean)session.getAttribute("isConnected")) {			
			return "profil";
		}else {
			return "redirect:/home";
		}
	}
}
