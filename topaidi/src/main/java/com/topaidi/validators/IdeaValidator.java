package com.topaidi.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.topaidi.model.Idea;

public class IdeaValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Idea.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
