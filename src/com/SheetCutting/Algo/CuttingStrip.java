package com.SheetCutting.Algo;


public class CuttingStrip {
	
	
	
	int SheetStrip_length;
	int SheetStrip_Width;
	int SheetStrip_Id;
	String SheetStrip_Name;
	
	
	public String toString() {
			return "CuttingStripLength = " + this.SheetStrip_length +"mm"+ ", CuttingStripWidth = " + this.SheetStrip_Width+"mm"
					+ ", CuttingStripId = " + this.SheetStrip_Id + ", CuttingStripName = " + this.SheetStrip_Name;
		    }

	public CuttingStrip() {
		// TODO Auto-generated constructor stub
	}

	public CuttingStrip(int SheetStrip_length, int SheetStrip_Width, int SheetStrip_Id,
			String SheetStrip_Name) {
		super();
		this.SheetStrip_length = SheetStrip_length;
		this.SheetStrip_Width = SheetStrip_Width;
		this.SheetStrip_Id = SheetStrip_Id;
		this.SheetStrip_Name = SheetStrip_Name;
	}

	public int getSheetStrip_length() {
		return SheetStrip_length;
	}

	public void setSheetStrip_length(int SheetStrip_length) {
		this.SheetStrip_length = SheetStrip_length;
	}

	public int getSheetStrip_Width() {
		return SheetStrip_Width;
	}

	public void setSheetStrip_Width(int SheetStrip_Width) {
		this.SheetStrip_Width = SheetStrip_Width;
	}

	public int getSheetStrip_Id() {
		return SheetStrip_Id;
	}

	public void setSheetStrip_Id(int SheetStrip_Id) {
		this.SheetStrip_Id = SheetStrip_Id;
	}

	public String getSheetStrip_Name() {
		return SheetStrip_Name;
	}

	public void setSheetStrip_Name(String SheetStrip_Name) {
		this.SheetStrip_Name = SheetStrip_Name;
	}
	
	
	 
}




