package com.jinli.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.jinli.myapp.dao.JobseekerDAO;
import com.jinli.myapp.dao.UserDAO;
import com.jinli.myapp.exception.AdException;

import com.jinli.myapp.pojo.Jobseeker;
import com.jinli.myapp.pojo.User;


@Controller
@RequestMapping("/signup1.htm")
public class SignupController2 {
//	@Autowired
//	@Qualifier("employerValidator")
//	EmployerValidator validator;
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("jobseeker") Jobseeker jobseeker, BindingResult result,HttpServletRequest request) throws Exception {
		//validator.validate(employer, result);
	System.out.println(jobseeker.getUsername());
		if (jobseeker.getUsername().equals("")||jobseeker.getPassword().equals("")) {
			
			return "SignupFail";
		}
		else{
	try {
		
			JobseekerDAO jsDao = new JobseekerDAO();
			
			
			Jobseeker js = jsDao.create(jobseeker.getFirstname(),jobseeker.getLastname(),jobseeker.getUsername(),jobseeker.getPassword()
					,jobseeker.getSchool(), jobseeker.getMajor());
			
			HttpSession s= request.getSession();
			s.setAttribute("user", js);
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}


		return "SignupSuccess";
		
	}
	}

	
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("jobseeker") Jobseeker jobseeker, BindingResult result) { 
   
        return " "; 
    } 
	

}
