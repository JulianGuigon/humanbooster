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

import com.topaidi.model.roles.Admin;

@Entity
public class Category {
	@Id
	@Column(name="categoryId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private LocalDate createdAt;
	@ManyToOne
	private Admin adminCreating;
	@OneToMany(mappedBy="category")
	private List<Idea> listIdea = new ArrayList<Idea>();

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String name, LocalDate createdAt, Admin adminCreating) {
		super();
		this.name = name;
		this.createdAt = createdAt;
		this.adminCreating = adminCreating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public Admin getAdminCreating() {
		return adminCreating;
	}

	public void setAdminCreating(Admin adminCreating) {
		this.adminCreating = adminCreating;
	}

	public List<Idea> getListIdea() {
		return listIdea;
	}

	public void setListIdea(List<Idea> listIdea) {
		this.listIdea = listIdea;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", adminCreating=" + adminCreating
				+ ", listIdea=" + listIdea + "]";
	}

}
