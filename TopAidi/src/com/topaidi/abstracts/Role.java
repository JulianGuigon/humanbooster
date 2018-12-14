package com.topaidi.abstracts;

public class Role {
	private int id;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + "]";
	}
}
