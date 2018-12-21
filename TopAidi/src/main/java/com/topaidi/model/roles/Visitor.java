package com.topaidi.model.roles;

import javax.persistence.Entity;

import com.topaidi.abstracts.Role;

@Entity
public class Visitor extends Role {
	public Visitor() {
		super();
	}

	public boolean connect(String email, String password) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return "Visitor [getId()=" + getId() + "]";
	}
}
