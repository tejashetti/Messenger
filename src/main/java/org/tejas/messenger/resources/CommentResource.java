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
import javax.ws.rs.core.MediaType;

import org.tejas.messenger.model.Comments;
import org.tejas.messenger.service.CommentService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private CommentService cs= new CommentService();
 
	@GET
	public List<Comments> getAllComments(@PathParam("messageId") long messageId)
	{
		return cs.getAllComments(messageId);		
	}
	
	@POST
	public Comments addComment(@PathParam("messageId") long messageId, Comments comment)
	{
		return cs.addComment(messageId, comment);
	}
	
	@GET
	@Path("/{commentId}")
	public Comments getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId)
	{
		return cs.getComment(messageId, commentId);
	}

	@PUT
	public Comments updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId, Comments comment)
	{
		comment.setId(commentId);
		return cs.updateComment(messageId, comment);
	}
	
	@DELETE
	public Comments deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId)
	{		
		return cs.deleteComment(messageId, commentId);
	}
	
	
}
