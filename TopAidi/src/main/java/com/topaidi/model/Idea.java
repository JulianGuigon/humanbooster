package com.topaidi.model;

import java.util.ArrayList;
import java.util.Date;

import com.topaidi.model.roles.User;

public class Idea {

	private int id;
	private String title;
	private String description;
	private String picture;
	private Date createdAt;
	private Date updatedAt;
	private Date disabledAt;
	private ArrayList<Alert> listAlert;
	private ArrayList<Comment> listComment;
	private Category category;
	private ArrayList<Note> listFlop;
	private ArrayList<Note> listTop;
	private User user;

	public Idea() {
		// TODO Auto-generated constructor stub
	}

	public Idea(int id, String title, String description, String picture, Date createdAt, Date updatedAt,
			Date disabledAt, ArrayList<Alert> listAlert, ArrayList<Comment> listComment, Category category,
			ArrayList<Note> listFlop, ArrayList<Note> listTop, User user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.picture = picture;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.disabledAt = disabledAt;
		this.listAlert = listAlert;
		this.listComment = listComment;
		this.category = category;
		this.listFlop = listFlop;
		this.listTop = listTop;
		this.user = user;
	}

	public boolean isNotable() {
		throw new UnsupportedOperationException();
	}

	public boolean isNotable(User user) {
		throw new UnsupportedOperationException();
	}

	public Idea getIdeaById(int id) {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Idea> getIdeaSortByDateCreate() {
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDisabledAt() {
		return disabledAt;
	}

	public void setDisabledAt(Date disabledAt) {
		this.disabledAt = disabledAt;
	}

	public ArrayList<Alert> getListAlert() {
		return listAlert;
	}

	public void setListAlert(ArrayList<Alert> listAlert) {
		this.listAlert = listAlert;
	}

	public ArrayList<Comment> getListComment() {
		return listComment;
	}

	public void setListComment(ArrayList<Comment> listComment) {
		this.listComment = listComment;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ArrayList<Note> getListFlop() {
		return listFlop;
	}

	public void setListFlop(ArrayList<Note> listFlop) {
		this.listFlop = listFlop;
	}

	public ArrayList<Note> getListTop() {
		return listTop;
	}

	public void setListTop(ArrayList<Note> listTop) {
		this.listTop = listTop;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Idea [id=" + id + ", title=" + title + ", description=" + description + ", picture=" + picture
				+ ", dateCreate=" + createdAt + ", dateLastEdit=" + updatedAt + ", dateDisable=" + disabledAt
				+ "]";
	}

}
