package com.employee.department;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("emdp-config.xml");
		EmDpManagement management = context.getBean("emdp", EmDpManagement.class);
		
		management.displayDepartments();
	}

}
