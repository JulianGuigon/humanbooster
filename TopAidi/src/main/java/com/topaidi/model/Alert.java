package com.topaidi.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.topaidi.enums.AlertType;
import com.topaidi.model.roles.User;

@Entity
public class Alert {

	@Id
	@Column(name="alertId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String message;
	private AlertType alertType;
	
	@ManyToOne
	private Idea ideaAlerted;
	
	@ManyToOne
	private Comment commentAlerted;
	
	@ManyToOne
	private User userAlerting;
	
	public Alert() {
		// TODO Auto-generated constructor stub
	}

	public Alert(String message, Comment commentAlerted, User userAlerting) {
		super();
		this.message = message;
		this.alertType = AlertType.Comment;
		this.ideaAlerted = null;
		this.commentAlerted = commentAlerted;
		this.userAlerting = userAlerting;
	}
	
	public Alert(String message, Idea ideaAlerted, User userAlerted) {
		super();
		this.message = message;
		this.alertType = AlertType.Idea;
		this.ideaAlerted = ideaAlerted;
		this.commentAlerted = null;
		this.userAlerting = userAlerted;
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

	public AlertType getAlertType() {
		return alertType;
	}

	public void setAlertType(AlertType alertType) {
		this.alertType = alertType;
	}

	public Idea getIdeaAlerted() {
		return ideaAlerted;
	}

	public void setIdeaAlerted(Idea ideaAlerted) {
		this.ideaAlerted = ideaAlerted;
	}

	public Comment getCommentAlerted() {
		return commentAlerted;
	}

	public void setCommentAlerted(Comment commentAlerted) {
		this.commentAlerted = commentAlerted;
	}

	public User getUserAlerting() {
		return userAlerting;
	}

	public void setUserAlerting(User userAlerting) {
		this.userAlerting = userAlerting;
	}

	@Override
	public String toString() {
		return "Alert [id=" + id + ", message=" + message + ", alertType=" + alertType + ", ideaAlerted=" + ideaAlerted
				+ ", commentAlerted=" + commentAlerted + ", userAlerting=" + userAlerting + "]";
	}

}
