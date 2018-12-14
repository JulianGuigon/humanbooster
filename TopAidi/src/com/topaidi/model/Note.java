package com.topaidi.model;

import com.topaidi.model.roles.User;

public class Note {

	private int id;
	private boolean isTop;
	private Idea flop;
	private Idea top;
	private User user;

	public Note() {
		// TODO Auto-generated constructor stub
	}

	public Note(int id, boolean isTop, Idea flop, Idea top, User user) {
		super();
		this.id = id;
		this.isTop = isTop;
		this.flop = flop;
		this.top = top;
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

	public Idea getFlop() {
		return flop;
	}

	public void setFlop(Idea flop) {
		this.flop = flop;
	}

	public Idea getTop() {
		return top;
	}

	public void setTop(Idea top) {
		this.top = top;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", isTop=" + isTop + "]";
	}

}
