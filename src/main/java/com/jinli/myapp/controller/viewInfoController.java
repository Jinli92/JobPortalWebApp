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
@RequestMapping("/viewInfo.htm")
public class viewInfoController {

	
	
	@RequestMapping(method=RequestMethod.GET)
	public String viewInfo(HttpServletRequest request, HttpServletResponse response) throws AdException{
		
		String name =request.getParameter("name");
		System.out.println(name);
		JobseekerDAO jsDAO = new JobseekerDAO();
		
		Jobseeker jobseeker =jsDAO.get(name);
		if(jobseeker==null){
			return "ViewMessages";
		}
		else{
			HttpSession s = request.getSession();
			s.setAttribute("viewjs", jobseeker);
		return "ViewPersonalInfo";
		}
	}
}
