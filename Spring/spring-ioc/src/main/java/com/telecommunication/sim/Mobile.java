package com.telecommunication.sim;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beansConfig.xml");
		SimInterface sim = context.getBean("sim", SimInterface.class);
		sim.call();
		sim.data();
		System.out.println();
		
		sim.setProperty("The state");
		System.out.println(sim.getProperty());
		
		System.out.println(sim.getOperatorName());
		System.out.println(sim.getPhoneNumber());
	}

}
