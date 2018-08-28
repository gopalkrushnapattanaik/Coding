package com.practice.algorithm.poisonusplant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author fq63
 *
 *         There are a number of plants in a garden. Each of these plants has
 *         been treated with some amount of pesticide. After each day, if any
 *         plant has more pesticide than the plant on its left, being weaker
 *         than the left one, it dies.
 * 
 *         You are given the initial values of the pesticide in each of the
 *         plants. Print the number of days after which no plant dies, i.e. the
 *         time after which there are no plants with more pesticide content than
 *         the plant to their left.
 * 
 *         For example, pesticide levels . Using a -indexed array, day plants
 *         and die leaving . On day , plant of the current array dies leaving .
 *         As there is no plant with a higher concentration of pesticide than
 *         the one to its left, plants stop dying after day .
 * 
 * 
 */
public class PoisonousPlant {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("enter the number of plants present");
		int N = sc.nextInt();
		int[] P = new int[N];
	
		for (int i = 0; i < P.length; i++) {
			System.out.println("enter the pestiside amount for plant number :"+i);
			P[i] = sc.nextInt();
		}
		System.out.println("plants will stop dying after"+solve(P)+ "days");

		sc.close();
	}

	static int solve(int[] P) {
		List<LinkList> parts = new ArrayList<LinkList>();
		LinkList lastPart = null;

		for (int i = 0; i < P.length; i++) {

			if (i > 0 && P[i] <= P[i - 1]) {
				lastPart.append(P[i]);
			} else {
				LinkList part = new LinkList();
				part.append(P[i]);

				parts.add(part);
				lastPart = part;
			}
		}

		int day = 0;

		while (parts.size() > 1) {
			for (int i = 1; i < parts.size(); i++) {
				parts.get(i).removeFirst();
			}

			List<LinkList> nextParts = new ArrayList<LinkList>();
			for (LinkList part : parts) {
				if (part.head == null) {
					continue;
				}

				if (!nextParts.isEmpty() && nextParts.get(nextParts.size() - 1).tail.value >= part.head.value) {
					nextParts.get(nextParts.size() - 1).append(part);
				} else {
					nextParts.add(part);
				}
			}
			parts = nextParts;

			day++;
		}

		return day;
	}
}

class Node {
	int value;
	Node next;

	Node(int value) {
		this.value = value;
	}
}

class LinkList {
	Node head;
	Node tail;

	void append(int value) {
		Node node = new Node(value);
		if (tail == null) {
			head = node;
		} else {
			tail.next = node;
		}
		tail = node;
	}

	void append(LinkList list) {
		tail.next = list.head;
		tail = list.tail;
	}

	void removeFirst() {
		head = head.next;
		if (head == null) {
			tail = null;
		}
	}
}