package com.SheetCutting.Algo;


public class StripWastage {
	
	
	
	 int strip_length;
	 int strip_Width;
	 int strip_Id;
	 String strip_Name;
	
	
	 public String toString() {
			return "StripWastageLength = " + this.strip_length+"mm" + ", StripWastageWidth = " + this.strip_Width+"mm"
					+ ", StripWastageId = " + this.strip_Id + ", StripWastageName = " + this.strip_Name;
		    }
	



	public int getStrip_length() {
		return strip_length;
	}







	public void setStrip_length(int strip_length) {
		this.strip_length = strip_length;
	}







	public int getStrip_Width() {
		return strip_Width;
	}







	public void setStrip_Width(int strip_Width) {
		this.strip_Width = strip_Width;
	}







	public int getStrip_Id() {
		return strip_Id;
	}







	public void setStrip_Id(int strip_Id) {
		this.strip_Id = strip_Id;
	}







	public String getStrip_Name() {
		return strip_Name;
	}







	public void setStrip_Name(String strip_Name) {
		this.strip_Name = strip_Name;
	}




	public StripWastage(int strip_length, int strip_Width, int strip_Id,
			String strip_Name) {
		super();
		this.strip_length = strip_length;
		this.strip_Width = strip_Width;
		this.strip_Id = strip_Id;
		this.strip_Name = strip_Name;
	}

	public StripWastage() {
		// TODO Auto-generated constructor stub
	}
	 
}




