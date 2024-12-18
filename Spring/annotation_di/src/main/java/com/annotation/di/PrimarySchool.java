package com.annotation.di;

import org.springframework.stereotype.Component;

@Component()
public class PrimarySchool implements SchoolInterface{
	private String schoolName = "Bright Future School";
	
	@Override
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	@Override
	public String getSchoolName() {
		return "Primary School: " + schoolName;
	}

}
