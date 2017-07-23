package org.tejas.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.tejas.messenger.database.Database;
import org.tejas.messenger.model.Comments;
import org.tejas.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages= Database.getMessages();
	public List<Message> getAllMessage()
	{
		return new ArrayList<>(messages.values());
		
	}
	
	public Message getMessage(long id)
	{
		return messages.get(id);
	}
	
	public Message addMessage(Message message)
	{
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message)
	{
		if(message.getId()<=0)
			return null;
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
	
}
