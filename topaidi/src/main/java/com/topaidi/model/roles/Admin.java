package com.topaidi.model.roles;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.topaidi.abstracts.Connected;
import com.topaidi.model.Address;
import com.topaidi.model.Category;

@Entity
public class Admin extends Connected {
	@OneToMany(mappedBy="adminCreating", fetch=FetchType.EAGER)
	protected List<Category> listCategoryCreated = new ArrayList<>();
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String name, String email, String password, Address address, String phoneNumber, String picture) {
		super(name, email, password, address, phoneNumber, picture);
	}
	
	public Admin(User user) {
		super(user.getName(), user.getEmail(), user.getPassword(), user.getAddress(), user.getPhoneNumber(), user.getPicture());
	}

	@Override
	public String toString() {
		return "Admin [getName()=" + getName() + ", getEmail()="
				+ getEmail() + ", getPassword()=" + getPassword() + ", getAddress()=" + getAddress()
				+ ", getPhoneNumber()=" + getPhoneNumber() + ", getSecretQuestion()=" + ", getId()=" + getId() + "]";
	}
}
