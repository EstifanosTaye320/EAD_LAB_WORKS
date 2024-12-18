package com.employee.department;

import java.util.List;

public class EmDpManagement {
	private List<Employee> employees;
	private List<Department> departments;

	public EmDpManagement(List<Employee> em, List<Department> dp) {
		this.employees = em;
		this.departments = dp;
	}

	public void displayEmployees() {
		System.out.println("Employees: ");
		for (Employee employee : employees) {
			System.out.println("Name: " + employee.getEmployeeName() + ", ID: " + employee.getEmployeeID());
		}
	}

	public void displayDepartments() {
		System.out.println("Departments: ");
		for (Department department : departments) {
			System.out.println("Department: " + department.getDepartmentName());
			System.out.println("Employees: ");
			for (Employee emp : department.getEmployees()) {
				System.out.println("- " + emp.getEmployeeName());
			}
			System.out.println();
		}
	}

}
