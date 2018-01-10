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
import com.jinli.myapp.dao.MessageDAO;
import com.jinli.myapp.dao.UserDAO;
import com.jinli.myapp.exception.AdException;
import com.jinli.myapp.pojo.Admin;
import com.jinli.myapp.pojo.Employer;
import com.jinli.myapp.pojo.Jobseeker;
import com.jinli.myapp.pojo.Message;
import com.jinli.myapp.pojo.User;

@Controller
@RequestMapping("/sendmessage.htm")
public class SendMessageController {

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView doSendMessage(HttpServletRequest request, HttpServletResponse response) throws AdException{
		ModelAndView mv = new ModelAndView();
		HttpSession s = request.getSession();
		String identity = (String)request.getParameter("identity");
		
		String content = (String) request.getParameter("content");
	
		User u = (User)s.getAttribute("user");
		System.out.println(u.getUsername()+"<---------");
		
		if(identity.equals("jobseeker")){
			String receiver = (String)request.getParameter("receiver");
			JobseekerDAO jsDAO = new JobseekerDAO();
			
				Jobseeker j = jsDAO.get(receiver);
				if(j!=null){
					
				
					
					MessageDAO mDao = new MessageDAO();
					
					
					Message message = mDao.create(content, u);
					
					message.setSender(u.getUserId());
					message.setReceiver(j);
					
					System.out.println(message.getReceiver().getUsername()+"<---------receiver is");
					jsDAO.save(j);
					
					s.setAttribute("message", message);
					mv.setViewName("SendMessageSuccess");
					
			}
				else{
					
					mv.setViewName("SendFail");
				}
				
			
		}	
		
		
		if(identity.equals("admin")){
			String receiver = (String)request.getAttribute("receiver");
			AdminDAO adminDAO = new AdminDAO();
			
				Admin admin = adminDAO.get(receiver);
				if(admin!=null){
					
					
					
					MessageDAO mDao = new MessageDAO();
					
					
					Message message = mDao.create(content, u);
					message.setSender(u.getUserId());
					message.setReceiver(admin);
					
					adminDAO.save(admin);
					
					s.setAttribute("message", message);
					mv.setViewName("SendMessageSuccess");
						
		}	
else{
					
	mv.setViewName("SendFail");
				}
		}
		
		
		if(identity.equals("employer")){
			String receiver = (String)request.getAttribute("receiver");
			EmployerDAO employerDAO= new EmployerDAO();
			
				Employer emp = employerDAO.get(receiver);
				if(emp!=null){
					
					
					
					MessageDAO mDao = new MessageDAO();
					
					
					Message message = mDao.create(content, u);
					message.setSender(u.getUserId());
					message.setReceiver(emp);
					
					employerDAO.save(emp);
					
					s.setAttribute("message", message);
					mv.setViewName("SendMessageSuccess");
						
		}	
else{
					
	mv.setViewName("SendFail");
				}
		}
			
		
		
			
		
		return mv;
		}
		
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String jumpToSendMessage(HttpServletRequest request, HttpServletResponse response){
		
		return "SendMessage";
	}
	
	
}
