package com.SheetCutting.Algo;


public class Identifier {
	
	
	
	String Strip_Type;
	int No_Of_Strips;
	
	
	
	public String toString() {
			return "Strip_Type = " + this.Strip_Type + ", No_Of_Strips = " + this.No_Of_Strips;
		    }

	public Identifier() {
		// TODO Auto-generated constructor stub
	}

	public String getStrip_Type() {
		return Strip_Type;
	}

	public void setStrip_Type(String strip_Type) {
		Strip_Type = strip_Type;
	}

	public int getNo_Of_Strips() {
		return No_Of_Strips;
	}

	public void setNo_Of_Strips(int no_Of_Strips) {
		No_Of_Strips = no_Of_Strips;
	}

	public Identifier(String strip_Type, int no_Of_Strips) {
		super();
		Strip_Type = strip_Type;
		No_Of_Strips = no_Of_Strips;
	}

	
	
	
	 
}




