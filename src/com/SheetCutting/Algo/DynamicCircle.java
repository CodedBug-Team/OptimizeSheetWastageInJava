package com.SheetCutting.Algo;


public class DynamicCircle {
	
	
	
	int circleStrip_length;
	int circleStrip_Width;
	int circleStrip_Id;
	String circleStrip_Name;
	
	
	public String toString() {
			return "circleStripLength = " + this.circleStrip_length +"mm"+ ", circleStripWidth = " + this.circleStrip_Width +"mm"
					+ ", circleStripId = " + this.circleStrip_Id + ", circleStripName = " + this.circleStrip_Name;
		    }

	public DynamicCircle() {
		// TODO Auto-generated constructor stub
	}

	public DynamicCircle(int circleStrip_length, int circleStrip_Width, int circleStrip_Id,
			String circleStrip_Name) {
		super();
		this.circleStrip_length = circleStrip_length;
		this.circleStrip_Width = circleStrip_Width;
		this.circleStrip_Id = circleStrip_Id;
		this.circleStrip_Name = circleStrip_Name;
	}

	public int getcircleStrip_length() {
		return circleStrip_length;
	}

	public void setcircleStrip_length(int circleStrip_length) {
		this.circleStrip_length = circleStrip_length;
	}

	public int getcircleStrip_Width() {
		return circleStrip_Width;
	}

	public void setcircleStrip_Width(int circleStrip_Width) {
		this.circleStrip_Width = circleStrip_Width;
	}

	public int getcircleStrip_Id() {
		return circleStrip_Id;
	}

	public void setcircleStrip_Id(int circleStrip_Id) {
		this.circleStrip_Id = circleStrip_Id;
	}

	public String getcircleStrip_Name() {
		return circleStrip_Name;
	}

	public void setcircleStrip_Name(String circleStrip_Name) {
		this.circleStrip_Name = circleStrip_Name;
	}
	
	
	 
}




