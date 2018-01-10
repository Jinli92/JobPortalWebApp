package com.jinli.myapp.dao;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.jinli.myapp.exception.AdException;
import com.jinli.myapp.pojo.Employer;
import com.jinli.myapp.pojo.Job;



public class JobDAO extends DAO{

	
	public JobDAO(){
		
	}
	
	public Job createJob(String title, String description, Employer employer,long category_id,String categoryName) throws AdException{
		
	try {
            begin();
            Job  job = new Job(title, description, employer,category_id,categoryName);
            getSession().save(job);
            commit();
            return job;
        }catch (HibernateException e) {
            rollback();
           throw new AdException("Could not add job "+e , e);
        }
        
	
	

	
}
	
	public void delete(Job job)
            throws AdException {
        try {
            begin();
            getSession().delete(job);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete job", e);
        }
    }
	
	   public Job get(String title) throws AdException{
	        
	        try {
	            begin();
	            Query q = getSession().createQuery("from Job where title = :title");
	            q.setString("title", title);
	            Job j = (Job) q.uniqueResult();
	            commit();
	            return j;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not get job " + title, e);
	        }
	   }
	
	
	
	
}
