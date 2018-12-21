package com.topaidi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.topaidi.model.roles.User;

@Entity
public class Note {

	@Id
	@Column(name="noteId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Idea idea;
	
	@ManyToOne
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
