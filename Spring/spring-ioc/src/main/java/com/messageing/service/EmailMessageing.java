package com.messageing.service;

public class EmailMessageing implements MessageService{

	@Override
	public void sendMessage(String message) {
		System.out.println("Email Message: " + message);
	}
	
}
