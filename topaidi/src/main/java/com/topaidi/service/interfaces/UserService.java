package com.topaidi.service.interfaces;

import java.util.List;

import com.topaidi.enums.AlertType;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;
import com.topaidi.model.Note;
import com.topaidi.model.roles.User;

public interface UserService extends GenericService<User,Integer>{
	User findByEmailAndPassword(String email, String password);
	Idea createIdea(Idea idea);
	List<User> findValidUser();
	List<User> findInvalidUser();
	Note noteIdea(Note note);
	Idea alertIdea(Idea ideaAlerted, String message, AlertType alertType);
	Comment alertComment(Comment commentAlerted, String message, AlertType alertType);
	Comment addComment(Comment comment);
}
