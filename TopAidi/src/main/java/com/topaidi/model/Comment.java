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
	private Integer id;
	private String value;
	
	@ManyToOne
	private User userCommenting;
	
	@ManyToOne
	private Idea ideaCommented;
	
	@OneToMany(mappedBy="commentAlerted")
	private List<Alert> listAlerte = new ArrayList<>();

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(String value, User userCommenting, Idea ideaCommented) {
		super();
		this.value = value;
		this.userCommenting = userCommenting;
		this.ideaCommented = ideaCommented;
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

	public User getUserCommenting() {
		return userCommenting;
	}

	public void setUserCommenting(User userCommenting) {
		this.userCommenting = userCommenting;
	}

	public Idea getIdeaCommented() {
		return ideaCommented;
	}

	public void setIdeaCommented(Idea ideaCommented) {
		this.ideaCommented = ideaCommented;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", value=" + value + "]";
	}

}
