package com.jinli.myapp.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jinli.myapp.dao.CategoryDAO;
import com.jinli.myapp.exception.AdException;
import com.jinli.myapp.pojo.Category;
import com.jinli.myapp.pojo.Job;

@Controller
@RequestMapping("/searchJob.htm")
public class SerachJobController {

	@RequestMapping(method=RequestMethod.POST)
	public String doSearch(HttpServletRequest request, HttpServletResponse response) throws AdException{
		String way = request.getParameter("way");
		
			System.out.println("-----------"+way);
			
	
	
		if(way.equals("cate")){
			System.out.println("-----------");
			String categoryName = request.getParameter("cateName");
			System.out.println(categoryName);
			CategoryDAO cateDAO = new CategoryDAO();
			Category category = cateDAO.get(categoryName) ;
			category.getJobs();
			HttpSession s = request.getSession();
			s.setAttribute("category", category.getJobs());
		
		}
	

		if(way.equals("title")){
			System.out.println("-----------");
			String title = request.getParameter("jobtitle");
			System.out.println(title);
			
			CategoryDAO cateDAO = new CategoryDAO();
			List<Category> categoryList = cateDAO.list();
			
			Set<Job> joblist = new HashSet<Job>();
			
			for(Category cate: categoryList){
				for(Job job:cate.getJobs()){
					if(job.getTitle().contains(title)){
						joblist.add(job);
						
					}
					
				}
				
			}
			HttpSession s = request.getSession();
			s.setAttribute("category", joblist);
		
		}
		
		return "DisplayJobs";
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String jumpToSearch(HttpServletRequest request, HttpServletResponse response){
		
		return "SearchJob";
		
	}
}
