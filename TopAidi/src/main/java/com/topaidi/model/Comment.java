package com.topaidi.model;

import com.topaidi.model.roles.User;

public class Comment {

	private int id;
	private String value;
	private User user;
	private Idea idea;
	//TODO voir pour lien entre comment > alert

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int id, String value, User user, Idea idea) {
		super();
		this.id = id;
		this.value = value;
		this.user = user;
		this.idea = idea;
	}

	public Comment getCommentById(int id) {
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", value=" + value + "]";
	}

}
