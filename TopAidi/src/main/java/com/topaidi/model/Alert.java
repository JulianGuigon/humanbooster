package com.topaidi.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.topaidi.abstracts.Connected;
import com.topaidi.model.roles.User;

@Entity
public class Alert {

	@Id
	@Column(name="alertId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String message;
	private String type;
	
	@ManyToOne
	private Idea ideaAlerted;
	
	@ManyToOne
	private Comment comment;
	
//	@ManyToOne
//	private Connected connectedAlerted;
	
	@ManyToOne
	private User user;

	//testRepo
	public Alert() {
		// TODO Auto-generated constructor stub
	}

	public Alert(int id, String message, String type, Idea ideaAlerted, Comment comment) {
		super();
		this.id = id;
		this.message = message;
		this.type = type;
		this.ideaAlerted = ideaAlerted;
		this.comment = comment;
	}

	public Alert getAlertById(int id) {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Alert> getAlertSortByDateCreate() {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Alert> getAlertSortByDateCreateByType(String type) {
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Idea getIdeaAlerted() {
		return ideaAlerted;
	}

	public void setIdeaAlerted(Idea ideaAlerted) {
		this.ideaAlerted = ideaAlerted;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Alert [id=" + id + ", message=" + message + ", type=" + type + "]";
	}

}
