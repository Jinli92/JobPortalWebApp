package com.jinli.myapp.dao;



import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.jinli.myapp.exception.AdException;
import com.jinli.myapp.pojo.Jobseeker;
import com.jinli.myapp.pojo.User;

public class UserDAO extends DAO {

    public UserDAO() {
    }

    public User get(String username)
             {
    	User user = null;
        try {
            begin();
            Query q = getSession().createQuery("from User where name = :username");
            q.setString("username", username);
            user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not get user " + username, e);
        }
        finally{
			close();
		}
		return user;
    }

    public User getbyId(long id)
    {
User user = null;
try {
   begin();
   Query q = getSession().createQuery("from User where id = :id");
   q.setLong("id", id);
   user = (User) q.uniqueResult();
   commit();
   return user;
} catch (HibernateException e) {
   rollback();
   //throw new AdException("Could not get user " + username, e);
}
finally{
	close();
}
return user;
}
    
    
    public User create(String username, String password, String firstName, String lastName)
             {
    	User user=null;
        try {
            begin();
            System.out.println("inside DAO");
            
           
            user=new User(username,password);
            
            user.setFirstname(firstName);
            user.setLastname(lastName);
            
            
            getSession().save(user);
            
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            //throw new AdException("Exception while creating user: " + e.getMessage());
        }
        finally{
			close();
		}
		return user;
    }

    public void delete(User user)
             {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not delete user " + user.getName(), e);
        }
        finally{
			close();
		}
    }
    
    
    public void save(User user) throws AdException {
        try {
            begin();
            getSession().update(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not save the user", e);
        }
        finally{
			close();
		}
    }
    
    
}