package com.annotation.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {
	private String name = "Estifanos Taye";

//	@Autowired
//	@Qualifier("primarySchool")
	private SchoolInterface school;

//	@Autowired
//	public Student (@Qualifier("primarySchool") SchoolInterface school) {
//		this.school = school;
//	}
	
	@Autowired
	public void setSchool(@Qualifier("primarySchool") SchoolInterface school) {
		this.school = school;
	}

	public void getDetails() {
		System.out.println(getName() + " is learning at " + getSchool().getSchoolName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SchoolInterface getSchool() {
		return school;
	}

}
