package com.topaidi.service.interfaces;

import com.topaidi.model.Comment;
import com.topaidi.model.Idea;
import com.topaidi.model.roles.Admin;
import com.topaidi.model.roles.User;

public interface AdminService extends GenericService<Admin,Integer> {
	Admin findByEmailAndPassword(String email, String password);
	boolean findEmailExist(String email);
	boolean banUser(User user);
	boolean desactiveIdea(Idea idea);
	boolean desactiveUser(User user);
	boolean desactiveComment(Comment comment);
	boolean validateUser(User user);
}
