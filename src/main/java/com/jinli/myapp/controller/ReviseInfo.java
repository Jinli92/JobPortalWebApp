package com.jinli.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jinli.myapp.dao.JobseekerDAO;
import com.jinli.myapp.exception.AdException;
import com.jinli.myapp.pojo.Jobseeker;

@Controller
@RequestMapping("/reviseInfo.htm")
public class ReviseInfo {
	
	@RequestMapping(method=RequestMethod.POST)
	public String doRevise(HttpServletRequest request, HttpServletResponse response){
		String newschool = (String)request.getParameter("school");
		String newMajor = (String)request.getParameter("major");
		String newintro = (String)request.getParameter("introduction");
		
		HttpSession s = request.getSession();
		Jobseeker js = (Jobseeker)s.getAttribute("user");
		js.setIntroduction(newintro);
		js.setMajor(newMajor);
		js.setSchool(newschool);
		
		JobseekerDAO jsDAO = new JobseekerDAO();
		
		try {
			jsDAO.save(js);
		} catch (AdException e) {
			
			e.printStackTrace();
		}
		
		return "SuccessRevise";

		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String jumpToRevise(){
		
		return "ReviseInfo";
	}
	
	
}
