package com.jinli.myapp.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="jobtable")
public class Job {

	@Id 
	@GeneratedValue
	@Column(name="jobId", unique = true, nullable = false)
    private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Transient 
    private String postedBy;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="employer")
	  private Employer employer;


	    @Transient 
	    private String category_name;
	    
	    @JoinColumn(name="categoryid")
	    private long category;

	  
	public Job(String title, String description, Employer employer,long category_id,String categoryName) {
		  this.title = title;
	        this.description = description;
	        this.employer = employer;
	        this.category = category_id;
	        this.category_name=categoryName;
	}

	public Job(){
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
	}
	  
	  
	  
	  
}
