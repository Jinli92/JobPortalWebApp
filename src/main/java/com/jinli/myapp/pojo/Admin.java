package com.jinli.myapp.pojo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="admin")
@PrimaryKeyJoinColumn(name="userId")
public class Admin extends User{
	private  String adminNum;
	
	
	Admin(){
		
	}


	public String getAdminNum() {
		return adminNum;
	}


	public void setAdminNum(String adminNum) {
		this.adminNum = adminNum;
	}
	
	
	
}
