package com.topaidi.model.roles;

import java.util.List;

import com.topaidi.abstracts.Connected;
import com.topaidi.model.Address;
import com.topaidi.model.Idea;
import com.topaidi.model.Note;

public class User extends Connected {
	private boolean isActive = false;
	private boolean isValid = false;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String email, String password, Address address, Integer phoneNumber,
			String secretQuestion, String secretAnswer, boolean isActive, boolean isValid) {
		super(id, name, email, password, address, phoneNumber, secretQuestion, secretAnswer);
		this.isActive = isActive;
		this.isValid = isValid;
	}
	
	public Idea createIdea() {
		throw new UnsupportedOperationException();
	}
	
	public boolean note(Note note) {
		throw new UnsupportedOperationException();
	}
	
	public User getUserById(Integer id) {
		throw new UnsupportedOperationException();
	}
	
	public List<User> getValidUsers(){
		throw new UnsupportedOperationException();
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "User [isActive=" + isActive + ", isValid=" + isValid + ", getName()=" + getName() + ", getEmail()="
				+ getEmail() + ", getPassword()=" + getPassword() + ", getAddress()=" + getAddress()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getSecretQuestion()=" + getSecretQuestion()
				+ ", getSecretAnswer()=" + getSecretAnswer() + ", getId()=" + getId() + "]";
	}
}
