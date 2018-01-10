package com.jinli.myapp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.jinli.myapp.exception.AdException;
import com.jinli.myapp.pojo.Admin;
import com.jinli.myapp.pojo.Employer;
import com.jinli.myapp.pojo.Jobseeker;

public class AdminDAO extends DAO{

	public AdminDAO(){
		
		
	}
	  
	public Admin VerifyAdmin(String username, String password) throws AdException{
		try{
			begin();
			
            Query q = getSession().createQuery("from Admin where username = :username and password = :password");
            q.setString("username", username);
            q.setString("password", password);
            System.out.print(username);
            System.out.print(password);
            Admin a = (Admin) q.uniqueResult();
            commit();
            return a;
		}
		 catch (HibernateException e) {
			 System.out.print(password);
	            rollback();
	            throw new AdException("This user doesn't exit or password is wrong"+e, e);
	        }
		
		
	}
	
	
	  public Admin get(String username) throws AdException{
	        
	        try {
	            begin();
	            System.out.println("into find user()-------");
	            Query q = getSession().createQuery("from Admin where username = :username");
	            q.setString("username", username);
	            Admin ad = (Admin) q.uniqueResult();
	            commit();
	            return ad;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not get admin " + username, e);
	        }
	        finally{
				close();
			}
	   }
	  
	  
	  
	  public void save(Admin ad) throws AdException {
	        try {
	            begin();
	            System.out.println("into save()-------"+ad.getUsername());
	            getSession().update(ad);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not save the ad", e);
	        }
	        finally{
				close();
			}
	    }
	
	
}
