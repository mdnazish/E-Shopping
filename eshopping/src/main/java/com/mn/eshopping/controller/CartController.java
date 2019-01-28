package com.mn.eshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mn.eshopping.service.CartService;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/show")
	public ModelAndView showCart(@RequestParam(name = "result", required = false) String result) {

		ModelAndView mv = new ModelAndView("page");

		// handling the response by CartService
		if (result != null) {
			switch (result) {

			case "updated":
				mv.addObject("message", "CartLine has been updated successfully!");
				break;
			case "deleted":
				mv.addObject("message", "CartLine has been removed successfully!");
				break;
			case "added":
				mv.addObject("message", "CartLine has been added successfully!");
				break;
			case "maximum":
				mv.addObject("message", "Your CartLine has reached to add maximum Quantity!");
				break;
			case "unavailable":
				mv.addObject("message", "Sorry, No more Product Quantity is available for this product!");
				break;
			case "error":
				mv.addObject("message", "Something Went Wrong!");
				break;
			}
		}

		mv.addObject("title", "Cart Details");
		mv.addObject("userClickShowCart", true);
		mv.addObject("cartLines", cartService.getCartLines());

		return mv;
	}

	@RequestMapping(value = "/{cartLineId}/update")
	public String updateCart(@PathVariable int cartLineId, @RequestParam int count) {

		String response = cartService.manageCartLine(cartLineId, count);

		return "redirect:/cart/show?" + response;
	}

	@RequestMapping(value = "/{cartLineId}/delete")
	public String deleteCart(@PathVariable int cartLineId) {

		String response = cartService.deleteCartLine(cartLineId);

		return "redirect:/cart/show?" + response;
	}
	
	@RequestMapping(value = "/add/{productId}/product")
	public String addCart(@PathVariable int productId) {

		String response = cartService.addCartLine(productId);

		return "redirect:/cart/show?" + response;
	}
}
