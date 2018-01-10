package com.jinli.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/KindsofJobs.htm")
public class FindJob {
	@RequestMapping(method=RequestMethod.GET)
	public String getmethod(HttpServletRequest request,HttpServletResponse response){
	/*String [] jobs = new String[5];
	
	jobs[0] = "Athlets";
	jobs[1] = "SoftwareEngineer";
	jobs[2] = "ElectronicEnginer";
	jobs[3] = "DD";
	jobs[4] = "WW";

	
	String job = request.getParameter("q");	
		//I am using UL/LI to return the data to xmlHttp object. Could be anything.
	String result = "<UL>";
	for (String currentJob : jobs)   //new for loop
	{
		if (currentJob.contains(job))
		{
			result += "<LI>" + currentJob + "</LI>";
		}
	}
	result += "</UL>";
	
	System.out.println(result);   //send this to xmlHttp
	*/
		return "KindsofJobs";
}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public void postmethod(HttpServletRequest request,HttpServletResponse response){
		
	}
}
