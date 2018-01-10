package com.jinli.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/adminviewJobs.htm")
public class AdminViewJobsController {

	
	@RequestMapping(method=RequestMethod.GET)
	public String JumpToViewJob(HttpServletRequest request, HttpServletResponse response) {
		
		return "AdminViewJobs";
		
	}
}
