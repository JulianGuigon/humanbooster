package com.topaidi.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.topaidi.model.roles.User;
import com.topaidi.service.interfaces.UserService;

@Component
public class UserValidator implements Validator {
	
	private UserService userService;
	
	public UserValidator(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "user.email", "This field can't be empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "user.password", "This field can't be empty.");
		if (userService.findEmailExist(user.getEmail())) {
			errors.rejectValue("email", "user.email.existing", "This email is already used.");
		}
	}

}
