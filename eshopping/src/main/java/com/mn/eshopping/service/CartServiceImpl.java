package com.mn.eshopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mn.eshopping.model.UserModel;
import com.mn.eshoppingbackend.dao.CartLineDao;
import com.mn.eshoppingbackend.dao.ProductDao;
import com.mn.eshoppingbackend.dto.Cart;
import com.mn.eshoppingbackend.dto.CartLine;
import com.mn.eshoppingbackend.dto.Product;

@Service("cartService")
public class CartServiceImpl implements CartService {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private CartLineDao cartLineDao;
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Cart getCart() {

		// returns the cart of the user who is logged in.
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}

	@Override
	public List<CartLine> getCartLines() {

		// returns the entire cart lines
		return cartLineDao.list(this.getCart().getId());
	}

	@Override
	public String manageCartLine(int cartLineId, int count) {

		// fetch the cart line
		CartLine cartLine = cartLineDao.get(cartLineId);
		if (cartLine == null) {
			// send response to client
			return "result=error";
		} else {
			// fetch the product
			Product product = cartLine.getProduct();
			double oldTotal = cartLine.getTotal();

			// before update checking the cartline with how many products
			if (product.getQuantity() < count) {
				//count = product.getQuantity();
				
				// if reached the product count limit or that much not available in DB
				return "result=unavailable";
			}
			// update cartline
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice() * count);

			cartLineDao.update(cartLine);

			// fetch the cart from current session
			Cart cart = this.getCart();

			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			cartLineDao.updateCart(cart);

			// send response to client
			return "result=updated";
		}

	}

	@Override
	public String deleteCartLine(int cartLineId) {

		// fetch the cartline
		CartLine cartLine = cartLineDao.get(cartLineId);

		if (cartLine == null) {
			// send response to client
			return "result=error";
		} else {
			// fetch the cart from current session
			Cart cart = this.getCart();
			// updating grand total is 0
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			// updating cartline is 0
			cart.setCartLines(cart.getCartLines() - 1);
			cartLineDao.updateCart(cart);

			// remove the cart
			cartLineDao.delete(cartLine);

			// send response to client
			return "result=deleted";
		}
	}

	@Override
	public String addCartLine(int productId) {
		String response = null;
		
		//fetch cart from current session
		Cart cart = this.getCart();
		
		//checking same product is available in the cartline or not
		CartLine cartLine = cartLineDao.getByCartAndProduct(cart.getId(), productId);
		if(cartLine == null) {
			//add new cartLine
			cartLine = new CartLine();
			
			// fetch the product
			Product product = productDao.get(productId);
			
			// set values to the cartline 
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setAvailable(true);
			
			//add a cartLine to the user
			cartLineDao.add(cartLine);
			
			//update the cart to current user with this added cartline
			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			
			cartLineDao.updateCart(cart);
			
			response = "result=added";
		}
		else {
			// check if the cartline has reached the maximum count
			if(cartLine.getProductCount() < 5) {
				//update the productCount for the cartLine
				response = this.manageCartLine(cartLine.getId(), cartLine.getProductCount() + 1);
			}
			else {
				response ="result=maximum";
			}
		}
		
		return response;
	}

}
