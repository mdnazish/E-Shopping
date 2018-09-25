package com.mn.eshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ConnectException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	/*
	 * For 404 Error for our Website
	 * @see error.jsp
	 */
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "The page is not constructed!");
		
		mv.addObject("errorDescription", "The page you are looking for is not available now!");
		
		mv.addObject("title", "404 Error Page");
		
		return mv;
	}
	
	/*
	 * Custom Exception for Product not available using id
	 * @see ProductNotFoundException
	 * @see PageController.showSingleProduct(int id)
	 * @see error.jsp
	 */
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Product is not available.!");
		
		mv.addObject("errorDescription", "The Product you are looking for is not available right now!");
		
		mv.addObject("title", "Product Unavailable");
		
		return mv;
	}
	

	/*
	 * Generalised Exception that would be displayed instead of 
	 * 500 Server Error
	 */
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception exception) {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Contact Your Administrator.!");
		
		/*
		 * Only for debugging your application
		 */
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		exception.printStackTrace(pw);
		mv.addObject("errorDescription", sw.toString());
		//---------------------------------------------
		
		/*mv.addObject("errorDescription", exception.toString());*/
		
		mv.addObject("title", "Error");
		
		return mv;
	}
}