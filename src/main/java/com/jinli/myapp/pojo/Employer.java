package com.jinli.myapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="employer")
@PrimaryKeyJoinColumn(name="userId")
public class Employer extends User{
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="position")
	private String position;
	
	
	public Employer(){
		
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
}
