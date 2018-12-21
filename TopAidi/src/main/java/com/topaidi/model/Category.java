package com.topaidi.model;

import java.time.LocalDate;
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
	private int id;
	private String name;
	private LocalDate createdAt;
	@ManyToOne
	private Admin admin;
	@OneToMany(mappedBy="category")
	private List<Idea> listIdea;

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String name, Date createdAt, Admin admin, List<Idea> listIdea) {
		super();
		this.name = name;
		this.createdAt = createdAt;
		this.admin = admin;
		this.listIdea = listIdea;
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Idea> getListIdea() {
		return listIdea;
	}

	public void setListIdea(List<Idea> listIdea) {
		this.listIdea = listIdea;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", dateCreate=" + createdAt + "]";
	}

}
