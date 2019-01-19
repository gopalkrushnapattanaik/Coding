package com.practice.clone.model;

public class Employee implements Cloneable {

	private String employeeId;
	private String name;
	private Department department;

	public Employee(String employeeId, String name, Department department) {
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;
	}
	
	//copy - constructor
	public Employee(Employee emp) {
		this.employeeId = emp.getEmployeeId();
		this.name = emp.getName();
		
		Department d= new Department( emp.getDepartment());
		this.department = d;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", department=" + department.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		return true;
	}
	
	//Deep-Copy
	public Employee clone() throws CloneNotSupportedException {

		Employee clonedEmployee = (Employee) super.clone();
		clonedEmployee.setDepartment(department.clone());

		return clonedEmployee;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
