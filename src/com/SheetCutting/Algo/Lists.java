package com.SheetCutting.Algo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lists {

		/**
	 * @param list_obj_xx 
	 * @param args
	 */
	/*public static List<String> newArrayList(String[] values) {
		// TODO Auto-generated method stub
		
		
		List al= new ArrayList<Focus>();
		al.add("Focus 1");
		al.add("09");
		al.add("14");
		al.add("13");
		al.add("12");
		
		//"Focus 1", "09", "14", "13", "12"
		
		List al1= new ArrayList<Focus>();
		al.add("Focus 2");
		al.add("94");
		al.add("92");
		//"Focus 2", "94", "92"
		
		List al2= new ArrayList<Focus>();
		al.add("Focus 3");
		al.add("A");
		al.add("B");
		//"Focus 3", "A", "B"
		
		List focuses = new ArrayList<Focus>();
		focuses.add(al);
		focuses.add(al1);
		focuses.add(al2);

		
		
		return focuses;
	}
*/
		public static List<String> newArrayList(String[] values) {
			// TODO Auto-generated method stub
			int itr=values.length;
			List al=new ArrayList();
			for(int i=0; i<itr; i++)
			{
				al.add(values[i]);
			}
			return al;
		}

}