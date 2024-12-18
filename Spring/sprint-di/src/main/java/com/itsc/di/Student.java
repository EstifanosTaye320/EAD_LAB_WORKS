package com.itsc.di;

public class Student {
	private String studentName;
	private University university;
	
	private String cstudentName;
	private University cuniversity;
	
	public Student(String cstudentName, University cuniversity) {
		this.cstudentName = cstudentName;
		this.setCuniversity(cuniversity);
		
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public String getCstudentName() {
		return cstudentName;
	}

	public void setCstudentName(String cstudentName) {
		this.cstudentName = cstudentName;
	}

	public University getCuniversity() {
		return cuniversity;
	}

	public void setCuniversity(University cuniversity) {
		this.cuniversity = cuniversity;
	}
	
	public void displayStudentInfo() {
		System.out.printf("Student %s is currently learning at %s University\n", this.studentName, university.getName());
	}
	
	public void cdisplayStudentInfo() {
		System.out.printf("Student %s is currently learning at %s University\n", this.cstudentName, cuniversity.getCname());
	}
	
}
