package com.messageing.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageingApp {
	public static final void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("message-config.xml");
		MessageService email = context.getBean("email", MessageService.class);
		MessageService sms = context.getBean("sms", MessageService.class);
		email.sendMessage("Hello Estifanos Taye");
		sms.sendMessage("Hello Estifanos Taye");
	}
}
