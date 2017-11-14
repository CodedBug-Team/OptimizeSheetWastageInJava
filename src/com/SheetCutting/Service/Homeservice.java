package com.SheetCutting.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SheetCutting.DAO.Homedao;
import com.SheetCutting.Entity.Bothstripsize;
import com.SheetCutting.Entity.Circlestripsize;
import com.SheetCutting.Entity.Sheetsize;

@Service
public class Homeservice {
	@Autowired
	private Homedao homedao;

	@Transactional
	public String addSheet(String name, double height, double width,
			double thikness, int nos) {
		String status = "";
		Sheetsize sheetSize = new Sheetsize();
		sheetSize.setSheetName(name);
		sheetSize.setHeight(height);
		sheetSize.setThikness(thikness);
		sheetSize.setWidth(width);
		sheetSize.setNoOfSheets(nos);
		status = homedao.addSheet(sheetSize);
		return status;
	}

	@Transactional
	public List<Sheetsize> findAllSheet() {

		return homedao.findAllSheet();
	}

	@Transactional
	public String deleteSheet(int id) {
		String status = "";
		status = homedao.deleteSheet(id);
		return status;
	}

	@Transactional
	public String deleteCircle(int id) {
		String status = "";
		status = homedao.deleteCicrle(id);
		return status;
	}

	@Transactional
	public String updateSheet(List<String> updated_value) {
		String status = "";
		status = homedao.updateSheet(updated_value);
		return status;
	}
	
	@Transactional
	public String updateCircle(List<String> updated_value) {
		String status = "";
		System.out.println("circle: "+updated_value);
		status = homedao.updateCircle(updated_value);
		return status;
	}
	
	@Transactional
	public String updateBoth(List<String> updated_value) {
		String status = "";
		status = homedao.updateBoth(updated_value);
		return status;
	}

	@Transactional
	public String deleteBoth(int id) {
		String status = "";
		status = homedao.deleteBoth(id);
		return status;
	}

	@Transactional
	public String addCircleStipSize(Double dimeter, Double thikness,
			String productName) {
		Circlestripsize circleStripSize = new Circlestripsize();
		circleStripSize.setDimeter(dimeter);
		circleStripSize.setProductName(productName);
		circleStripSize.setThikness(thikness);
		return homedao.addCircleStipSize(circleStripSize);
	}

	@Transactional
	public List<Circlestripsize> findAllCircleStripSize() {
		return homedao.findAllCircleStripSize();
	}

	@Transactional
	public String addBothStipSize(Double height, Double width, Double thikness,
			String productName) {
		Bothstripsize bothStripSize = new Bothstripsize();
		bothStripSize.setHeight(height);
		bothStripSize.setProductName(productName);
		bothStripSize.setThikness(thikness);
		bothStripSize.setWidth(width);
		return homedao.addBothStirpSize(bothStripSize);
	}

	/* Service add by ruby */
	@Transactional
	public List<Bothstripsize> findBothStripSizeByIds(List<Integer> rec_id) {
		// TODO Auto-generated method stub
		return homedao.findBothStripSizeByIds(rec_id);
	}

	/* Service add by ruby */
	@Transactional
	public List<Circlestripsize> findCircleStripSizeByIds(
			List<Integer> circle_id) {
		// TODO Auto-generated method stub
		return homedao.findCircleStripSizeByIds(circle_id);
	}

	@Transactional
	public List<Bothstripsize> findAllBothStripSize() {
		// TODO Auto-generated method stub
		return homedao.findAllBothStripSize();
	}

	@Transactional
	public Sheetsize findSheetSizeById(int sheetId) {
		// TODO Auto-generated method stub
		return homedao.findSheetSizeById(sheetId);
	}

	@Transactional
	public List<Sheetsize> findSheet(Double thikness) {
		// TODO Auto-generated method stub
		return homedao.findSheet(thikness);
	}

	@Transactional
	public List<Circlestripsize> findCircleByThickness(Double thickness) {
		// TODO Auto-generated method stub
		return homedao.findCircleByThickness(thickness);
	}

	@Transactional
	public List<Bothstripsize> findBothByThickness(Double thickness) {
		// TODO Auto-generated method stub
		return homedao.findBothByThickness(thickness);
	}

	
	/* Cutting Logic */

	@Transactional
	public String cuttingSheet(int sheetId, List<String> circle,
			List<String> both) {
		Circlestripsize circleStrip = null;
		Double Area = 0.0;
		String status = "";

		/* sheetvalue */

		Sheetsize sheetSize = null;
		sheetSize = homedao.findSheetSizeById(sheetId);
		Double sheetwidth = sheetSize.getWidth();

		/* sheetvalue end */

		Double width = 0.0;
		Double height = 0.0;
		for (int i = 0; i < circle.size(); i++) {
			circleStrip = homedao.findCircleById(circle.get(i));
			width += circleStrip.getDimeter();
			if (height < circleStrip.getDimeter()) {
				height = circleStrip.getDimeter();

			}

			/*
			 * if(width > sheetSize.getWidth()) {
			 * 
			 * }
			 */

		}

		Bothstripsize bothStrip = null;
		for (int i = 0; i < both.size(); i++) {

			bothStrip = homedao.findBothById(both.get(i));

			width += bothStrip.getWidth();

			if (height < bothStrip.getWidth()) {
				height = bothStrip.getHeight();
			}

		}

		System.out.println("--------------------------------------" + width);

		System.out.println("--------------------------------------" + height);

		Double sheetWidth = sheetSize.getWidth();
		Double sheetHeight = sheetSize.getHeight();

		System.out.println("-----------" + sheetHeight);

		if (sheetWidth < width || sheetHeight < height) {

			status = "Try Again";
		}

		boolean flag = false;

		if (sheetHeight > height) {

			sheetSize.setHeight(sheetSize.getHeight() - height);
			System.out.println("height Minus");
			homedao.addSheet(sheetSize);
			flag = true;
			status = "Checking";

		}

		if (sheetWidth > width && flag)

		{

			Sheetsize size = new Sheetsize();
			size.setHeight(height);
			size.setWidth(sheetSize.getWidth() - width);
			size.setThikness(sheetSize.getThikness());
			homedao.addSheet(size);
			status = "Checking";
		}

		if (height.equals(sheetHeight) && sheetWidth.equals(width)) {
			System.out.println("height Minus");
			/*
			 * sheetSize.setWidth(sheetSize.getWidth()-width);
			 * sheetSize.setHeight(sheetSize.getHeight() - height);
			 */
			// homedao.deleteSheet(sheetSize);
			status = "Checking";
		}

		System.out.println("---" + width);
		if (height.equals(sheetHeight) && !sheetWidth.equals(width)) {
			System.out.println("width Minus");
			sheetSize.setWidth(sheetSize.getWidth() - width);
			homedao.addSheet(sheetSize);
			status = "Checking";
		}

		return status;
	}

}
