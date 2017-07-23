package org.tejas.messenger.resources;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.tejas.messenger.model.Comments;
import org.tejas.messenger.model.Message;
import org.tejas.messenger.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService m= new MessageService();
	
	@GET
	//@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year") int year)
	{	// if the url does not have query parameter, year wull be 0
		return m.getAllMessage();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id)
	{
		return m.getMessage(id);
	}
	
	@POST
	//@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message)
	{
		return m.addMessage(message);
	}
	
	@PUT
	//@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message updateMessage(Message message,@PathParam("messageId") long id)
	{
		message.setId(id);
		return m.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") long id)
	{
		return m.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource comment()
	{
		return new  CommentResource();
	}

	
}
