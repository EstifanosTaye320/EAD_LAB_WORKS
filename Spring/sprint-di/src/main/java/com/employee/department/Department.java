package com.employee.department;

import java.util.List;

public class Department {
	private String departmentName;
	private List<Employee> employees;
	
	public Department(String d, List<Employee> l) {
		this.departmentName = d;
		this.employees = l;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	
	public List<Employee> getEmployees() {
		return employees;
	}
	

}
