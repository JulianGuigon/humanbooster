package com.topaidi.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.topaidi.model.Address;
import com.topaidi.model.Category;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;
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
		
		Comment comment = new Comment("bof bof",user3,idea);
		Comment comment2 = new Comment("c'est nul peut faire mieux",user4,idea);
		Comment comment3 = new Comment("pas très utile tout ça !",user5,idea);
		commentService.insert(comment);
		commentService.insert(comment2);
		commentService.insert(comment3);
		
		model.addAttribute("idea", ideaService.findByKey(id));
		return "idea";
	}
	
	@GetMapping("idea/note/{idUser}/{idIdea}")
	public String noteIdea() {
		//userService.noteIdea(note);
		return "listIdea";
	}
}
