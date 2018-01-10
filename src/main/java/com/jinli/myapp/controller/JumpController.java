package com.jinli.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jinli.myapp.pojo.Employer;
import com.jinli.myapp.pojo.Jobseeker;

@Controller
@RequestMapping("/jump.htm")
public class JumpController {
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("inside login method");
		String action = hsr.getParameter("a");
		if(action.equals("login")){
		mv.setViewName("Login");
		HttpSession session = hsr.getSession();
		session.setAttribute("fail", "false");
		session.setAttribute("signfail", "false");
		}
		
		if(action.equals("signup")){
			mv.setViewName("SignupPage");
			HttpSession session = hsr.getSession();
			
			session.setAttribute("signfail", "false");
			Employer employer = new Employer();
			mv.addObject(employer);
			
			Jobseeker jobseeker = new Jobseeker();
			mv.addObject(jobseeker);
			}
	
		return mv;
	}
}
