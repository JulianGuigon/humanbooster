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
	private Integer id;
	
	@ManyToOne
	private Idea ideaNoted;
	
	@ManyToOne
	private User userNoting;
	
	private boolean isTop;

	public Note() {
		// TODO Auto-generated constructor stub
	}

	public Note(boolean isTop, Idea ideaNoted, User userNoting) {
		super();
		this.isTop = isTop;
		this.ideaNoted = ideaNoted;
		this.userNoting = userNoting;
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

	public Idea getIdeaNoted() {
		return ideaNoted;
	}

	public void setIdeaNoted(Idea ideaNoted) {
		this.ideaNoted = ideaNoted;
	}

	public User getUserNoting() {
		return userNoting;
	}

	public void setUserNoting(User userNoting) {
		this.userNoting = userNoting;
	}
	
	

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", ideaNoted=" + ideaNoted + ", userNoting=" + userNoting + ", isTop=" + isTop + "]";
	}
}
