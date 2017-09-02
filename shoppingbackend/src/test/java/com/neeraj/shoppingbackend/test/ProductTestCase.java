package com.neeraj.shoppingbackend.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neeraj.shoppingbackend.dao.ProductDAO;
import com.neeraj.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext cxt;
	private static ProductDAO productDAO;

	@BeforeClass
	public static void init() {

		cxt = new AnnotationConfigApplicationContext();
		cxt.scan("com.neeraj.shoppingBackend");
		cxt.refresh();
		productDAO = (ProductDAO) cxt.getBean("productDAO");

	}
	
	@Test
	public void listActiveProductsByCategory(){
		List<Product> li=productDAO.listActiveProductsByCategory(1);
		//System.out.println(product.toString());
		assertEquals("some issue in getting the product list",2,li.size());
	}

}
