package com.jinli.myapp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.jinli.myapp.exception.AdException;
import com.jinli.myapp.pojo.Employer;
import com.jinli.myapp.pojo.User;



public class EmployerDAO extends DAO {

	
	  
	public Employer VerifyEmployer(String username, String password) throws AdException{
		try{
			begin();
			
            Query q = getSession().createQuery("from Employer where username = :username and password = :password");
            q.setString("username", username);
            q.setString("password", password);
            System.out.print(username);
            System.out.print(password);
            Employer emp = (Employer) q.uniqueResult();
            commit();
            return emp;
		}
		 catch (HibernateException e) {
			 System.out.print(password);
	            rollback();
	            throw new AdException("This user doesn't exit or password is wrong", e);
	        }
		
		
	}
	
	
   public Employer get(String username) throws AdException{
	        
	        try {
	            begin();
	            Query q = getSession().createQuery("from Employer where username = :username");
	            q.setString("username", username);
	            Employer emp = (Employer) q.uniqueResult();
	            commit();
	            return emp;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not get user " + username, e);
	        }
	   }
	
	
	
	
	public Employer create(String username, String firstname, String lastname, String password,String companyname, 
			String position) throws AdException

	
    {
		
		try {
			begin();
			System.out.println("inside DAO");
   
		
			Employer em = new Employer( );
			em.setFirstname(firstname);
			em.setLastname(lastname);
			em.setUsername(username);
			em.setPassword(password);
			em.setCompanyName(companyname);
			em.setPosition(position);
			
   
			getSession().save(em);
   
			commit();
			return em;
} catch (HibernateException e) {
   rollback();
  throw new AdException("Could not create user " + username, e);

}
    }
		
		  public void save(Employer emp) throws AdException {
		        try {
		            begin();
		            getSession().update(emp);
		            commit();
		        } catch (HibernateException e) {
		            rollback();
		            throw new AdException("Could not save the employer", e);
		        }
		    }

}

	
	
	   

