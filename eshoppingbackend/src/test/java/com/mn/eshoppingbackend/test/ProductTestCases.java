package com.mn.eshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mn.eshoppingbackend.dao.ProductDao;
import com.mn.eshoppingbackend.dto.Category;
import com.mn.eshoppingbackend.dto.Product;

public class ProductTestCases {

	private static AnnotationConfigApplicationContext context;

	private static ProductDao productDao;

	private Product product;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.mn.eshoppingbackend");
		context.refresh();

		productDao = (ProductDao) context.getBean("productDao");

	}

	/*
	 * @Test public void testCRUDCategory() {
	 * 
	 * product = new Product(); // adding the categories into DB // 1st
	 * product.setName("Oppo Selfie S5 Pro"); product.setBrand("Oppo");
	 * product.setDescription("This is related to Oppo Mobile Phone");
	 * product.setUnitPrice(25000); product.setActive(true);
	 * product.setCategoryId(3); product.setSupplierId(3);
	 * 
	 * assertEquals("Something went wrong while inserting a new product!", true,
	 * productDao.add(product));
	 * 
	 * // fetching and updating a category product = productDao.get(2);
	 * product.setName("Samsung Galaxy S7");
	 * 
	 * assertEquals("Something went wrong while updating the existing product!",
	 * true, productDao.update(product));
	 * 
	 * // deleting/disabling a category product = productDao.get(4);
	 * 
	 * assertEquals("Something went wrong while deleting a new product!", true,
	 * productDao.delete(product));
	 * 
	 * // fetching the list of categories
	 * assertEquals("Something went wrong while fetching the list of products!", 6 ,
	 * productDao.list().size()); }
	 */

	/*@Test
	public void testListOfActiveProducts() {

		assertEquals("Something went wrong while fetching the list of active products!", 5 , productDao.listActiveProducts().size());
	}*/
	
	/*@Test
	public void testListOfActiveProductsByCategory() {

		assertEquals("Something went wrong while fetching the list of active products by category!", 4 , productDao.listActiveProductsByCategory(3).size());
		
		assertEquals("Something went wrong while fetching the list of active products by category!", 1 , productDao.listActiveProductsByCategory(1).size());
	}*/
	
	@Test
	public void testListestActiveProducts() {

		assertEquals("Something went wrong while fetching the latest list of active products!", 5 , productDao.getLatestActiveProducts(6).size());
	
	}
	
	
}
