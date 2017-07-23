package org.tejas.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.tejas.messenger.database.Database;
import org.tejas.messenger.model.Comments;
import org.tejas.messenger.model.Message;

public class CommentService {

	private Map<Long, Message> message=Database.getMessages();
	
	public List<Comments> getAllComments(long messageId)
	{
		Map<Long, Comments> comment=message.get(messageId).getComments();
		return new ArrayList<>(comment.values());
	}
	
	public Comments getComment(long messageId, long commentId)
	{
		return message.get(messageId).getComments().get(commentId);
	}
	
	public Comments addComment(long messageId, Comments comment)
	{
		Map<Long, Comments> comments= message.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comments updateComment(long messageId,Comments comment)
	{
		Map<Long, Comments> comments= message.get(messageId).getComments();
		if(comment.getId()<=0)
			return null;
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comments deleteComment(long messageId, long commentId)
	{
		return message.get(messageId).getComments().remove(commentId);
	}
}
