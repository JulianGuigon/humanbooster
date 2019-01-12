package com.topaidi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfilController {

	@GetMapping("/profil")
	public String showProfil(Model model) {
		return "Profil";
	}
}
