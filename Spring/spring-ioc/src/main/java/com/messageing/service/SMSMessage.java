package com.messageing.service;

public class SMSMessage implements MessageService{

	@Override
	public void sendMessage(String message) {
		System.out.println("SMS Message: " + message);
	}

}
