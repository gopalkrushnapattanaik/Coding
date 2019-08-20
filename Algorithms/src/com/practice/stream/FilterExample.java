package com.practice.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = Arrays.asList(5, 12, 34, 45, 200);

		// list.stream().filter(e->e>15).forEach(e->System.out.println(e));

		List<Integer> list1 = Arrays.asList(5, 12, 34, 45, 200);
		List<Integer> list2 = Arrays.asList(2, 12, 30, 40, 20,200);
		List<List<Integer>> l = Arrays.asList(list1, list2);

		
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
