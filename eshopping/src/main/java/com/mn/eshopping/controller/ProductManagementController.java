package com.mn.eshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mn.eshopping.util.FileUploadUtility;
import com.mn.eshopping.validator.ProductValidator;
import com.mn.eshoppingbackend.dao.CategoryDao;
import com.mn.eshoppingbackend.dao.ProductDao;
import com.mn.eshoppingbackend.dto.Category;
import com.mn.eshoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ProductManagementController {

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ProductDao productDao;

	private static final Logger logger = LoggerFactory.getLogger(ProductManagementController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Product Management");

		Product newProduct = new Product();

		// set few of the fields
		newProduct.setSupplierId(1);
		newProduct.setActive(true);

		mv.addObject("product", newProduct);

		if (operation != null) {
			if (operation.equals("product")) {

				mv.addObject("message", "Product Submission Successfully!");
			}
		}
		return mv;
	}

	/*
	 * Handling product submission BindingResult must be before Model object
	 */
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product newProduct, BindingResult results,
			Model model, HttpServletRequest request) {

		//to check a file is an image or not
		new ProductValidator().validate(newProduct, results);
		
		// check if there are any errors
		if (results.hasErrors()) {

			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Product Management");
			model.addAttribute("message", "Validation Failed For Product Submission!");

			return "page";
		}
		
		logger.info(newProduct.toString());

		// create a new product record
		productDao.add(newProduct);

		if (!newProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, newProduct.getFile(), newProduct.getCode());
		}
		return "redirect:/manage/products?operation=product";
	}

	// returning categories for all the request mapping with "manageProducts.jsp"
	@ModelAttribute("categories")
	public List<Category> getCategories() {

		return categoryDao.list();
	}

}
