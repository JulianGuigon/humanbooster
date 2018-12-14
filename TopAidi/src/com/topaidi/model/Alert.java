package com.topaidi.model;

import java.util.ArrayList;

import com.topaidi.abstracts.Connected;

public class Alert {

	private int id;
	private String message;
	private String type;
	private Idea ideaAlerted;
	private Comment comment;
	private Connected connectedAlerted;

	public Alert() {
		// TODO Auto-generated constructor stub
	}

	public Alert(int id, String message, String type, Idea ideaAlerted, Comment comment, Connected connectedAlerted) {
		super();
		this.id = id;
		this.message = message;
		this.type = type;
		this.ideaAlerted = ideaAlerted;
		this.comment = comment;
		this.connectedAlerted = connectedAlerted;
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

	public Connected getConnectedAlerted() {
		return connectedAlerted;
	}

	public void setConnectedAlerted(Connected connectedAlerted) {
		this.connectedAlerted = connectedAlerted;
	}

	@Override
	public String toString() {
		return "Alert [id=" + id + ", message=" + message + ", type=" + type + "]";
	}

}
