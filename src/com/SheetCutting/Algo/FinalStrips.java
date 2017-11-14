package com.SheetCutting.Algo;

public class FinalStrips {
	
	
	private int length;
	private int width;
	private int number;
	
	public String toString() {
		return "FinalStripHeight = " 
	    + this.length +"mm"+", FinalStripWidth= " + this.width +"mm"
	    +", FinalStripNumber= "+this.number; 
	}
	
	
	
	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public FinalStrips() {
		// TODO Auto-generated constructor stub
	}
		
		public FinalStrips(int length, int width, int number) {
		super();
		this.length = length;
		this.width = width;
		this.number = number;
	}
		
}
