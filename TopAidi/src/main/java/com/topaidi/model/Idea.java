package com.topaidi.model;

import java.time.LocalDate;
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
public class Idea {

	@Id
	@Column(name="ideaId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String description;
	private String picture;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	private LocalDate disabledAt;
	
	@OneToMany(mappedBy="ideaAlerted")
	private List<Alert> listAlert = new ArrayList<>();
	
	@OneToMany(mappedBy="ideaCommented")
	private List<Comment> listComment = new ArrayList<>();
	
	@ManyToOne
	private Category category;
	
	@OneToMany(mappedBy="ideaNoted")
	private List<Note> listFlop = new ArrayList<>();
	
	@OneToMany(mappedBy="ideaNoted")
	private List<Note> listTop = new ArrayList<>();
	
	@ManyToOne
	private User userSubmitting;

	public Idea() {
		// TODO Auto-generated constructor stub
	}

	public Idea(String title, String description, String picture, LocalDate createdAt, Category category, User userSubmitting) {
		super();
		this.title = title;
		this.description = description;
		this.picture = picture;
		this.createdAt = createdAt;
		this.updatedAt = null;
		this.disabledAt = null;
		this.category = category;
		this.userSubmitting = userSubmitting;
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

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDate getDisabledAt() {
		return disabledAt;
	}

	public void setDisabledAt(LocalDate disabledAt) {
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

	public User getUserSubmitting() {
		return userSubmitting;
	}

	public void setUserSubmitting(User userSubmitting) {
		this.userSubmitting = userSubmitting;
	}

	@Override
	public String toString() {
		return "Idea [id=" + id + ", title=" + title + ", description=" + description + ", picture=" + picture
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", disabledAt=" + disabledAt
				+ ", listAlert=" + listAlert + ", listComment=" + listComment + ", category=" + category + ", listFlop="
				+ listFlop + ", listTop=" + listTop + ", userSubmitting=" + userSubmitting + "]";
	}

}
