package org.tejas.messenger.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	private long id;
	private String message;
	private Date created;
	private String author;
	private Map<Long,Comments> comments=new HashMap<>();
	//private Comments comment;
	
	public Message()
	{
		
	}
	public Message(int id, String message, String author) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.message=message;
		created=new Date();
		this.author=author;
		//comments= 

	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	//Do not display comments when we are looking for comments
	@XmlTransient
	public Map<Long,Comments> getComments() {
		return comments;
	}
	public void setComments(Map<Long,Comments> comments) {
		this.comments = comments;
	}

}
