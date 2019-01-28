package com.mn.eshopping.service;

import java.util.List;

import com.mn.eshoppingbackend.dto.Cart;
import com.mn.eshoppingbackend.dto.CartLine;

public interface CartService {

	// returns the cart of the user who is logged in.
	public Cart getCart();

	// returns the entire cart lines
	public List<CartLine> getCartLines();

	// to update cartline for the current user
	public String manageCartLine(int cartLineId, int count);

	// to delete cartline for the current user
	public String deleteCartLine(int cartLineId);

	// to add new product into cartline
	public String addCartLine(int productId);

}
