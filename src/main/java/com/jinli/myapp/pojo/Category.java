package com.jinli.myapp.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="categorytable")
public class Category {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="categoryid", unique = true, nullable = false)
    private long id;
	
	@Column(name="title")
    private String title;
    
	@OneToMany(fetch=FetchType.EAGER, mappedBy="category")
	private Set<Job> jobs = new HashSet<Job>();

    public Category(String title) {
        this.title = title;
        this.jobs = new HashSet<Job>();
    }

    Category() {
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    public void addJob(Job job) {
        getJobs().add(job);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}