package com.SheetCutting.Algo;


public class OptimumStrips {
	
	
	
	
	private String Type;
	private String Name;
	
	private double Strip_Length;
	private double Strip_Width;
	//private double Sheet_Width;
	
	
	
	
	public String toString() {
		/*	return "intermidiate_Strip_Type = "+this.Type+", intermidiate_Strip_Length = " + this.Strip_Length +"mm"
	       +", intermidiate_Strip_Width= " + this.Strip_Width +"mm" ; 
		    }*/
		    	return this.Type +" "+ this.Name+ " "+this.Strip_Length +" "
	       + this.Strip_Width; 
		    }


	public OptimumStrips() {
		// TODO Auto-generated constructor stub
	}


	public OptimumStrips(String type, String name, double strip_Length,
			double strip_Width) {
		super();
		Type = type;
		Name = name;
		Strip_Length = strip_Length;
		Strip_Width = strip_Width;
	}


	public String getType() {
		return Type;
	}


	public void setType(String type) {
		Type = type;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public double getStrip_Length() {
		return Strip_Length;
	}


	public void setStrip_Length(double strip_Length) {
		Strip_Length = strip_Length;
	}


	public double getStrip_Width() {
		return Strip_Width;
	}


	public void setStrip_Width(double strip_Width) {
		Strip_Width = strip_Width;
	}

	
	
	 
	
}




