package com.jinli.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jinli.myapp.dao.JobDAO;
import com.jinli.myapp.exception.AdException;
import com.jinli.myapp.pojo.Job;

@Controller
@RequestMapping("/viewJobs.htm")
public class ViewJobsController {
	
	

	@RequestMapping(method=RequestMethod.POST)
	public String deleteJob(HttpServletRequest request, HttpServletResponse response){
		
		return "ViewJobs";
		
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String JumpToViewJob(HttpServletRequest request, HttpServletResponse response) throws AdException{
		String jobname = request.getParameter("jobname");
		if(jobname!=null){
		JobDAO jobDAO = new JobDAO();
		Job j = jobDAO.get(jobname);
		jobDAO.delete(j);
		
		return "AdminViewJobs";
	}
		else
		return "ViewJobs";
}
}
