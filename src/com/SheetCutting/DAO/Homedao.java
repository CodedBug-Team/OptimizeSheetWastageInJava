package com.SheetCutting.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SheetCutting.Entity.Bothstripsize;
import com.SheetCutting.Entity.Circlestripsize;
import com.SheetCutting.Entity.Sheetsize;

@Repository
public class Homedao {

	@Autowired
	private SessionFactory sessionFactory;

	public String addSheet(Sheetsize sheetSize) {
		try {

			sessionFactory.getCurrentSession().saveOrUpdate(
					Sheetsize.class.getName(), sheetSize);
			return "Updated";
		} catch (Exception e) {

			return "Try Again!";
		}
	}

	 public Sheetsize getById(int id)
	  {
	   return (Sheetsize) sessionFactory.getCurrentSession().get(Sheetsize.class, id);
	 
	  }
	
	 public Circlestripsize getByCircleId(int id)
	  {
	   return (Circlestripsize) sessionFactory.getCurrentSession().get(Circlestripsize.class, id);
	 
	  }


	public String deleteSheet(int id) {
		try {
			Sheetsize sheetsize  = getById(id);
			  sessionFactory.getCurrentSession().delete(sheetsize);
			return "Updated";
		} catch (Exception e) {
			return "Try Again!";
		}
	}
	
	public String updateSheet(List<String> updated_value) {
		try {
			Sheetsize sheetsize  = getById(Integer.parseInt(updated_value.get(0)));
			sheetsize.setSheetName(updated_value.get(2));
			sheetsize.setHeight((double)Double.parseDouble(updated_value.get(3)));
			sheetsize.setThikness((double)Double.parseDouble(updated_value.get(5)));
			sheetsize.setWidth((double)Double.parseDouble(updated_value.get(4)));
			sheetsize.setNoOfSheets(Integer.parseInt(updated_value.get(6)));
			  sessionFactory.getCurrentSession().update(sheetsize);
			return "Updated";
		} catch (Exception e) {

			return "Try Again!";
		}
	}
	
	public String updateCircle(List<String> updated_value) {
		try {
			System.out.println("circle1");
			
			Circlestripsize circlestripsize = getByCircleId(Integer.parseInt(updated_value.get(0)));
			circlestripsize.setDimeter((double) Integer.parseInt(updated_value.get(2)));
			circlestripsize.setThikness((double)Integer.parseInt(updated_value.get(3)));
			circlestripsize.setProductName(updated_value.get(4));
			sessionFactory.getCurrentSession().update(circlestripsize);
			System.out.println("circle2");
			return "Updated";
		} catch (Exception e) {

			return "Try Again!";
		}
	}
	
	public String updateBoth(List<String> updated_value) {
		try {
			Bothstripsize bothstripsize = getByBothId(Integer.parseInt(updated_value.get(0)));
			bothstripsize.setHeight((double) Integer.parseInt(updated_value.get(2)));
			bothstripsize.setWidth((double)Integer.parseInt(updated_value.get(3)));
			bothstripsize.setThikness((double)Integer.parseInt(updated_value.get(4)));
			bothstripsize.setProductName(updated_value.get(5));
			sessionFactory.getCurrentSession().update(bothstripsize);
			return "Updated";
		} catch (Exception e) {

			return "Try Again!";
		}
	}
	
	
	public String deleteCicrle(int id) {
		try {
			Circlestripsize circlestripsize   = getByCircleId(id);
			
			  sessionFactory.getCurrentSession().delete(circlestripsize);

			
			return "Updated";
		} catch (Exception e) {

			return "Try Again!";
		}
	}
	
	public Bothstripsize getByBothId(int id)
	  {
	   return (Bothstripsize) sessionFactory.getCurrentSession().get(Bothstripsize.class, id);
	 
	  }

	public String deleteBoth(int id) {
		try {
			Bothstripsize bothstripsize   = getByBothId(id);
			
			  sessionFactory.getCurrentSession().delete(bothstripsize);

			
			return "Updated";
		} catch (Exception e) {

			return "Try Again!";
		}
	}
	

	@SuppressWarnings("unchecked")
	public List<Sheetsize> findAllSheet() {
		List<Sheetsize> sheetSize = null;
		try {

			sheetSize = (List<Sheetsize>) sessionFactory.getCurrentSession()
					.createQuery("Select s from Sheetsize s").list();

		} catch (Exception e) {
			System.out.println("In side Find");

		}

		if (sheetSize == null || sheetSize.isEmpty()) {
			System.out.println("Null value");
			return null;
		}
		// System.out.println(notifications.get(0).getNews());
		return sheetSize;
	}

	public String addCircleStipSize(Circlestripsize circleStripSize) {
		try {

			sessionFactory.getCurrentSession().saveOrUpdate(
					Circlestripsize.class.getName(), circleStripSize);
			return "CUpdated";
		} catch (Exception e) {

			return "Try Again!";
		}
	}

	@SuppressWarnings("unchecked")
	public List<Circlestripsize> findAllCircleStripSize() {
		List<Circlestripsize> circleStripSize = null;
		try {

			circleStripSize = (List<Circlestripsize>) sessionFactory
					.getCurrentSession()
					.createQuery("Select c from Circlestripsize c").list();

		} catch (Exception e) {
			System.out.println("In side Find");

		}

		if (circleStripSize == null || circleStripSize.isEmpty()) {
			System.out.println("Null value");
			return null;
		}

		return circleStripSize;
	}

	public String addBothStirpSize(Bothstripsize bothStripSize) {
		try {

			sessionFactory.getCurrentSession().saveOrUpdate(
					Bothstripsize.class.getName(), bothStripSize);
			return "BUpdated";
		} catch (Exception e) {

			return "Try Again!";
		}
	}

	/* action add by ruby */
	@SuppressWarnings("unchecked")
	public List<Bothstripsize> findBothStripSizeByIds(List<Integer> rec_id) {

		List<Bothstripsize> bothstripsize = new ArrayList<Bothstripsize>();
System.out.println("rec_id in dao before for"+rec_id);
		for (int i = 0; i < rec_id.size(); i++) {
			System.out.println("rec_id in dao after for"+rec_id);
			Bothstripsize sheetSize = null;
			try {
				int id = rec_id.get(i);
				
				sheetSize = (Bothstripsize) sessionFactory.getCurrentSession()
						.createQuery(
								" from Bothstripsize where id="
										+ id ).uniqueResult();
				System.out.println("sheetSize in dao =" +sheetSize);
			

			} catch (Exception e) {

			}
			bothstripsize.add(sheetSize);
		}
		if (bothstripsize == null || bothstripsize.isEmpty()) {
			System.out.println("Null value in dao");
			return null;
		}
		System.out.println("bothstripsize in dao =" + bothstripsize);
		return bothstripsize;

	}

	/* action add by ruby */
	@SuppressWarnings("unchecked")
	public List<Circlestripsize> findCircleStripSizeByIds(
			List<Integer> circle_id) {

		List<Circlestripsize> circlestripsize = new ArrayList<Circlestripsize>();

		for (int i = 0; i < circle_id.size(); i++) {
			Circlestripsize sheetSize = null;
			try {
				int id = circle_id.get(i);
				sheetSize = (Circlestripsize) sessionFactory
						.getCurrentSession().createQuery(
								"from Circlestripsize where id="
										+ id ).uniqueResult();
				

			} catch (Exception e) {

			}
			circlestripsize.add(sheetSize);
		}
		if (circlestripsize == null || circlestripsize.isEmpty()) {
			System.out.println("Null value");
			return null;
		}

		return circlestripsize;

	}

	@SuppressWarnings("unchecked")
	public List<Bothstripsize> findAllBothStripSize() {
		List<Bothstripsize> bothStripSize = null;
		try {

			bothStripSize = (List<Bothstripsize>) sessionFactory
					.getCurrentSession()
					.createQuery("Select b from Bothstripsize b").list();

		} catch (Exception e) {
			System.out.println("In side Find");

		}

		if (bothStripSize == null || bothStripSize.isEmpty()) {
			System.out.println("Null value");
			return null;
		}

		return bothStripSize;
	}

	@SuppressWarnings("unchecked")
	public List<Sheetsize> findSheet(Double thikness) {
		List<Sheetsize> sheetSize = null;

		try {

			sheetSize = (List<Sheetsize>) sessionFactory
					.getCurrentSession()
					.createQuery(
							"Select u from Sheetsize u where u.thikness='"
									+ thikness + "'").list();

		} catch (Exception e) {

		}

		if (sheetSize == null || sheetSize.isEmpty()) {
			System.out
					.println("Null value in service while finding sheets with thickness");
			return null;
		}

		return sheetSize;
	}

	@SuppressWarnings("unchecked")
	public List<Circlestripsize> findCircleByThickness(Double thickness) {

		List<Circlestripsize> sheetSize = null;
		System.out.println("homedao thickness: "+thickness);
		try {
			sheetSize = (List<Circlestripsize>) sessionFactory
					.getCurrentSession()
					.createQuery(
							"Select u from Circlestripsize u where u.thikness='"
									+ thickness.intValue() + "'").list();
		} catch (Exception e) {
		}

		if (sheetSize == null || sheetSize.isEmpty()) {
			System.out
					.println("Null value in service while finding circles with thickness");
			return null;
		}

		return sheetSize;
	}

	@SuppressWarnings("unchecked")
	public List<Bothstripsize> findBothByThickness(Double thickness) {
		List<Bothstripsize> sheetSize = null;

		try {

			sheetSize = (List<Bothstripsize>) sessionFactory
					.getCurrentSession()
					.createQuery(
							"Select u from Bothstripsize u where u.thikness='"
									+ thickness + "'").list();

		} catch (Exception e) {

		}

		if (sheetSize == null || sheetSize.isEmpty()) {
			System.out
					.println("Null value in service while finding both with thickness");
			return null;
		}

		return sheetSize;
	}

	@SuppressWarnings("unchecked")
	public Circlestripsize findCircleById(String string) {

		List<Circlestripsize> sheetSize = null;

		try {

			sheetSize = (List<Circlestripsize>) sessionFactory
					.getCurrentSession()
					.createQuery(
							"Select u from Circlestripsize u where u.id='"
									+ string + "'").list();
			System.out.println(sheetSize.indexOf(string) + "sheet size in dao");

		} catch (Exception e) {

		}

		if (sheetSize == null || sheetSize.isEmpty()) {
			System.out.println("Null value");
			return null;
		}
		System.out.println(sheetSize.get(0).getDimeter() + "diameter");
		System.out.println(sheetSize.get(0).getThikness() + "sheet thickness");
		return sheetSize.get(0);

	}

	@SuppressWarnings("unchecked")
	public Bothstripsize findBothById(String string) {
		List<Bothstripsize> sheetSize = null;

		try {

			sheetSize = (List<Bothstripsize>) sessionFactory
					.getCurrentSession()
					.createQuery(
							"Select u from Bothstripsize u where u.id='"
									+ string + "'").list();

		} catch (Exception e) {

		}

		if (sheetSize == null || sheetSize.isEmpty()) {
			System.out.println("Null value");
			return null;
		}

		return sheetSize.get(0);
	}

	@SuppressWarnings("unchecked")
	public Sheetsize findSheetSizeById(int sheetId) {
		List<Sheetsize> sheetSize = null;

		try {

			sheetSize = (List<Sheetsize>) sessionFactory
					.getCurrentSession()
					.createQuery(
							"Select u from Sheetsize u where u.id='" + sheetId
									+ "'").list();

		} catch (Exception e) {

		}

		if (sheetSize == null || sheetSize.isEmpty()) {
			System.out.println("Null value");
			return null;
		}

		return sheetSize.get(0);
	}

}
