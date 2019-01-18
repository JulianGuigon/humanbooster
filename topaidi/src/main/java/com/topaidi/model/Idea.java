package com.topaidi.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	private boolean isActive = true;
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy="ideaAlerted", fetch=FetchType.EAGER)
	private List<Alert> listAlert = new ArrayList<>();
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy="ideaCommented", fetch=FetchType.EAGER)
	private List<Comment> listComment = new ArrayList<>();
	
	@ManyToOne
	private Category category;
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy="ideaNoted", fetch=FetchType.EAGER)
	private List<Note> listNote = new ArrayList<>();
	
	@ManyToOne
	private User userSubmitting;

	public Idea() {
		this.createdAt = LocalDate.now();
		this.updatedAt = null;
		this.disabledAt = null;
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
		int dayDifference = LocalDate.now().getDayOfMonth() - this.createdAt.getDayOfMonth();
		if(dayDifference > 7) {
			return false;
		}else {
			return true;
		}
	}
	
	public Integer getNbFlop() {
		Integer nbFlop = 0;
		for (Note n : this.listNote) {
			if (!n.isTop()) {
				nbFlop++;
			}
		}
		return nbFlop;
	}
	
	public Integer getNbTop() {
		Integer nbTop = 0;
		for (Note n : this.listNote) {
			if (n.isTop()) {
				nbTop++;
			}
		}
		return nbTop;
	}
	
	public Integer getId() {
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

	public List<Note> getListNote() {
		return listNote;
	}

	public void setListNote(List<Note> listNote) {
		this.listNote = listNote;
	}

	public User getUserSubmitting() {
		return userSubmitting;
	}

	public void setUserSubmitting(User userSubmitting) {
		this.userSubmitting = userSubmitting;
	}
	

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	@Override
//	public String toString() {
//		return "Idea [id=" + id + ", title=" + title + ", description=" + description + ", picture=" + picture
//				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", disabledAt=" + disabledAt + ", isActive="
//				+ isActive + ", listAlert=" + listAlert + ", listComment=" + listComment + ", category=" + category
//				+ ", listNote=" + listNote + ", userSubmitting=" + userSubmitting + "]";
//	}

	

}
