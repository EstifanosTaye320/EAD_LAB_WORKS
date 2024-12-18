package com.annotation.di;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.annotation.di")
public class AppConfig {
	
//	@Bean
//	public SchoolInterface pS() {
//		SchoolInterface primarySchool = new PrimarySchool();
//		primarySchool.setSchoolName("Nice Name");
//		return primarySchool;
//	}

//	@Bean
//	public Student student() {
//		Student student  = new Student();
//		student.setName("Estifanos Taye");
//		return student;
//	}

//	@Bean
//	public School school() {
//		School school = new School();
//		school.setSchoolName("AAiT");
//		return school;
//	}
}
