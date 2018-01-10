package com.jinli.myapp.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.jinli.myapp.exception.AdException;
import com.jinli.myapp.pojo.Category;



public class CategoryDAO extends DAO {

    public Category get(String title) throws AdException {
        try {
            begin();
            Query q=getSession().createQuery("from Category where title= :title");
            q.setString("title",title);
            Category category=(Category)q.uniqueResult();
            commit();
            return category;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named category " + title + " " + e.getMessage());
        }
        finally{
        	close();
        }
    }

    public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Category");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the categories", e);
        }
        finally{
        	close();
        }
    }

    public Category create(String title) throws AdException {
        try {
            begin();
            Category cat = new Category(title);
            getSession().save(cat);
            commit();
            return null;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create the category", e);
            throw new AdException("Exception while creating category: " + e.getMessage());
        }
        finally{
        	close();
        }
    }

    public void save(Category category) throws AdException {
        try {
            begin();
            getSession().update(category);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not save the category", e);
        }
        finally{
        	close();
        }
    }

    public void delete(Category category) throws AdException {
        try {
            begin();
            getSession().delete(category);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete the category", e);
        }
        finally{
        	close();
        }
    }
}