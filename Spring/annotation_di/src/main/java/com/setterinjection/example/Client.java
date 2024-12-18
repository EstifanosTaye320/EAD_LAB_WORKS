package com.setterinjection.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.setterinjection.example");
		MessageSender messSender = context.getBean(MessageSender.class);
		
		messSender.sendMessage("Hello World, This is Estif");
	}

}
