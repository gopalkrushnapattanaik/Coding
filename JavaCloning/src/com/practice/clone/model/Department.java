package com.practice.clone.model;

public class Department implements Cloneable{

	private String departmentId;
	private String name;
	
	public Department(String departmentId,String name) {
		this.departmentId=departmentId;
		this.name=name;
	}
	
	//copy-constructor
	public Department(Department department) {
		this.departmentId=department.getDepartmentId();
		this.name=department.getName();
	}


	//Shallow-Copy
	public Department clone() throws CloneNotSupportedException{
		return (Department) super.clone();
	}
	
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", name=" + name + "]";
	}

	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
