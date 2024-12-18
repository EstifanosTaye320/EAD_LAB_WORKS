package com.itsc.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("student-config.xml");
		Student student = context.getBean("stu", Student.class);
		
		student.displayStudentInfo();
		student.cdisplayStudentInfo();
		
		Teacher teacher = context.getBean("teacher", Teacher.class);
		
		teacher.displayTeacherInfo();
	}

}
