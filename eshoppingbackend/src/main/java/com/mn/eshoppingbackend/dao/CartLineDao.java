package com.mn.eshoppingbackend.dao;

import java.util.List;

import com.mn.eshoppingbackend.dto.Cart;
import com.mn.eshoppingbackend.dto.CartLine;

public interface CartLineDao {

	// Basic CRUD methods

	public CartLine get(int id);

	public boolean add(CartLine cartLine);

	public boolean update(CartLine cartLine);

	public boolean delete(CartLine cartLine);

	public List<CartLine> list(int cartId);

	// Business methods related to the cart lines
	public List<CartLine> listAvailable(int cartId);

	public CartLine getByCartAndProduct(int cartId, int productId);

	// update a cart for the user
	boolean updateCart(Cart cart);
}
