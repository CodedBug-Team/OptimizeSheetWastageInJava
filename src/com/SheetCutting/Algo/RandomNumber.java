package com.SheetCutting.Algo;


public class RandomNumber {
	
	
	
	 int randam_Length;
	 int random_Number;
	 	
	
	 public String toString() {
			return "Random Length = " + this.randam_Length+"mm" + ", Random Number = " + this.random_Number;
					   }


	public int getRandam_Length() {
		return randam_Length;
	}


	public void setRandam_Length(int randam_Length) {
		this.randam_Length = randam_Length;
	}


	public int getRandom_Number() {
		return random_Number;
	}


	public void setRandom_Number(int random_Number) {
		this.random_Number = random_Number;
	}


	
	
	public RandomNumber(int randam_Length, int random_Number) {
		super();
		this.randam_Length = randam_Length;
		this.random_Number = random_Number;
	}


	public RandomNumber() {
		// TODO Auto-generated constructor stub
	}		 
}




