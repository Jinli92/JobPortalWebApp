package com.jinli.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jinli.myapp.dao.EmployerDAO;
import com.jinli.myapp.dao.MessageDAO;
import com.jinli.myapp.exception.AdException;
import com.jinli.myapp.pojo.Employer;
import com.jinli.myapp.pojo.Message;
import com.jinli.myapp.pojo.User;

@Controller
@RequestMapping("/contactEmployer.htm")
public class ContactController {

	@RequestMapping(method=RequestMethod.POST)
	public String ContactEmployer(@ModelAttribute("message") Message message, BindingResult result,HttpServletRequest request,HttpServletResponse response){
		try {
			
			MessageDAO mDao = new MessageDAO();
			
			HttpSession s = request.getSession();
			User user = (User) s.getAttribute("user");
			
			System.out.println("1------->"+user.getUsername());
			String empName = (String)s.getAttribute("empName");
			EmployerDAO empDAO = new EmployerDAO();
			Employer e = empDAO.get(empName);
			
			System.out.println("2------->"+e.getUsername());
		
			Message m = mDao.create(message.getContext(),user);
			
			
			m.setSender(user.getUserId());
			m.setReceiver(e);
			
			empDAO.save(e);
			s.setAttribute("message", m);
			System.out.println("3------->"+m.getContext());

		
			
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return "SendMessageSuccess";
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String JumpToContactController(@ModelAttribute("message") Message message,HttpServletRequest request,HttpServletResponse response){
		
		String empName = request.getParameter("name");
		HttpSession s = request.getSession();
		s.setAttribute("empName", empName);
		return "ContactEmployer";
		
		
	}
}
