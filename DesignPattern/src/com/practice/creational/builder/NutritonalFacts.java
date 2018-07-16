package com.practice.creational.builder;

public class NutritonalFacts {
	
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int protine;
	private final int sodium;

	private NutritonalFacts(Builder builder) {
		this.servingSize = builder.servingSize;
		this.servings = builder.servings;
		this.calories = builder.calories;
		this.fat = builder.fat;
		this.protine = builder.protine;
		this.sodium = builder.sodium;
	}

	@Override()
	public String toString() {
		StringBuilder sb= new StringBuilder();
		sb.append("servingSize ").append(this.servingSize)
		.append("servings ").append(this.servings)
		.append("calories ").append(this.calories)
		.append("fat ").append(this.fat)
		.append("protine ").append(this.protine)
		.append("sodium ").append(this.sodium);
		return sb.toString();
	}
	
	// public Static builder class
	public static class Builder {

		// mandatory fields
		private final int servingSize;
		private final int servings;

		// initialize the non-mandatory fields
		private int calories = 0;
		private int fat = 0;
		private int protine = 0;
		private int sodium = 0;
		
		//Builder constructor takes mandatory fields 
		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder calories(int calories) {
			this.calories = calories;
			return this;
		}

		public Builder fat(int fat) {
			this.fat = fat;
			return this;
		}

		public Builder protine(int protine) {
			this.protine = protine;
			return this;
		}

		public Builder sodium(int sodium) {
			this.sodium = sodium;
			return this;
		}

		//build method to create the actual object by invoking constructor
		public NutritonalFacts build() {
			return  new NutritonalFacts(this);
		}
	}

}
