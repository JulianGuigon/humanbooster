package com.topaidi.abstracts;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.topaidi.model.Address;
import com.topaidi.model.Comment;
import com.topaidi.model.Idea;

@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Connected extends Role{
	private String name;
	private String email;
	private String password;
	@ManyToOne
	private Address address;
	private String phoneNumber;
	private String secretQuestion;
	private String secretAnswer;
	
	public Connected() {
		// TODO Auto-generated constructor stub
	}
	
	public Connected(String name, String email, String password, Address address, String phoneNumber, String secretQuestion, String secretAnswer) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
	}
	
	public boolean alert(Idea idea) {
		throw new UnsupportedOperationException();
	}
	
	public boolean alert(Comment comment) {
		throw new UnsupportedOperationException();
	}
	
	public boolean comment(Comment comment) {
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	@Override
	public String toString() {
		return "Connected [name=" + name + ", email=" + email + ", password=" + password + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", secretQuestion=" + secretQuestion + ", secretAnswer="
				+ secretAnswer + "]";
	}
}
