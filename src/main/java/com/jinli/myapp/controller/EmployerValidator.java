package com.jinli.myapp.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jinli.myapp.pojo.Employer;






	public class EmployerValidator implements Validator {

	    public boolean supports(Class aClass)
	    {
	        return aClass.equals(Employer.class);
	    }

	    public void validate(Object obj, Errors errors)
	    {
	        Employer e = (Employer) obj;
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.invalid.user", "First Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "error.invalid.user", "Last Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "error.invalid.companyName", "Company Name Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "position", "error.invalid.position", "Position Required");
	    }
	}


