package com.jinli.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jinli.myapp.dao.AdminDAO;
import com.jinli.myapp.dao.EmployerDAO;
import com.jinli.myapp.dao.JobseekerDAO;
import com.jinli.myapp.pojo.Admin;
import com.jinli.myapp.pojo.Employer;
import com.jinli.myapp.pojo.Jobseeker;

@Controller
@RequestMapping("/login.htm")
public class LoginController {
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
		
		ModelAndView mv =  new ModelAndView();
		
		String username = hsr.getParameter("username");
		String password = hsr.getParameter("password");
		String identity = hsr.getParameter("identity");
		
		HttpSession session = hsr.getSession();
		
		if(identity.equals("jobseeker")){
			JobseekerDAO jsDAO = new JobseekerDAO();
			Jobseeker js = jsDAO.VerifyJobseeker(username, password);
			System.out.println("equals jobseeker!=========");
			
			if(js!=null){
			
			session.setAttribute("user", js);
			
			mv.setViewName("PersonalHomePage");
			}
			else{
				session.setAttribute("fail", "true");
				mv.setViewName("Login");
			}
		}
		
		if(identity.equals("employer")){
			
			EmployerDAO empDAO = new EmployerDAO();
			Employer emp = empDAO.VerifyEmployer(username, password);
			if(emp!=null){
			
			session.setAttribute("user", emp);
			mv.setViewName("EmpHomePage");
			}
			else{
				session.setAttribute("fail", "true");
				mv.setViewName("Login");
			}
		
			
			
		}
		if(identity.equals("admin")){
			
			AdminDAO adminDAO = new AdminDAO();
			Admin admin = adminDAO.VerifyAdmin(username, password);
			
			if(admin!=null){
			session.setAttribute("user", admin);
			
			mv.setViewName("AdminHomePage");
			}
		}
	
		
		
		return mv;
	
        
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView Login(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception{
		ModelAndView mav =  new ModelAndView();
		mav.setViewName("Login");
		return mav;
		
		
	}
	
	
	
}
