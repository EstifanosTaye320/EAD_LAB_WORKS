package com.annotation.di;

import org.springframework.stereotype.Component;

@Component()
public class HighSchool implements SchoolInterface{
	private String schoolName;
	
	@Override
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	@Override
	public String getSchoolName() {
		return "High School" + this.schoolName;
	}

}
