package com.topaidi.model.roles;

import javax.persistence.Entity;

import com.topaidi.abstracts.Role;

@Entity
public class Visitor extends Role {
	public Visitor() {
		super();
	}

	@Override
	public String toString() {
		return "Visitor [getId()=" + getId() + "]";
	}
}
