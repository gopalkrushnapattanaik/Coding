package com.practice.clone.tester;

import com.practice.clone.model.Department;
import com.practice.clone.model.Employee;

public class TestCloning {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Department d1= new Department("100","Physics");
		Employee e1= new Employee("1000","Gopal",d1);
		
		Employee e2= (Employee) e1.clone();
		
		
		System.out.println("********************************");

		System.out.println("e1 -Orginal : "+e1.toString());
		System.out.println("e2 - Cloned : "+e2.toString());
		
		
		System.out.println("e1.equals(e2) "+e1.equals(e2));
		System.out.println("e1!=e2 "+ (e1 != e2));
		System.out.println("e1.getClass() ==e2.getClass() "+(e1.getClass() ==e2.getClass()));
		System.out.println("e1 -hashCode "+e1.hashCode());
		System.out.println("e2 -hashCode "+e2.hashCode());

		
		System.out.println("********************************");
		
		e2.getDepartment().setDepartmentId("101");
		e2.getDepartment().setName("Math");
		e2.setName("Rama");
		e2.setEmployeeId("1001");
		
		System.out.println("e1 -Orginal : "+e1.toString());
		System.out.println("e2 - Cloned : "+e2.toString());
		
		System.out.println("********************************");
		
		System.out.println("e1.equals(e2) "+e1.equals(e2));
		System.out.println("e1!=e2 "+ (e1 != e2));
		System.out.println("e1.getClass() ==e2.getClass() "+(e1.getClass() ==e2.getClass()));
		System.out.println("e1 -hashCode "+e1.hashCode());
		System.out.println("e2 -hashCode "+e2.hashCode());
		
		System.out.println("********************************");
		
		Employee e3= new Employee(e2);
		
		e3.getDepartment().setDepartmentId("102");
		e3.getDepartment().setName("Chemistry");
		
		System.out.println("e2 -Orginal : "+e2.toString());
		System.out.println("e3 - Cloned : "+e3.toString());
		System.out.println("e2.equals(e3) "+e3.equals(e2));
		System.out.println("e3!=e2 "+ (e3 != e2));
		System.out.println("e3.getClass() ==e2.getClass() "+(e3.getClass() ==e2.getClass()));
		System.out.println("e3 -hashCode "+e3.hashCode());
		System.out.println("e2 -hashCode "+e2.hashCode());
		
	}

}
