package com.jinli.myapp.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="user")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", unique=true, nullable = false)
	private long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="receiver")
	private Set<Message> messageList = new HashSet<Message>();

	
	User() {
    }

    public User(String username, String password) {
        this.firstname = username;
        this.password = password;
       this.messageList = new HashSet<Message>();
    }
    
	public Set<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(Set<Message> messageList) {
		this.messageList = messageList;
	}


	  public void addMessage(Message message) {
	        getMessageList().add(message);
	    }


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public long getUserId() {
		return id;
	}

	public void setUserId(long userId) {
		this.id = userId;
	}
    
	
    
    
}
