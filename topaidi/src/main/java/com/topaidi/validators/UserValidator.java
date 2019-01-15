package com.topaidi.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.topaidi.model.roles.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "user.email", "This field can't be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "user.password", "This field can't be empty.");
	}

}
