package com.mn.eshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mn.eshoppingbackend.dao.CategoryDao;
import com.mn.eshoppingbackend.dto.Category;

public class CategoryTestCases {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDao categoryDao;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.mn.eshoppingbackend");
		context.refresh();

		categoryDao = (CategoryDao) context.getBean("categoryDao");

	}

	/*
	 * Here Testing static data one by one
	 */

	/*
	 * @Test public void testAddCategory() { Category category = new Category();
	 * 
	 * category.setName("Ipad"); category.setDescription("This is related to Ipad");
	 * category.setImageURL("CAT_4.png");
	 * 
	 * assertEquals("Successfully added a category inside the table.", true ,
	 * categoryDao.add(category)); }
	 */

	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDao.get(1);
	 * assertEquals("Successfully fetched a single category from the table.",
	 * "Television" , category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDao.get(1); category.setName("T.V");
	 * 
	 * assertEquals("Successfully updated a single category in the table.", true ,
	 * categoryDao.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDao.get(4);
	 * 
	 * assertEquals("Successfully deleted a single category in the table.", true ,
	 * categoryDao.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * assertEquals("Successfully fetched the list of categories from the table.", 3
	 * , categoryDao.list().size()); // here you know the size in advance(like : 3)
	 * otherwise will get Junit Error while testing }
	 */

	/*
	 * to test all CRUD operation test-case in single test-case
	 */

	@Test
	public void testCRUDCategory() {

		// adding the categories into DB
		// 1st
		category = new Category();
		category.setName("Television");
		category.setDescription("This is related to Television");
		category.setImageURL("CAT_1.png");
		assertEquals("Successfully added a category inside the table.", true, categoryDao.add(category));

		// 2nd
		category = new Category();
		category.setName("Lappy");
		category.setDescription("This is related to Laptop");
		category.setImageURL("CAT_2.png");
		assertEquals("Successfully added a category inside the table.", true, categoryDao.add(category));

		// 3rd
		category = new Category();
		category.setName("Mobile");
		category.setDescription("This is related to Mobile");
		category.setImageURL("CAT_3.png");
		assertEquals("Successfully added a category inside the table.", true, categoryDao.add(category));

		// 4th
		category = new Category();
		category.setName("Ipad");
		category.setDescription("This is related to Ipad");
		category.setImageURL("CAT_4.png");
		assertEquals("Successfully added a category inside the table.", true, categoryDao.add(category));

		// 5th
		category = new Category();
		category.setName("Watch");
		category.setDescription("This is related to Watch");
		category.setImageURL("CAT_4.png");
		assertEquals("Successfully added a category inside the table.", true, categoryDao.add(category));

		// fetching and updating a category
		category = categoryDao.get(2);
		category.setName("Laptop");

		assertEquals("Successfully updated a single category in the table.", true, categoryDao.update(category));

		// deleting/disabling a category
		category = categoryDao.get(5);

		assertEquals("Successfully deleted a single category in the table.", true, categoryDao.delete(category));
	
		// fetching the list of categories
		assertEquals("Successfully fetched the list of categories from the table.", 4
		, categoryDao.list().size());
	}

}