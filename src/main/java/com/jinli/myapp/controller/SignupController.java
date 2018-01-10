package com.jinli.myapp.controller;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jinli.myapp.dao.EmployerDAO;
import com.jinli.myapp.dao.UserDAO;
import com.jinli.myapp.exception.AdException;
import com.jinli.myapp.pojo.Employer;
import com.jinli.myapp.pojo.User;


@Controller
@RequestMapping("/signup.htm")
public class SignupController {
//@Autowired
//@Qualifier("employerValidator")
//EmployerValidator validator;
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("employer") Employer employer, BindingResult result,HttpServletRequest request) throws Exception {
//	validator.validate(employer, result);
		
	if (employer.getUsername().equals("")||employer.getPassword().equals("")) {
		
			return "SignupFail";
		}
	
	else{
	try {
		
			EmployerDAO empDao = new EmployerDAO();
			
			
			
			Employer user = empDao.create(employer.getUsername(),employer.getFirstname(),employer.getLastname(),employer.getPassword()
					,employer.getCompanyName(),employer.getPosition());
			HttpSession s= request.getSession();
			s.setAttribute("user", user);
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}


		return "SignupSuccess";
		
	}
	}

	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("employer") Employer employer, BindingResult result) { 
   
        return "SignupPage"; 
    } 
	
	
}
