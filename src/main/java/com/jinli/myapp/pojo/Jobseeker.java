package com.jinli.myapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="jobseeker")
@PrimaryKeyJoinColumn(name="userId")
public class Jobseeker extends User{
	@Column(name="school")
	private String school;
	@Column(name="major")
	private String major;
	@Column(name="introduction")
	private String introduction;
	


	public Jobseeker(){
		
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	
	
}
