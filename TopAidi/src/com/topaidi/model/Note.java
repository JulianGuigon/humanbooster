package com.topaidi.model;

import com.topaidi.model.roles.User;

public class Note {

	private int id;
	private Idea idea;
	private User user;
	private boolean isTop;

	public Note() {
		// TODO Auto-generated constructor stub
	}

	public Note(int id, boolean isTop, Idea idea, User user) {
		super();
		this.id = id;
		this.isTop = isTop;
		this.idea = idea;
		this.user = user;
	}


	public Note getNoteById(int id) {
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isTop() {
		return isTop;
	}

	public void setTop(boolean isTop) {
		this.isTop = isTop;
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", isTop=" + isTop + ", idea=" + idea + ", user=" + user + "]";
	}
}
