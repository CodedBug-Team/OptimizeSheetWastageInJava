package com.SheetCutting.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.SheetCutting.Algo.Algo;
import com.SheetCutting.Entity.Bothstripsize;
import com.SheetCutting.Entity.Circlestripsize;
import com.SheetCutting.Entity.JsonResponse;
import com.SheetCutting.Entity.Sheetsize;
import com.SheetCutting.Service.Homeservice;

@Controller
public class HomeController {

	@Autowired
	private Homeservice homeservice;

	@Autowired
	private Algo algo;

	// private static final Logger logger =
	// LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView firstPage() {
		System.out.println("First Call");
		ModelAndView model = new ModelAndView("login");
		return model;
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView("admin");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		System.out.println("Hello");
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		return model;

	}

	@RequestMapping(value = "/addSheet", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse addSheet(HttpServletRequest request) {
		List<Sheetsize> sheetSize = null;
		JsonResponse res = new JsonResponse();
		double height = 0;
		double width = 0;
		double thikness = 0;
		String name = null;
		int nos = 0;
		try {
			width = Double
					.parseDouble(request.getParameter("width").toString());
			height = Double.parseDouble(request.getParameter("height"));
			thikness = Double.parseDouble(request.getParameter("thikness"));
			nos = Integer.parseInt(request.getParameter("nos").toString());
			name = request.getParameter("name").toString();
		} catch (Exception e) {
			res.setStatus("FAIL");
			return res;
		}
		res.setStatus(homeservice.addSheet(name, height, width, thikness, nos));
		sheetSize = homeservice.findAllSheet();
		res.setResult(sheetSize);
		return res;
	}

	/* Get all the sheets */
	@RequestMapping(value = "/getSheet", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse getSheet(HttpServletRequest request) {
		List<Sheetsize> sheetSize = null;
		JsonResponse res = new JsonResponse();
		System.out.println("getSheet called");
		res.setStatus("getsheet");
		sheetSize = homeservice.findAllSheet();
		res.setResult(sheetSize);
		System.out.println("getSheet: " + sheetSize);
		return res;

	}

	@RequestMapping(value = "/deleteSheet", method = RequestMethod.GET)
	public @ResponseBody
	JsonResponse deleteSheet(HttpServletRequest request) {
		System.out.println("deleteSheet called");
		// void deleteSheet(HttpServletRequest request) {
		JsonResponse res = new JsonResponse();
		System.out.println("Sheet id =" + request.getParameter("sheetId"));

		int id = Integer.parseInt(request.getParameter("sheetId"));
		List<Sheetsize> sheetSize = null;
		res.setStatus(homeservice.deleteSheet(id));
		sheetSize = homeservice.findAllSheet();
		res.setResult(sheetSize);
		return res;

	}

	
	@RequestMapping(value = "/updateSheet", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse updateSheet(@RequestParam(value = "updated_value[]") List<String> updated_value) {
		System.out.println("updateSheet called");
		// void deleteSheet(HttpServletRequest request) {
		JsonResponse res = new JsonResponse();
		
		System.out.println("parameterMap: "+updated_value);
		List<Sheetsize> sheetSize = null;
		res.setStatus(homeservice.updateSheet(updated_value));
		sheetSize = homeservice.findAllSheet();
		res.setResult(sheetSize);
		return res;

	}
	
	@RequestMapping(value = "/updateCircle", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse updateCircle(@RequestParam(value = "updated_value[]") List<String> updated_value) {
		System.out.println("updateCircle called");
		// void deleteSheet(HttpServletRequest request) {
		JsonResponse res = new JsonResponse();
		
		System.out.println("parameterMap: "+updated_value);
		List<Circlestripsize> sheetSize = null;
		res.setStatus(homeservice.updateCircle(updated_value));
		sheetSize = homeservice.findAllCircleStripSize();
		res.setResult(sheetSize);
		return res;

	}
	
	@RequestMapping(value = "/updateBoth", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse updateBoth(@RequestParam(value = "updated_value[]") List<String> updated_value) {
		System.out.println("updateBoth called");
		// void deleteSheet(HttpServletRequest request) {
		JsonResponse res = new JsonResponse();
		
		System.out.println("parameterMap: "+updated_value);
		List<Bothstripsize> sheetSize = null;
		res.setStatus(homeservice.updateBoth(updated_value));
		sheetSize = homeservice.findAllBothStripSize();
		res.setResult(sheetSize);
		return res;

	}
	
	
	@RequestMapping(value = "/deleteCircle", method = RequestMethod.GET)
	public @ResponseBody
	JsonResponse deleteCircle(HttpServletRequest request) {
		System.out.println("deleteSheet called");
		JsonResponse res = new JsonResponse();
		System.out.println("Circle id =" + request.getParameter("circleId"));

		int id = Integer.parseInt(request.getParameter("circleId"));
		List<Circlestripsize> circleStripSize = null;
		res.setStatus(homeservice.deleteCircle(id));
		circleStripSize = homeservice.findAllCircleStripSize();
		res.setResult(circleStripSize);

		return res;

	}

	@RequestMapping(value = "/deleteBoth", method = RequestMethod.GET)
	public @ResponseBody
	JsonResponse deleteBoth(HttpServletRequest request) {
		System.out.println("deleteBoth called");
		JsonResponse res = new JsonResponse();
		System.out.println("Both id =" + request.getParameter("BothId"));

		int id = Integer.parseInt(request.getParameter("BothId"));
		List<Bothstripsize> bothStripSize = null;
		res.setStatus(homeservice.deleteBoth(id));
		bothStripSize = homeservice.findAllBothStripSize();
		res.setResult(bothStripSize);

		return res;

	}

	/* find Sheet based on thickness */
	@RequestMapping(value = "/getData", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse findAll(HttpServletRequest request) {
		List<Sheetsize> sheetSize = null;

		JsonResponse res = new JsonResponse();
		Double thikness = Double.parseDouble(request.getParameter("thikness")
				.toString());
		sheetSize = homeservice.findSheet(thikness);
		System.out.println("sheetSize: "+sheetSize);
		System.out.println("Thickenss-------" + thikness);
		res.setStatus("Got");
		res.setResult(sheetSize);
		return res;

	}

	@RequestMapping(value = "/addStips", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse addStrips(HttpServletRequest request) {
		/* String type = request.getParameter("select"); */

		Double dimeter, thikness, height, width;
		String productName;
		JsonResponse res = new JsonResponse();

		try {
			System.out.println("in addStips after if");
			List<Circlestripsize> circleStripSize = null;
			List<Bothstripsize> bothStripSize = null;
			String dimeter1 = request.getParameter("dimeter");
			String thikness1 = request.getParameter("thickness");
			productName = request.getParameter("productName");

			String height1 = request.getParameter("height");
			String width1 = request.getParameter("width");

			if (width1 != null) {
				thikness = Double.parseDouble(thikness1);
				height = Double.parseDouble(height1);
				width = Double.parseDouble(width1);

				res.setStatus(homeservice.addBothStipSize(height, width,
						thikness, productName));
				bothStripSize = homeservice.findAllBothStripSize();
				res.setResult(bothStripSize);
			} else {
				thikness = Double.parseDouble(thikness1);

				dimeter = Double.parseDouble(dimeter1);

				res.setStatus(homeservice.addCircleStipSize(dimeter, thikness,
						productName));
				circleStripSize = homeservice.findAllCircleStripSize();
				res.setResult(circleStripSize);
			}

			/*
			 * System.out.println("in addStips after try");
			 * System.out.println(type); if (type.equals("Circle")) {
			 * System.out.println("in addStips after if"); List<Circlestripsize>
			 * circleStripSize = null; dimeter =
			 * Double.parseDouble(request.getParameter("dimeter") .toString());
			 * thikness = Double.parseDouble(request.getParameter("thickness")
			 * .toString()); productName = request.getParameter("productName");
			 * res.setStatus(homeservice.addCircleStipSize(dimeter, thikness,
			 * productName)); circleStripSize =
			 * homeservice.findAllCircleStripSize();
			 * res.setResult(circleStripSize);
			 * System.out.println("productName = "+productName);
			 * 
			 * } else { List<Bothstripsize> bothStripSize = null; height =
			 * Double.parseDouble(request.getParameter("height") .toString());
			 * width = Double.parseDouble(request.getParameter("width")
			 * .toString()); thikness =
			 * Double.parseDouble(request.getParameter("thickness")
			 * .toString()); productName = request.getParameter("productName");
			 * res.setStatus(homeservice.addBothStipSize(height, width,
			 * thikness, productName)); bothStripSize =
			 * homeservice.findAllBothStripSize(); res.setResult(bothStripSize);
			 * }
			 */
		} catch (Exception e) {

			res.setStatus("Check Data Type");
			res.setResult(null);
		}
		return res;
	}

	/* Get the value of the strips */
	@RequestMapping(value = "/getStrip", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse getStrip(HttpServletRequest request) {
		String type = request.getParameter("type");
		System.out.println("type: " + type);
		/*
		 * Double dimeter, thikness, height, width; String productName;
		 */
		JsonResponse res = new JsonResponse();
		try {
			if (type.equals("Circle")) {

				List<Circlestripsize> circleStripSize = null;
				circleStripSize = homeservice.findAllCircleStripSize();
				res.setStatus("circle");
				res.setResult(circleStripSize);

			} else if (type.equals("both")) {
				List<Bothstripsize> bothStripSize = null;
				bothStripSize = homeservice.findAllBothStripSize();
				System.out.println("in both function");
				res.setStatus("both");
				res.setResult(bothStripSize);
			}
		} catch (Exception e) {
			res.setStatus("Check Data Type");
			res.setResult(null);
		}
		return res;
	}

	@RequestMapping(value = "/displayDrop", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse displayDrop(HttpServletRequest request) {

		Double thickness = null;
		JsonResponse res = new JsonResponse();
		try {
			thickness = Double.parseDouble(request.getParameter("cdDrop"));

		} catch (Exception e) {
			res.setStatus("Check Data type");
			res.setResult(null);
			return res;
		}

		List<Circlestripsize> circleStripSize = null;
		circleStripSize = homeservice.findCircleByThickness(thickness);
		res.setResult(circleStripSize);
		System.out.println("Called circleStripSize: "+circleStripSize);
		res.setStatus("Got");

		return res;

	}

	@RequestMapping(value = "/displayDrop2", method = RequestMethod.POST)
	public @ResponseBody
	JsonResponse displayDropSecond(HttpServletRequest request) {
		Double thickness = null;
		JsonResponse res = new JsonResponse();
		try {
			thickness = Double.parseDouble(request.getParameter("cdDrop"));

		} catch (Exception e) {
			res.setStatus("Check Data type");
			res.setResult(null);
			return res;
		}

		System.out.println(thickness);

		List<Bothstripsize> bothStripSize = null;
		bothStripSize = homeservice.findBothByThickness(thickness);
		System.out.println("bothStripSize: "+bothStripSize);
		res.setResult(bothStripSize);
		res.setStatus("Got");

		return res;

	}

	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public
	 * ModelAndView firstPage() { System.out.println("First Call"); ModelAndView
	 * model = new ModelAndView("login"); return model; }
	 */

	/* Action changed by Abhishek */
	@RequestMapping(value = "/cutting", method = RequestMethod.POST)
	//@ResponseBody
	//public JsonResponse cuttingSheet(HttpServletRequest request,HttpSession session) {
	public ModelAndView cuttingSheet(HttpServletRequest request,HttpSession session) {
		int sheetId = Integer.parseInt(request.getParameter("sheetid")
				.toString());
		// int total =
		// Integer.parseInt(request.getParameter("total").toString());
		int tolerance = Integer.parseInt(request.getParameter("tolerance")
				.toString());

		tolerance *= 2;
		String[] strip_id = request.getParameterValues("strip_id");
		/* strip_value */
		String[] strip_value_c = request.getParameterValues("strip_value_c");
		String[] strip_value_r = request.getParameterValues("strip_value_r");

		Sheetsize sheetsize = null;
		sheetsize = homeservice.findSheetSizeById(sheetId);
		algo.setSheetsize(sheetsize);
		int id = sheetsize.getId();
		double length = sheetsize.getHeight();
		double width = sheetsize.getWidth();

		List<Integer> circle_id = new ArrayList<Integer>();
		List<Integer> rec_id = new ArrayList<Integer>();

		List<Circlestripsize> circleStripSize = new ArrayList<Circlestripsize>();
		List<Bothstripsize> bothStripSize = new ArrayList<Bothstripsize>();
		List<Integer> values_c = new ArrayList<Integer>();
		List<Integer> values_r = new ArrayList<Integer>();

		for (int i = 0; i < strip_id.length; i++) {
			// System.out.println("in strip loop");
			if (!strip_id[i].equals("0")) {
				String[] splitId = strip_id[i].split("-");

				// System.out.println("splitId: "+splitId);
				if (splitId[0].equals("r")) {
					// System.out.println(splitId[1]);
					rec_id.add(Integer.parseInt(splitId[1]));
				} else if (splitId[0].equals("c")) {
					// System.out.println(splitId[1]);
					circle_id.add(Integer.parseInt(splitId[1]));
				}
			}
		}
		if (strip_value_r != null) {
			for (int i = 0; i < strip_value_r.length; i++) {
				// System.out.println("in rectangle loop");
				if (!strip_value_r[i].equals("")) {
					values_r.add(Integer.parseInt(strip_value_r[i]));
				}
			}
		}
		if (strip_value_c != null) {
			for (int i = 0; i < strip_value_c.length; i++) {
				// System.out.println("in circle loop");
				// System.out.println("strip_value_c[i]: "+strip_value_c[i]);
				if (!strip_value_c[i].equals("")) {
					values_c.add(Integer.parseInt(strip_value_c[i]));
				}
			}
		}

		if (rec_id.size() > 0) {
			bothStripSize = homeservice.findBothStripSizeByIds(rec_id);
			// System.out.println("bothStripSize in controller = "+bothStripSize);
		}
		if (circle_id.size() > 0) {

			circleStripSize = homeservice.findCircleStripSizeByIds(circle_id);
			// System.out.println("circleStripSize in controller = "+circleStripSize);
		}
		if (bothStripSize.size() > 0)
			algo.setBothStripSize(bothStripSize);
		if (circleStripSize.size() > 0)
			algo.setCircleStripSize(circleStripSize);
		algo.setTolerance(tolerance);
		if (values_r.size() > 0)
			algo.setValues_rec(values_r);
		if (values_c.size() > 0)
			algo.setValues_circle(values_c);

		Map final_result = algo.cuttingSheet();

		// String SheetLength = (String)final_result.get("SheetLength");
		// String SheetWidth = (String)final_result.get("SheetWidth");

		/*
		 * String SheetLength = (String)final_result.get("SheetLength"); String
		 * SheetWidth = (String)final_result.get("SheetWidth"); SheetLength =
		 * SheetLength.trim(); int l = Integer.parseInt(SheetLength);
		 * 
		 * SheetWidth = SheetWidth.trim(); int w = Integer.parseInt(SheetWidth);
		 * 
		 * int scaling = 20; l /= scaling; w /= scaling;
		 * 
		 * session.setAttribute("SheetLength", Integer.valueOf(l));
		 * session.setAttribute("SheetWidth", Integer.valueOf(w));
		 */
		
		 JsonResponse res = new JsonResponse(); 
		 res.setResult(final_result);
		 //res.setStatus("report"); 
		 //return res;
		 

		ModelAndView model = new ModelAndView("report", final_result);

		return model;

	}

}

/*
 * ref http://java.dzone.com/articles/allowing-duplicate-keys-java
 */
