package com.practice.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/* 	//Accumulate names into a List
*     List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());
*
*     // Accumulate names into a TreeSet
*     Set<String> set = people.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));
*
*     // Convert elements to strings and concatenate them, separated by commas
*     String joined = things.stream()
*                           .map(Object::toString)
*                           .collect(Collectors.joining(", "));
*
*     // Compute sum of salaries of employee
*     int total = employees.stream()
*                          .collect(Collectors.summingInt(Employee::getSalary)));
*
*     // Group employees by department
*     Map<Department, List<Employee>> byDept
*         = employees.stream()
*                    .collect(Collectors.groupingBy(Employee::getDepartment));
*
*     // Compute sum of salaries by department
*     Map<Department, Integer> totalByDept
*         = employees.stream()
*                    .collect(Collectors.groupingBy(Employee::getDepartment,
*                                                   Collectors.summingInt(Employee::getSalary)));
*
*     // Partition students into passing and failing
*     Map<Boolean, List<Student>> passingFailing =
*         students.stream()
*                 .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
*                 
*/
public class StreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = Arrays.asList(5, 12, 34, 45, 200);

		// list.stream().filter(e->e>15).forEach(e->System.out.println(e));

		List<Integer> list1 = Arrays.asList(5, 12, 34, 45, 200);
		List<Integer> list2 = Arrays.asList(2, 12, 30, 40, 20,200);
		List<List<Integer>> l = Arrays.asList(list1, list2);
		
		int sum = list1.stream().reduce(0,(a,b)->a+b);
		
		
		System.out.println("sum :- "+sum);
		
		int sum1 = list1.stream().collect(Collectors.summingInt(Integer::intValue));
		System.out.println("sum1 :- "+sum1);
		
		
		List<String> list3 = Arrays.asList("Tiger","Lion","Elephant","Bear");
		

		
		list3.stream().map(String::toUpperCase).sorted(Comparator.reverseOrder()).map(s->s+"stream").forEach(System.out::println);
		
		l.stream().flatMap(e -> e.stream().filter(k -> k > 15)).map(x->x*10).forEach(e -> System.out.println(e));
		System.out.println("******");
	
		
		System.out.println("******");
		
		List<Integer> result = l.stream().flatMap(e -> e.stream().filter(k -> k > 15))
				.collect(Collectors.toList());
		result.stream().forEach(System.out::println);
		
	}

}
