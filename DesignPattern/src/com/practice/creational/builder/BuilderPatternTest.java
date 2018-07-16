package com.practice.creational.builder;

public class BuilderPatternTest {

	public static void main(String[] args) {
		
		NutritonalFacts nfs1= new NutritonalFacts.Builder(10,5).build();
		System.out.println(nfs1.toString());
		NutritonalFacts nfs2= new NutritonalFacts.Builder(10,5).calories(200).fat(35).build();
		System.out.println(nfs2.toString());
		NutritonalFacts nfs3=  new NutritonalFacts.Builder(10,5).calories(200).fat(35).protine(23).sodium(10).build();
		System.out.println(nfs3.toString());
	}

}
