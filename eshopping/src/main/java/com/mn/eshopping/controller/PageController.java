package com.mn.eshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mn.eshopping.exception.ProductNotFoundException;
import com.mn.eshoppingbackend.dao.CategoryDao;
import com.mn.eshoppingbackend.dao.ProductDao;
import com.mn.eshoppingbackend.dto.Category;
import com.mn.eshoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger= LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;

	/*
	 * Simple Request Mapping Ex- http://localhost:7575/eshopping/
	 * http://localhost:7575/eshopping/home http://localhost:7575/eshopping/index
	 */
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting", "<h2>Welcome To E-Shopping<h2>");
		mv.addObject("title", "Home");
		
		logger.info("Inside PageController index method: INFO");
		logger.debug("Inside PageController index method: DEBUG");
	
		//passing the list of categories
		mv.addObject("categories", categoryDao.list());
		
		mv.addObject("userClickHome", true);
		
		return mv;
	}
	
	
	
	@RequestMapping(value = "/aboutUs")
	public ModelAndView aboutUs() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		
		mv.addObject("categories", categoryDao.list());
		mv.addObject("userClickAboutUs", true);
		
		return mv;
	}
	
	@RequestMapping(value = "/contactUs")
	public ModelAndView ContactUs() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContactUs", true);
		
		return mv;
	}
	
	/*
	 * Method to load all the products based on category
	 */
	
	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Products");
	
		//passing the list of categories
		mv.addObject("categories", categoryDao.list());
		
		mv.addObject("userClickProducts", true);
		
		return mv;
	}
	
	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)  {

		ModelAndView mv = new ModelAndView("page");
		
		//categoryDao to fetch a single category
		Category category = null;
		category = categoryDao.get(id);

		mv.addObject("title", category.getName());
	
		//passing the list of categories
		mv.addObject("categories", categoryDao.list());
		
		//passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);
		
		return mv;
	}
	
	/* 
	 *  Viewing a single product when clicking icon either view or add-cart
	 */
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		
		ModelAndView mv = new ModelAndView("page");
		Product product = productDao.get(id);
		
		if(product == null) {
			throw new ProductNotFoundException();
		}
		
		// update the view cont
		product.setViews(product.getViews() + 1); 
		productDao.update(product);
		//-----------------------------
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		
		return mv;
	}
	

	/** Just for Demonstration to understand 
	 * 		@RequestParam and
	 * 		@PathVariable
	 */
	
	/*
	 * Request Mapping with @RequestParam by passing a queary param
	 * 
	 * Ex- http://localhost:7575/eshopping/test?key1=value1 & key2=value2 ...
	 * http://localhost:7575/eshopping/test?greeting=Hello World 
	 
	@RequestMapping(value = "/test")
	public ModelAndView test(@RequestParam(value = "greeting", required = false) String greeting) {

		if (greeting == null) {
			greeting = "Hello Stranger";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;

	}

	/*
	 * Request Mapping with @PathVariable to keep clean URL and make more SEO
	 * (Search Engine Optimisation ) friendly
	 * 
	 * Ex- http://localhost:7575/eshopping/test?key=value
	 * http://localhost:7575/eshopping/test?greeting=Hello World
	 
	@RequestMapping(value = "/test/{greeting}")
	public ModelAndView test2(@PathVariable(value = "greeting") String greeting) {

		if (greeting == null) {
			greeting = "Hello Stranger";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;

	}
	*/
}
