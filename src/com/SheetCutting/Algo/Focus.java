package com.SheetCutting.Algo;

import java.util.List;

class Focus {
    String focus;
    List<String>  values;
    
    public String toString() {
		return "Focus = " + this.focus + ", Values = " + this.values;
	    }


    public Focus() {
		// TODO Auto-generated constructor stub
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

	public Focus(String focus, String[] values) {
		super();
		this.focus = focus;
		//this.values = values;
		this.values = Lists.newArrayList(values);
	}
    
	
}




