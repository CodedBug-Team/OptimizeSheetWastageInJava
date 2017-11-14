package com.SheetCutting.Algo;


public class SheetWastage {
	
	
	
	 double sheet_length;
	 double sheet_Width;
	 
	 
	
	
	 public String toString() {
			return "SheetWastageLength = "+ this.sheet_length +"mm" 
	        + ", SheetWastageWidth = " + this.sheet_Width +"mm";
		    }
	
	  public SheetWastage() {
		// TODO Auto-generated constructor stub
	}

	public double getSheet_length() {
		return sheet_length;
	}

	public void setSheet_length(double sheet_length) {
		this.sheet_length = sheet_length;
	}

	public double getSheet_Width() {
		return sheet_Width;
	}

	public void setSheet_Width(double sheet_Width) {
		this.sheet_Width = sheet_Width;
	}

	

	public SheetWastage(double sheet_length, double sheet_Width) {
		super();
		this.sheet_length = sheet_length;
		this.sheet_Width = sheet_Width;
		
	}


	
	 
}




