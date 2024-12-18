package com.itsc.di;

public class Teacher {
	private String teacherName;
	private University university;
	
	public Teacher(String teacherName, University university) {
		this.teacherName = teacherName;
		this.university = university;
	}	
	
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	
	public void displayTeacherInfo() {
		System.out.printf("Teacher %s is posted to %s University", this.teacherName, university.getName());
	}
	
	

}
