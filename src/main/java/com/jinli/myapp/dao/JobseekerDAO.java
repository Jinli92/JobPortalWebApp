package com.jinli.myapp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.jinli.myapp.exception.AdException;
import com.jinli.myapp.pojo.Employer;
import com.jinli.myapp.pojo.Jobseeker;
import com.jinli.myapp.pojo.User;

public class JobseekerDAO extends DAO{

	
	
	public JobseekerDAO(){
		
	}
	
	public Jobseeker VerifyJobseeker(String username, String password) throws AdException{
		try{
			begin();
            Query q = getSession().createQuery("from Jobseeker where username = :username and password = :password");
            q.setString("username", username);
            q.setString("password", password);
            Jobseeker js = (Jobseeker) q.uniqueResult();
            commit();
            return js;
		}
		 catch (HibernateException e) {
	            rollback();
	            throw new AdException("This user doesn't exit or password is wrong", e);
	        }
		finally{
			close();
		}
		
	}
	
	
	
	
	
	public Jobseeker create(String firstname, String lastname,String username, String password, String school, 
			String major) throws AdException

	
    {
		
		try {
			begin();
			System.out.println("inside DAO");
   
		
   
			Jobseeker js = new Jobseeker();
			js.setFirstname(firstname);
			js.setLastname(lastname);
			js.setUsername(username);
			js.setPassword(password);
			js.setSchool(school);
			js.setMajor(major);
			
   
			getSession().save(js);
   
			commit();
			return js;
} catch (HibernateException e) {
   rollback();
  throw new AdException("Could not create user " + username, e);

}
		finally{
			close();
		}

}
	
	
	
	  public void save(Jobseeker js) throws AdException {
	        try {
	            begin();
	            System.out.println("into save()-------"+js.getUsername());
	            getSession().update(js);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not save the jobseeker", e);
	        }
	        finally{
				close();
			}
	    }
	
	  public Jobseeker get(String username) throws AdException{
	        
	        try {
	            begin();
	            Query q = getSession().createQuery("from Jobseeker where username = :username");
	            q.setString("username", username);
	            Jobseeker js = (Jobseeker) q.uniqueResult();
	            commit();
	            return js;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not get jobseeker " + username, e);
	        }
	        finally{
				close();
			}
	   }
	
	
}
