package com.topaidi.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.OneToMany;

import com.topaidi.model.roles.Admin;

public class Category {

	private int id;
	private String name;
	private Date createdAt;
	private Admin admin;
	@OneToMany(mappedBy="category")
	private ArrayList<Idea> listIdea;

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name, Date createdAt, Admin admin, ArrayList<Idea> listIdea) {
		super();
		this.id = id;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public ArrayList<Idea> getListIdea() {
		return listIdea;
	}

	public void setListIdea(ArrayList<Idea> listIdea) {
		this.listIdea = listIdea;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", dateCreate=" + createdAt + "]";
	}

}
