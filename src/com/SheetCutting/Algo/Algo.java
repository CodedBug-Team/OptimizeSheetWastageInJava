package com.SheetCutting.Algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javassist.bytecode.Mnemonic;

import org.apache.commons.collections.map.MultiValueMap;
import org.omg.CORBA.OMGVMCID;
import org.springframework.stereotype.Service;

import com.SheetCutting.Entity.Bothstripsize;
import com.SheetCutting.Entity.Circlestripsize;
import com.SheetCutting.Entity.Sheetsize;

@Service
public class Algo {

	Sheetsize sheetSize = null;

	// sheet variables
	int sheet_Id;
	double sheet_Length;
	double sheet_Width;
	double sheet_Thickness;
	String sheet_Name;

	// bothstrip variables
	int bothStrip_Id;
	double bothStrip_Length;
	double bothStrip_Width;
	double bothStrip_Thickness;
	String bothStrip_Name;

	// circleStrip variables
	int circleStrip_Id;
	double circleStrip_Diameter;
	double circleStrip_Thickness;
	String circleStrip_Name;
	
	
	Object wastage_status;
	
	int wastage_flag=0;
	int calculated_wastage=0;
	int min_wastage=0;
	int flag=0;
	
	
	//for optimise wastage
	int calculated_wastage1=0;
	int wastage_flag1=0;
	int min_wastage1=0;
	ArrayList<IntermidiateSheet> wastage_list;
	ArrayList<IntermidiateSheet> wastage_list1;
	
		
	Map optimized= new HashMap();
	List optimized_result=new ArrayList();
	
	List<Bothstripsize> bothStripSize = new ArrayList<Bothstripsize>();
	List<Circlestripsize> circleStripSize = new ArrayList<Circlestripsize>();
	List<Integer> values_rec = new ArrayList<Integer>();
	List<Integer> values_circle = new ArrayList<Integer>();
	int tolerance;

	
	
	/* list 3 contail list of strips length */
	ArrayList<Integer> list3;
	ArrayList<OptimumStrips> list4;
	/* "list" contains the intermediate strips */
	ArrayList<IntermidiateSheet> list;

	ArrayList<SheetWastage> list1;
	
	//To check the number of Circles
	Map nCircle;
	
	//To check the number of Square/Rectangle
		Map nBoth;

	/* "mv" contains the final strips */
	Map mv;
	
	/* "Strip_Desription" contains the Both strips Description */
	@SuppressWarnings("rawtypes")
	Map<String, Comparable> Strip_Desription;
	
	/* "Strip_Desription" contains the Circle strips Description */
	@SuppressWarnings("rawtypes")
	Map<String, Comparable> Strip_Desription1;

	public int getSheet_Id() {
		return sheet_Id;
	}

	public void setSheet_Id(int sheet_Id) {
		this.sheet_Id = sheet_Id;
	}

	public double getSheet_Length() {
		return sheet_Length;
	}

	public void setSheet_Length(double sheet_Length) {
		this.sheet_Length = sheet_Length;
	}

	public double getSheet_Width() {
		return sheet_Width;
	}

	public void setSheet_Width(double sheet_Width) {
		this.sheet_Width = sheet_Width;
	}

	public double getSheet_Thickness() {
		return sheet_Thickness;
	}

	public void setSheet_Thickness(double sheet_Thickness) {
		this.sheet_Thickness = sheet_Thickness;
	}

	public String getSheet_Name() {
		return sheet_Name;
	}

	public void setSheet_Name(String sheet_Name) {
		this.sheet_Name = sheet_Name;
	}

	public int getBothStrip_Id() {
		return bothStrip_Id;
	}

	public void setBothStrip_Id(int bothStrip_Id) {
		this.bothStrip_Id = bothStrip_Id;
	}

	public double getBothStrip_Length() {
		return bothStrip_Length;
	}

	public void setBothStrip_Length(double bothStrip_Length) {
		this.bothStrip_Length = bothStrip_Length;
	}

	public double getBothStrip_Width() {
		return bothStrip_Width;
	}

	public void setBothStrip_Width(double bothStrip_Width) {
		this.bothStrip_Width = bothStrip_Width;
	}

	public double getBothStrip_Thickness() {
		return bothStrip_Thickness;
	}

	public void setBothStrip_Thickness(double bothStrip_Thickness) {
		this.bothStrip_Thickness = bothStrip_Thickness;
	}

	public String getBothStrip_Name() {
		return bothStrip_Name;
	}

	public void setBothStrip_Name(String bothStrip_Name) {
		this.bothStrip_Name = bothStrip_Name;
	}

	public int getCircleStrip_Id() {
		return circleStrip_Id;
	}

	public void setCircleStrip_Id(int circleStrip_Id) {
		this.circleStrip_Id = circleStrip_Id;
	}

	public double getCircleStrip_Diameter() {
		return circleStrip_Diameter;
	}

	public void setCircleStrip_Diameter(double circleStrip_Diameter) {
		this.circleStrip_Diameter = circleStrip_Diameter;
	}

	public double getCircleStrip_Thickness() {
		return circleStrip_Thickness;
	}

	public void setCircleStrip_Thickness(double circleStrip_Thickness) {
		this.circleStrip_Thickness = circleStrip_Thickness;
	}

	public String getCircleStrip_Name() {
		return circleStrip_Name;
	}

	public void setCircleStrip_Name(String circleStrip_Name) {
		this.circleStrip_Name = circleStrip_Name;
	}

	public Object getWastage_status() {
		return wastage_status;
	}

	public void setWastage_status(Object wastage_status) {
		this.wastage_status = wastage_status;
	}

	public List getOptimized_result() {
		return optimized_result;
	}

	public void setOptimized_result(List optimized_result) {
		this.optimized_result = optimized_result;
	}

	public int getWastage_flag() {
		return wastage_flag;
	}

	public void setWastage_flag(int wastage_flag) {
		this.wastage_flag = wastage_flag;
	}

	public int getCalculated_wastage() {
		return calculated_wastage;
	}

	public void setCalculated_wastage(int calculated_wastage) {
		this.calculated_wastage = calculated_wastage;
	}

	public int getMin_wastage() {
		return min_wastage;
	}

	public void setMin_wastage(int min_wastage) {
		this.min_wastage = min_wastage;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Map getOptimized() {
		return optimized;
	}

	public void setOptimized(Map optimized) {
		this.optimized = optimized;
	}

	public ArrayList<Integer> getList3() {
		return list3;
	}

	public void setList3(ArrayList<Integer> list3) {
		this.list3 = list3;
	}

	public ArrayList<OptimumStrips> getList4() {
		return list4;
	}

	public void setList4(ArrayList<OptimumStrips> list4) {
		this.list4 = list4;
	}

	public ArrayList<IntermidiateSheet> getList() {
		return list;
	}

	public void setList(ArrayList<IntermidiateSheet> list) {
		this.list = list;
	}

	public ArrayList<SheetWastage> getList1() {
		return list1;
	}

	public void setList1(ArrayList<SheetWastage> list1) {
		this.list1 = list1;
	}

	public Map getnCircle() {
		return nCircle;
	}

	public void setnCircle(Map nCircle) {
		this.nCircle = nCircle;
	}

	public Map getnBoth() {
		return nBoth;
	}

	public void setnBoth(Map nBoth) {
		this.nBoth = nBoth;
	}

	public Map getMv() {
		return mv;
	}

	public void setMv(Map mv) {
		this.mv = mv;
	}

	public Map getStrip_Desription() {
		return Strip_Desription;
	}

	public void setStrip_Desription(Map strip_Desription) {
		Strip_Desription = strip_Desription;
	}

	public Map getStrip_Desription1() {
		return Strip_Desription1;
	}

	public void setStrip_Desription1(Map strip_Desription1) {
		Strip_Desription1 = strip_Desription1;
	}

	public HashMap<OptimumStrips, Integer> getHm() {
		return hm;
	}

	public void setHm(HashMap<OptimumStrips, Integer> hm) {
		this.hm = hm;
	}


	/*HashMap<Integer, Integer> hm;*/
	HashMap<OptimumStrips, Integer> hm;
	public void setSheetsize(Sheetsize sheetsize) {
		sheetSize = sheetsize;
	}

	public Sheetsize getSheetsize() {
		return sheetSize;
	}

	public Sheetsize getSheetSize() {
		return sheetSize;
	}

	public void setSheetSize(Sheetsize sheetSize) {
		this.sheetSize = sheetSize;
	}

	public List<Bothstripsize> getBothStripSize() {
		return bothStripSize;
	}

	public void setBothStripSize(List<Bothstripsize> bothStripSize) {
		this.bothStripSize = bothStripSize;

	}

	public List<Circlestripsize> getCircleStripSize() {
		return circleStripSize;
	}

	public void setCircleStripSize(List<Circlestripsize> circleStripSize) {

		this.circleStripSize = circleStripSize;

	}

	public List<Integer> getValues_rec() {
		return values_rec;
	}

	public void setValues_rec(List<Integer> values_rec) {
		this.values_rec = values_rec;
	}

	public List<Integer> getValues_circle() {
		return values_circle;
	}

	public void setValues_circle(List<Integer> values_circle) {
		this.values_circle = values_circle;
	}

	public int getTolerance() {
		return tolerance;
	}

	public void setTolerance(int tolerance) {
		this.tolerance = tolerance;
	}

	public Map cuttingSheet() {
		/* list 3 contail list of strips length */
		list3 = new ArrayList<Integer>();
		list4 = new ArrayList<OptimumStrips>();

		/* "list" contains the intermediate strips */
		list = new ArrayList<IntermidiateSheet>();
		
		/* "list" contains the optimise wastage strips */
		wastage_list = new ArrayList<IntermidiateSheet>();
		wastage_list1 = new ArrayList<IntermidiateSheet>();
		

		/*
		 * "list2" contains the wastage of the Sheet which is left from the 1st
		 * phase of the algo
		 */ 
	   list1 = new ArrayList<SheetWastage>();

		/* "mv" contains the final strips */
		mv = new MultiValueMap();
		
		/* "Strip_Desription" contains the strips Description */
		Strip_Desription=new MultiValueMap();
		
		/* "Strip_Desription" contains the Circle strips Description */
		Strip_Desription1=new MultiValueMap();

		/*
		 * "hm" contains the random number of the wastage which is left from the 2nd
		 * phase of the algo
		 */
		/*hm = new HashMap<Integer, Integer>();*/
		hm = new HashMap<OptimumStrips, Integer>();
		
		nCircle=new HashMap<>();
		nBoth=new HashMap<>();
	
		
		
		
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("CuttingSheet..............................called");
		
		System.out.println("DEBUGGINGGGGGGGGG");
		
		System.out.println(bothStripSize);
		System.out.println(circleStripSize);
		System.out.println(values_rec);
		System.out.println(values_circle);
		
		System.out.println("DEBUGGINGGGGGGGGG");

		System.out.println("Tolerance= " + tolerance + "mm");

		/* Things changed by Mayank */
		//system.out.println("Getting Sheet Id");

		sheet_Id = sheetSize.getId();
		sheet_Length = sheetSize.getHeight();
		sheet_Width = sheetSize.getWidth();
		sheet_Thickness = sheetSize.getThikness();
		sheet_Name= sheetSize.getSheetName();
		/*System.out.println(sheet_Name);*/
		
		
		double totalSheetArea = (int)sheet_Length * (int)sheet_Width;
		
		
		System.out.println("Check both stripsize11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		if(bothStripSize != null)
		{
		for (Bothstripsize b : bothStripSize) {
			bothStrip_Id = (Integer) b.getId();
			bothStrip_Length = (Double) b.getHeight();
			bothStrip_Width = (Double) b.getWidth();
			bothStrip_Thickness = (Double) b.getThikness();
			System.out.println("Id = " + bothStrip_Id + ", Length= "+ bothStrip_Length + ", Width= " + bothStrip_Width+ ", Thickness= " + bothStrip_Thickness);
		}
		}
		System.out.println("Check both stripsize********************************************************************************************************");
		
		
		//system.out.println(circleStripSize);
		System.out.println("Check circle stripsize11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		if(circleStripSize != null)
		{
		for (Circlestripsize b : circleStripSize) {
			circleStrip_Id = (Integer) b.getId();
			circleStrip_Diameter = (Double) b.getDimeter();
			circleStrip_Thickness = (Double) b.getThikness();
			System.out.println("Id = " + circleStrip_Id + ", Diameter= "+ circleStrip_Diameter + ", Thickness= "+ circleStrip_Thickness);
		}
		}
		System.out.println("Check circle stripsize********************************************************************************************************");

		
		
		System.out.println("Number of values_circlestrips!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
		if(values_circle != null)
		{
		for (Integer p : values_circle) {
			System.out.println("Number of strips " + p);
		}
		}
		System.out.println("Number of values_circlestrips*****************************************************************" );

		
		System.out.println("Number of values_rec strips!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
		//system.out.println("values_rec:" + values_rec);
		if(values_rec != null)
		{
		for (Integer p : values_rec) {
			System.out.println("Number of strips " + p);
		}
		}
		System.out.println("Number of values_rec strips*****************************************************************" );
		
		
		
		System.out.println("First phase start!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		// copy of double sheet_Length
		double sheet_Length1 = sheet_Length;
		/*int circleStripPieces = 0;
		int BothStripPieces = 0;*/
		// Cut circle from the main sheet
		if(circleStripSize != null)
		{
		for (int i = 0; i < circleStripSize.size(); i++) {
			String name = circleStripSize.get(i).getProductName();
			circleStrip_Id = circleStripSize.get(i).getId();
			circleStrip_Diameter = circleStripSize.get(i).getDimeter();
			circleStrip_Thickness = circleStripSize.get(i).getThikness();
			int n = values_circle.get(i);
			double circleStrip_Diameter1 = circleStrip_Diameter + tolerance;
			
			int circleStripPieces = 0;
			for (; sheet_Length1 >= circleStrip_Diameter1;) {

				System.out.println("loop called for strip ...."+ circleStrip_Diameter1);
				sheet_Length1 = sheet_Length1 - circleStrip_Diameter1;
				/*list.add(new IntermidiateSheet("C",circleStrip_Diameter,circleStrip_Diameter, sheet_Width));
*/
				list.add(new IntermidiateSheet("C",name,circleStrip_Diameter1,circleStrip_Diameter1, sheet_Width));

				int flag_1= (int) (sheet_Width / circleStrip_Diameter1);
				circleStripPieces = circleStripPieces + flag_1;

				
				nCircle.put(name, 0);
				if (circleStripPieces >= n) {
					System.out.println("if called....");
					circleStripPieces = 0;
					break;
				}
				
				

			}
		}
	}
		
		// Cut Square/Rectangle from the main sheet
		if(bothStripSize != null)
		{
				for (int i = 0; i < bothStripSize.size(); i++) {
					String name = bothStripSize.get(i).getProductName();
					bothStrip_Id = bothStripSize.get(i).getId();
					bothStrip_Length = bothStripSize.get(i).getHeight();
					bothStrip_Width = bothStripSize.get(i).getWidth();
					bothStrip_Thickness = bothStripSize.get(i).getThikness();
					int n = values_rec.get(i);
					double bothStrip_Width1 = bothStrip_Width + tolerance;
					double bothStrip_Length1 = bothStrip_Length + tolerance;
					//System.out.println("Id = " + circleStrip_Id + ", Diameter= "+ circleStrip_Diameter + ", Thickness= "+ circleStrip_Thickness + "number of circle= " + n);

					//System.out.println("Circle diameter after add tolerance= "+ circleStrip_Diameter1);

					int BothStripPieces = 0;
					for (; sheet_Length1 >= bothStrip_Length1;) {

						System.out.println("loop called for strip ...."+bothStrip_Length1);
						sheet_Length1 = sheet_Length1 - bothStrip_Length1;
						/*list.add(new IntermidiateSheet("R",bothStrip_Length,bothStrip_Width, sheet_Width));*/
						list.add(new IntermidiateSheet("R",name,bothStrip_Length1,bothStrip_Width1, sheet_Width));
						int flag_2 = (int) (sheet_Width / bothStrip_Width1);
						BothStripPieces = BothStripPieces + flag_2;

						
						
						nBoth.put(name, 0);
						if (BothStripPieces >= n) {
							System.out.println("if called....");
							BothStripPieces = 0;
							break;
						}

					}
				}
			}
		
		
		System.out.println("first phase end********************************");
		
		System.out.println("2nd phase start to get the random value************************************");
		
		//Wastage added
		SheetWastage sheetWastage = new SheetWastage();
		sheetWastage.setSheet_length(sheet_Length1);
		sheetWastage.setSheet_Width(sheet_Width);
		SheetWastage sheetWastage1 = sheetWastage;
			
		//for CircleStrips
		double sheetWastage_Length=0;

		if(circleStripSize != null)
		{
		for (int i = 0; i < circleStripSize.size(); i++) {
			String name = circleStripSize.get(i).getProductName();
			circleStrip_Id = circleStripSize.get(i).getId();
			circleStrip_Diameter = circleStripSize.get(i).getDimeter();
			circleStrip_Thickness = circleStripSize.get(i).getThikness();
			double circleStrip_Diameter1 = circleStrip_Diameter + tolerance;
			

		
			
			int circleStripPieces = 0;

				 sheetWastage_Length = sheetWastage.getSheet_length();
				//int circleStripPieces = 0;

				for (; sheetWastage_Length >= circleStrip_Diameter1;) {

					//System.out.println("loop called for strip ...."+ circleStrip_Diameter1);
					sheetWastage_Length = sheetWastage_Length- circleStrip_Diameter1;
					circleStripPieces = circleStripPieces + 1;
				

				}

				
				hm.put(new OptimumStrips("C",name,circleStrip_Diameter1,circleStrip_Diameter1),circleStripPieces);
				
					
		}
		}
			
		
		
		//for BothStrips
		
		if(bothStripSize != null)
		{
				for (int i = 0; i < bothStripSize.size(); i++) {
					String name = bothStripSize.get(i).getProductName();
					bothStrip_Id = bothStripSize.get(i).getId();
					bothStrip_Length = bothStripSize.get(i).getHeight();
					bothStrip_Width = bothStripSize.get(i).getWidth();
					bothStrip_Thickness = bothStripSize.get(i).getThikness();
					double bothStrip_Length1 = bothStrip_Length + tolerance;
					double bothStrip_Width1 = bothStrip_Width + tolerance;

				
					 sheetWastage_Length = sheetWastage.getSheet_length();
						int bothStripPieces = 0;

						for (; sheetWastage_Length >= bothStrip_Length1;) {

							//System.out.println("loop called for strip ...."+ circleStrip_Diameter1);
							sheetWastage_Length = sheetWastage_Length- bothStrip_Length1;
							bothStripPieces = bothStripPieces + 1;

						}

						hm.put(new OptimumStrips("R",name,bothStrip_Length1,bothStrip_Width1),bothStripPieces);
						
										
				}
			
		}
		
		System.out.println("2nd phase end to get the random value************************************");
			

			System.out.println("3rd phase start to make permutation combination cases!!!!!!!!!!!!!!!!!!!!!!!!!!");
			Set set = hm.entrySet();
			// Get an iterator
			Iterator it = set.iterator();
			// Display elements
			while (it.hasNext()) {
				Map.Entry me = (Map.Entry) it.next();
				/*System.out.print("key : " + me.getKey() + "mm");*/
				System.out.println("key : " + me.getKey());
				//int key=(Integer) me.getKey();
                OptimumStrips key =  (OptimumStrips)me.getKey();
                
				list4.add(key);
				
				System.out.println(" value : " + me.getValue());
			}
			for(int i=0;i<list4.size();i++)
			{
				OptimumStrips os =	(OptimumStrips)list4.get(i);
			int strip_Length =(int)os.getStrip_Length();
				list3.add(strip_Length);
			}
			System.out.println();

			double sheetWastage3 =sheetWastage1.getSheet_length();
			List<Focus> focuses = new ArrayList<Focus>();
			

			for (Integer value : hm.values()) {
				//System.out.println("Key = " + value);
				String[] value1 = new String[value + 1];

				for (int j = 0; j <= value; j++) {
					value1[j] = "" + j;
				}

				focuses.add(new Focus("Strip_" + value, value1));
				System.out.println();
			}
			
			String[] values = new String[focuses.size()];

						
			Map abc=CreateCombinations(focuses, 0, values, (int) sheetWastage3);

			
			System.out.println("abc: "+abc);
			 Set set1 = abc.entrySet();
		     // Get an iterator
		     Iterator it1 = set1.iterator();
		     // Display elements
		     while (it1.hasNext()) {
			Map.Entry me1 = (Map.Entry) it1.next();
			System.out.print("key : " + me1.getKey() + "mm");
			/*int num=(Integer) me1.getKey();
			int length=(Integer) me1.getValue();*/
			OptimumStrips os1 =(OptimumStrips) me1.getKey();
			String name=(String)os1.getName();
			String type=(String)os1.getType();
			int width=(int)os1.getStrip_Width();
			int length=(int)os1.getStrip_Length();
			int num=(Integer) me1.getValue();			
			
			for(int n=1;n<=num;n++){
				list.add(new IntermidiateSheet(type,name,length,width,sheet_Width));
				/*System.out.println("inside loop");*/
			}
		     }
		      
		    
		     
		     
		     //this part is to optimised the wastage from Algo part
		    		        
		     
		  // Cut Square/Rectangle from the main sheet
				if(bothStripSize != null)
				{
					
					
						for (int i = 0; i < bothStripSize.size(); i++) {
							String name = bothStripSize.get(i).getProductName();
							bothStrip_Id = bothStripSize.get(i).getId();
							bothStrip_Length = bothStripSize.get(i).getHeight();
							bothStrip_Width = bothStripSize.get(i).getWidth();
							bothStrip_Thickness = bothStripSize.get(i).getThikness();
							double bothStrip_Width1 = bothStrip_Width + tolerance;
							double bothStrip_Length1 = bothStrip_Length + tolerance;
					
							int BothStripPieces = 0;
							calculated_wastage1=calculated_wastage;
							
							for (; calculated_wastage1 >= bothStrip_Width1;) {

								System.out.println("loop called for WASTAGE ...."+bothStrip_Width1);
								calculated_wastage1 = (int) (calculated_wastage1 - bothStrip_Width1);
								wastage_list1.add(new IntermidiateSheet("R",name,bothStrip_Width1,bothStrip_Length1, sheet_Width));
									
															
							}
							
							if(wastage_flag1==0 || calculated_wastage1<min_wastage1)
							{
								min_wastage1=calculated_wastage1;
								wastage_flag1++;
								System.out.println("wastage_flag1: "+wastage_flag1);
								wastage_list.clear();
								wastage_list.addAll(wastage_list1);
													
								System.out.println("WASTAGE*************************************WASTAGE"+wastage_list);
								
							}
							
							wastage_list1.clear();
						}
						
						list.addAll(wastage_list);
						calculated_wastage=min_wastage1;
					}
				
		     
		     
		     System.out.println("List after: "+list);
			for (IntermidiateSheet p : list) {

				String type = p.getType();
				String name=p.getName();
				System.out.println("Name::::::"+name);
				int Strip_Length = (int) p.getStrip_Length();
				int Strip_Width = (int) p.getStrip_Width();
				
				int Sheet_Width = (int) p.getSheet_Width();
				int number = Sheet_Width / Strip_Width;
				
				int w_flag=(Sheet_Width % Strip_Width)*Strip_Length;
				wastage_flag= wastage_flag + w_flag;
				
				
				Strip_Length=Strip_Length-tolerance;
				Strip_Width=Strip_Width-tolerance;
				
				System.out.println("nCircle: "+nCircle);
				 Set set2 = nCircle.entrySet();
			     // Get an iterator
			     Iterator it2 = set2.iterator();
			     // Display elements
			     
			     
			     
				while (it2.hasNext()) {
					Map.Entry me2 = (Map.Entry) it2.next();
					System.out.println("key : " + me2.getKey());
					
					if(me2.getKey().equals(name)){
						
						int flag_3=(int) me2.getValue()+number;
						nCircle.put(name,flag_3);
					}
				}
				
				System.out.println("nBoth: "+nBoth);
				 Set set3 = nBoth.entrySet();
			     // Get an iterator
			     Iterator it3 = set3.iterator();
			     // Display elements
				while (it3.hasNext()) {
					Map.Entry me3 = (Map.Entry) it3.next();
					
					if(me3.getKey().equals(name)){
						
					int flag_4=(int)me3.getValue()+number;
						nBoth.put(name,flag_4);
					}
				}
				
				
				
				//mv.put(id, new FinalStrips(lenght, lenght, number));
				
				mv.put("type", type);
				mv.put("height", Strip_Length);
				mv.put("width", Strip_Width);
				mv.put("number", number);
				
			}
			
			System.out.println("No of circles ="+nCircle);
			System.out.println("No of Both ="+nBoth);
			//Both Sheet Description
			
			if(bothStripSize != null)
			{
					for (int i = 0; i < bothStripSize.size(); i++) {
						String name = bothStripSize.get(i).getProductName();
						bothStrip_Id = bothStripSize.get(i).getId();
						bothStrip_Length = bothStripSize.get(i).getHeight();
						bothStrip_Width = bothStripSize.get(i).getWidth();
						bothStrip_Thickness = bothStripSize.get(i).getThikness();
						bothStrip_Name= bothStripSize.get(i).getProductName();
						
						Strip_Desription.put("type", "R");
						Strip_Desription.put("name", bothStrip_Name);
						Strip_Desription.put("height", bothStrip_Length);
						Strip_Desription.put("width", bothStrip_Width);
						Strip_Desription.put("thickness", bothStrip_Thickness);
						
						int numberOfStrip=0;
						
						Set set4 = nBoth.entrySet();
					     // Get an iterator
					     Iterator it4 = set4.iterator();
					     // Display elements
						while (it4.hasNext()) {
							Map.Entry me4 = (Map.Entry) it4.next();
							
							if(me4.getKey().equals(name)){
								numberOfStrip=(int) me4.getValue();
							
							}
						}
						
						Strip_Desription.put("numberofBothStrips", numberOfStrip);
						
					}
			}
			
			
			if(circleStripSize != null)
			{
			for (int i = 0; i < circleStripSize.size(); i++) {
				String name = circleStripSize.get(i).getProductName();
				circleStrip_Id = circleStripSize.get(i).getId();
				circleStrip_Diameter = circleStripSize.get(i).getDimeter();
				circleStrip_Thickness = circleStripSize.get(i).getThikness();
				circleStrip_Name = circleStripSize.get(i).getProductName();
				
				Strip_Desription1.put("type", "C");
				Strip_Desription1.put("name", circleStrip_Name);
				Strip_Desription1.put("diameter", circleStrip_Diameter);
				Strip_Desription1.put("thickness", circleStrip_Thickness);
			
				int numberOfStrip=0;
				
				Set set5 = nCircle.entrySet();
			     // Get an iterator
			     Iterator it5 = set5.iterator();
			     // Display elements
				while (it5.hasNext()) {
					Map.Entry me5 = (Map.Entry) it5.next();
					
					if(me5.getKey().equals(name)){
						numberOfStrip=(int) me5.getValue();
					
					}
				}
				
				Strip_Desription1.put("numberofCircleStrips", numberOfStrip);
				
			}
			}
			
			//Just for display
			System.out.println("Fianl Result...."+mv);
			
			System.out.println("Both Strips Description...."+Strip_Desription);
			
			System.out.println("Circle Strips Description...."+Strip_Desription1);
			
			
			calculated_wastage=(int) (calculated_wastage*sheet_Width);
			
			calculated_wastage=calculated_wastage+wastage_flag;
			String SheetDimension=null;
			SheetDimension=(int)sheet_Length+" * "+(int)sheet_Width;
			
			double wastePercent= calculated_wastage/totalSheetArea*100;
			System.out.println(totalSheetArea);
			System.out.println("WASTEPERCENTAGE=="+wastePercent);
			Map final_result=new HashMap();
			
			final_result.put("Tolerance", tolerance);
			final_result.put("TotalSheetArea", totalSheetArea );
			final_result.put("TotalWastage", " "+ calculated_wastage);
			final_result.put("WastePercent"," "+ wastePercent+" %");
			final_result.put("SheetName", sheet_Name);
			final_result.put("SheetDimension", " "+SheetDimension);
			final_result.put("BothStripDescription", Strip_Desription);
			final_result.put("CircleStripDescription", Strip_Desription1);
			final_result.put("StripDimension", mv);
			final_result.put("SheetLength", " "+(int)sheet_Length);
			final_result.put("SheetWidth", " "+(int)sheet_Width);
			final_result.put("Scaling", "1");
			
			bothStripSize=null;
			circleStripSize=null;
			values_rec=null;
			values_circle=null;
			wastage_flag=0;
			calculated_wastage=0;
			flag=0;
			min_wastage=0;
			wastage_flag1=0;
			calculated_wastage1=0;
			wastage_flag1=0;
			
			
			System.out.println("DEBUGGINGGGGGGGGG");
			
			System.out.println(bothStripSize);
			System.out.println(circleStripSize);
			System.out.println(values_rec);
			System.out.println(values_circle);
			System.out.println(wastage_flag);
			System.out.println(calculated_wastage);
			System.out.println(min_wastage);
			System.out.println(flag);
			System.out.println(calculated_wastage1);
			System.out.println(min_wastage1);
			System.out.println(wastage_flag1);
			
			
			System.out.println("DEBUGGINGGGGGGGGG");
			
		return final_result;
	}

	
	private Map CreateCombinations(List<Focus> focuses, int index, String[] values, int sheetWastage) {
		// TODO Auto-generated method stub

		int sheetSize = sheetWastage;
		
		/*optimized_result=new ArrayList();
		optimized= new HashMap();*/
		//These two are global declare to solve the problem facing while selected 3 values
		
		
		System.out.println("list3: "+list3);
		int[] stripSizes = new int[list3.size()];
	    System.out.println("stripSizes"+stripSizes);
		
		for (int i = 0; i < stripSizes.length; i++) {
			stripSizes[i] = list3.get(i).intValue();
			System.out.println("stripSizes[i]: "+stripSizes[i]);
		}

		//StringBuilder sb1 = new StringBuilder();
		Focus focus = focuses.get(index);

		for (String v : focus.values) {
			values[index] = v;
			if (index < focuses.size() - 1) {
				// there is at least one other focus
				CreateCombinations(focuses, index + 1, values, sheetWastage);
			} else {
				// all values pinned down
				StringBuilder sb = new StringBuilder(values[0]);
				for (int i = 1; i < values.length; ++i) {
					sb.append(" ").append(values[i]);
					
				}
				// now do whatever you like to do with sb.toString()...
				String str = sb.toString();
				String a[] = str.split(" ");
				int av = 0;
				for (int i = 0; i < a.length; i++)
				{
					av = av + Integer.parseInt(a[i]) * stripSizes[i];
				}
				if (av <= sheetSize) {
					calculated_wastage=sheetSize - av;
					

					if(flag==0 || calculated_wastage<min_wastage)
					{
						flag++;
						System.out.println("flag: "+flag);
						System.out.println("calculated_wastage: "+calculated_wastage);
						System.out.println("min_wastage: "+min_wastage);
						min_wastage=calculated_wastage;
						System.out.println("New min wastage"+min_wastage);
						optimized.clear();
						for (int i = 0; i < a.length; i++)
						{
							System.out.println("piece to cut: "+a[i]);
							/*System.out.println("width: "+ list3.get(i));*/
							System.out.println("Length: "+ list3.get(i));
							System.out.println("Integer.parseInt(a[i]): "+Integer.parseInt(a[i]));
							
							/*optimized.put(Integer.parseInt(a[i]), list3.get(i));*/
							optimized.put(list4.get(i),Integer.parseInt(a[i]));
						}
						
						
						//	list.add(new IntermidiateSheet("C",list3.get(i), sheet_Width));	
						
						System.out.println("OPTIMISED............"+optimized);
					}
				}
			}
		}
		flag=0;
		/*sheetSize=0;
		calculated_wastage=0;*/
		return optimized;

	}

}
//checking