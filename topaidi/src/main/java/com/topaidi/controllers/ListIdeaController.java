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
import com.topaidi.service.interfaces.IdeaService;


@Controller
public class ListIdeaController {
	
	@Autowired
	IdeaService ideaService;
	
	@GetMapping("/listIdea")
	public String showListIdea(Model model) {
		Address address1 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		Admin admin = new Admin("Jean Guy","a.g@gmail.com","aaaa",address1,"0477265898");
		Category category = new Category("cuisine",LocalDate.now(),admin);
		Address address2 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user = new User("Aerty qwerty","a.g@gmail.com","aaaa",address2,"0477265898",true,true);
		Address address3 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user3 = new User("Jawzs febe","a.g@gmail.com","aaaa",address3,"0477265898",true,true);
		Address address4 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user4 = new User("nbvvsd oiuy","a.g@gmail.com","aaaa",address4,"0477265898",true,true);
		Address address5 = new Address("France","Lyon",69130,"chemin Louis Chirpaz",8);
		User user5 = new User("asv hku","a.g@gmail.com","aaaa",address5,"0477265898",true,true);
		Idea idea = new Idea("idea1","Aliquam erat volutpat. Ut sed massa ex.","a",LocalDate.now(),category,user);
		Idea idea2 = new Idea("idea1","Aliquam erat volutpat. Ut sed massa ex.","a",LocalDate.now(),category,user);
		Idea idea3 = new Idea("idea1","Aliquam erat volutpat. Ut sed massa ex.","a",LocalDate.now(),category,user);
		Idea idea4 = new Idea("idea1","Aliquam erat volutpat. Ut sed massa ex.","a",LocalDate.now(),category,user);
		Idea idea5 = new Idea("idea1","Aliquam erat volutpat. Ut sed massa ex.","a",LocalDate.now(),category,user);
		Idea idea6 = new Idea("idea1","Aliquam erat volutpat. Ut sed massa ex.","a",LocalDate.now(),category,user);
		Idea idea7 = new Idea("idea1","Aliquam erat volutpat. Ut sed massa ex.","a",LocalDate.now(),category,user);
		Idea idea8 = new Idea("idea1","Aliquam erat volutpat. Ut sed massa ex.","a",LocalDate.now(),category,user);
		ideaService.insert(idea);
		ideaService.insert(idea2);
		ideaService.insert(idea3);
		ideaService.insert(idea4);
		ideaService.insert(idea5);
		ideaService.insert(idea6);
		ideaService.insert(idea7);
		ideaService.insert(idea8);
		
		model.addAttribute("navbarIndexSelected","idea");
		model.addAttribute("listIdea", ideaService.findAll());
		return "listIdea";
	}
}
