package com.jinli.myapp.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="message")
public class Message {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="messageId", unique = true, nullable = false)
    private long id;
	
	@Column(name="context")
	private String context;
	
	
	
	@Column(name="sender")
	  private long sender;
	  
	  @ManyToOne
		 //@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	  @JoinColumn(name="receiver")
	    private User receiver;

	  @Column(name="time")
	  private String time;
	  
	public Message(){
		
	}
	  
	  public Message(String context){
		  this.context = context;
		  Date now = new Date(); 
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		  this.time = dateFormat.format(now);
	  }
	  
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	



	public long getSender() {
		return sender;
	}

	public void setSender(long sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	  

	  
}
