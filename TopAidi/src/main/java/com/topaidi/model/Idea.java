package com.topaidi.model;

import java.util.ArrayList;
import java.util.Date;
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
public class Idea {

	@Id
	@Column(name="ideaId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private String picture;
	private Date createdAt;
	private Date updatedAt;
	private Date disabledAt;
	
	@OneToMany(mappedBy="ideaAlerted")
	private List<Alert> listAlert = new ArrayList<>();
	
	@OneToMany(mappedBy="idea")
	private List<Comment> listComment = new ArrayList<>();
	
	@ManyToOne
	private Category category;
	
	@OneToMany(mappedBy="idea")
	private List<Note> listFlop = new ArrayList<>();
	
	@OneToMany(mappedBy="idea")
	private List<Note> listTop = new ArrayList<>();
	
	@ManyToOne
	private User user;

	public Idea() {
		// TODO Auto-generated constructor stub
	}

	public Idea(int id, String title, String description, String picture, Date createdAt, Date updatedAt,
			Date disabledAt, List<Alert> listAlert, List<Comment> listComment, Category category,
			List<Note> listFlop, List<Note> listTop, User user) {
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

	public List<Idea> getIdeaSortByDateCreate() {
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

	public List<Alert> getListAlert() {
		return listAlert;
	}

	public void setListAlert(List<Alert> listAlert) {
		this.listAlert = listAlert;
	}

	public List<Comment> getListComment() {
		return listComment;
	}

	public void setListComment(List<Comment> listComment) {
		this.listComment = listComment;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Note> getListFlop() {
		return listFlop;
	}

	public void setListFlop(List<Note> listFlop) {
		this.listFlop = listFlop;
	}

	public List<Note> getListTop() {
		return listTop;
	}

	public void setListTop(List<Note> listTop) {
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
