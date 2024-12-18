package com.annotation.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.annotation.di");
//		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Student student = context.getBean(Student.class);
		
//		student.setName("Estifanos Taye");
//		Student s = context.getBean("fresh", Student.class);
//		SchoolInterface school = context.getBean(PrimarySchool.class);
//		school.setSchoolName("Nice School");
		
		student.getDetails();
	}

}
