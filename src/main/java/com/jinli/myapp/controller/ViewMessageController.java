package com.jinli.myapp.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jinli.myapp.pojo.User;

@Controller
@RequestMapping("/viewMessage.htm")
public class ViewMessageController {

	@RequestMapping(method=RequestMethod.POST)
	public String replyMessage(HttpServletRequest request, HttpServletResponse response){
		
		
		return " ";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String jumpToView(HttpServletRequest request, HttpServletResponse response){
		HttpSession  session =request.getSession();
		User user = (User)session.getAttribute("user");
		System.out.println("=========="+user.getUsername());
	Set<com.jinli.myapp.pojo.Message> messageList = user.getMessageList();
    for(com.jinli.myapp.pojo.Message m: messageList){
	System.out.println("=========="+m.getContext());
	
	}
	session.setAttribute("messageList", messageList);
    	
		return "ViewMessages";
	}
	
	
}
