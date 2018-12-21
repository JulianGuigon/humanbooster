package com.topaidi.model.roles;

import com.topaidi.abstracts.Role;

public class Visitor extends Role {
	public Visitor() {
		// TODO Auto-generated constructor stub
	}
	
	public Visitor(int id) {
		super(id);
	}

	public boolean connect(String email, String password) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return "Visitor [getId()=" + getId() + "]";
	}
}
