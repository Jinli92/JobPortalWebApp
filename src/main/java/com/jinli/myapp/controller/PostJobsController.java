package com.jinli.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jinli.myapp.dao.CategoryDAO;
import com.jinli.myapp.dao.JobDAO;
import com.jinli.myapp.exception.AdException;
import com.jinli.myapp.pojo.Category;
import com.jinli.myapp.pojo.Employer;
import com.jinli.myapp.pojo.Job;



@Controller
@RequestMapping("/postJobs.htm")
public class PostJobsController {

	@RequestMapping(method=RequestMethod.POST)
	public String doSubmitAction(@ModelAttribute("job")Job job, BindingResult result, HttpServletRequest request)throws Exception{
	
        String categoryTitle = job.getCategory_name();
        String title = job.getTitle();      //get advert title user from addAdvertForm
        String description = job.getDescription();    //get user message from addAdvertForm
       
        try {
         
            CategoryDAO categories = new CategoryDAO();
            JobDAO jobDAO = new JobDAO();

            HttpSession s = request.getSession();
            Employer emp = (Employer) s.getAttribute("user");
           
           //System.out.print("_______"+check+"_______");

            //searching from database
            Category category = categories.get(categoryTitle);

            //insert a new advert
            Job j = jobDAO.createJob(title, description, emp,category.getId(),category.getTitle());

            category.addJob(j);;
            categories.save(category);

            
            s.setAttribute("categories",categories );
            
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }
	
		return "PostJobSuccess";
        
		
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("job")Job job, BindingResult result) { 
   
        return "PostJobs"; 
    }
}
