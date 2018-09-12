package com.mn.eshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	/*
	 * Simple Request Mapping Ex- http://localhost:7575/eshopping/
	 * http://localhost:7575/eshopping/home http://localhost:7575/eshopping/index
	 */
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "<h2>Welcome To E-Shopping<h2>");
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
