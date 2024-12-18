package com.setterinjection.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	private MessageService messageService;

	@Autowired
	public void setMessageService(@Qualifier("emailService") MessageService messageService) {
		this.messageService = messageService;
		System.out.println("setter based dependency injection");
	}

	public void sendMessage(String message) {
		this.messageService.sendMessage(message);
	}
}