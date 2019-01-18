package com.topaidi.model.roles;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.topaidi.abstracts.Connected;
import com.topaidi.model.Address;
import com.topaidi.model.Alert;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;
import com.topaidi.model.Note;

@Entity
@Table(name="Uzer")
public class User extends Connected {
	private boolean isActive = false;
	private boolean isValid = false;
	
	@OneToMany(mappedBy="userCommenting")
	private List<Comment> listComment = new ArrayList<>();
	
	@OneToMany(mappedBy="userNoting")
	private List<Note> listNote = new ArrayList<>();
	
	@OneToMany(mappedBy="userSubmitting")
	private List<Idea> listIdea = new ArrayList<>();
	
	@OneToMany(mappedBy="userAlerting")
	private List<Alert> listAlert = new ArrayList<>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email, String password, Address address, String phoneNumber, String picture, boolean isActive, boolean isValid) {
		super(name, email, password, address, phoneNumber, picture);
		this.isActive = isActive;
		this.isValid = isValid;
	}
	
	public boolean note(Note note) {
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
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getSecretQuestion()=" + ", getId()=" + getId() + "]";
	}
}
