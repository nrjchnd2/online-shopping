package com.neeraj.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neeraj.shoppingbackend.dao.CategoryDAO;
import com.neeraj.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext cxt;
	private static CategoryDAO categoryDAO;

	@BeforeClass
	public static void init() {

		cxt = new AnnotationConfigApplicationContext();
		cxt.scan("com.neeraj.shoppingBackend");
		cxt.refresh();
		categoryDAO = (CategoryDAO) cxt.getBean("categoryDAO");

	}

	/*
	 * @Test public void testAddCategoty(){ Category category=new Category();
	 * category.setName("gainers"); category.setDescription("mass gainers");
	 * category.setImageUrl("p2.png");
	 * assertEquals("successfully added a category",true,categoryDAO.addCategory
	 * (category)); }
	 */

	@Test
	public void testGetCategory() {
		Category category = categoryDAO.get(3);
		assertEquals("successfully fetched one id from DB", true, category.getName().equalsIgnoreCase("cameras"));
	}

	/*
	 * @Test public void testupdateCategory() { Category category =
	 * categoryDAO.get(3); category.setName("Gain");
	 * assertEquals("successfully updated into DB", true,
	 * categoryDAO.update(category));
	 * 
	 * }
	 * 
	 * @Test public void testdeleteCategory() { Category category =
	 * categoryDAO.get(3); category.setActive(false);
	 * assertEquals("successfully deleted from  DB", true,
	 * categoryDAO.delete(category));
	 * 
	 * }
	 */

}
