package com.topaidi.model.roles;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.topaidi.abstracts.Connected;
import com.topaidi.model.Address;
import com.topaidi.model.Category;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;

@Entity
public class Admin extends Connected {
	@OneToMany(mappedBy="admin")
	protected List<Category> categoriesCreated = new ArrayList<>();
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String name, String email, String password, Address address, Integer phoneNumber,
			String secretQuestion, String secretAnswer, String element) {
		super(id, name, email, password, address, phoneNumber, secretQuestion, secretAnswer);
	}
	
	public boolean ban(User user) {
		throw new UnsupportedOperationException();
	}
	
	public Category createCategory() {
		throw new UnsupportedOperationException();
	}
	
	public boolean desactivate(Idea idea) {
		throw new UnsupportedOperationException();
	}
	
	public boolean desactivate(User user) {
		throw new UnsupportedOperationException();
	}
	
	public boolean desactivate(Comment comment) {
		throw new UnsupportedOperationException();
	}
	
	public boolean deleteCategory(Category category) {
		throw new UnsupportedOperationException();
	}
	
	public boolean validSubscription(User user) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return "Admin [getName()=" + getName() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getAddress()=" + getAddress() + ", getPhoneNumber()=" + getPhoneNumber() + ", getSecretQuestion()="
				+ getSecretQuestion() + ", getSecretAnswer()=" + getSecretAnswer() + ", getId()=" + getId() + "]";
	}
}
