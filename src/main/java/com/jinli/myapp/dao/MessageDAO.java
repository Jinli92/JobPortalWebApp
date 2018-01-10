package com.jinli.myapp.dao;

import org.hibernate.HibernateException;

import com.jinli.myapp.exception.AdException;

import com.jinli.myapp.pojo.Message;
import com.jinli.myapp.pojo.User;

public class MessageDAO extends DAO{

	
	public Message create(String context, User user) throws AdException

    {
		
		try {
			begin();
			System.out.println("inside DAO");
  
			Message message = new Message(context);
		
			message.setSender(user.getUserId());
			
			System.out.println(message.getTime()+message.getContext()+user.getUsername());
			
   
			getSession().save(message);
   
			commit();
			return message;
			
} catch (HibernateException e) {
   rollback();
  throw new AdException("Could not add message "+e , e);
   
}
		
}

}
