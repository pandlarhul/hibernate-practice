package com.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Employee;

public class MainApp {

	public static void main(String[] args) {
		Employee emp = new Employee();

		emp.setFirstName("Sagar");
		emp.setLastName("kumar");
		emp.setCompanyName("pace infotech");
		emp.setId(2);
		
//		CreateEmployeeDemo.saveNewEmployee(emp);
//		
//	
//		emp = QueryEmployee.get(2);
//		System.out.println(emp);
//
		
		DeleteEmployee.delete(emp, false);
		
		
	}

}
