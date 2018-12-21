package com.topaidi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.topaidi.model.roles.User;

@Entity
public class Comment {

	@Id
	@Column(name="commentId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String value;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Idea idea;
	
	@OneToMany(mappedBy="comment")
	private List<Alert> listAlerte = new ArrayList<>();

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
