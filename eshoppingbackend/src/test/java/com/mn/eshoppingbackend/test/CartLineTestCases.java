package com.mn.eshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mn.eshoppingbackend.dao.CartLineDao;
import com.mn.eshoppingbackend.dao.ProductDao;
import com.mn.eshoppingbackend.dao.UserDao;
import com.mn.eshoppingbackend.dto.Cart;
import com.mn.eshoppingbackend.dto.CartLine;
import com.mn.eshoppingbackend.dto.Product;
import com.mn.eshoppingbackend.dto.User;

public class CartLineTestCases {

	private static AnnotationConfigApplicationContext context;

	private static CartLineDao cartLineDao = null;
	private static ProductDao productDao = null;
	private static UserDao userDao = null;

	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mn.eshoppingbackend");
		context.refresh();

		productDao = (ProductDao) context.getBean("productDao");
		userDao = (UserDao) context.getBean("userDao");
		cartLineDao = (CartLineDao) context.getBean("cartLineDao");
	}

	@Test
	public void testAddNewCartLine() {

		// 1. get the user
		user = userDao.getUserByEmail("rashid@gmail.com");

		// 2. fetch the cart
		cart = user.getCart();

		// 3. get the product
		product = productDao.get(1);

		// 4. create a new cartLine
		cartLine = new CartLine();

		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);

		assertEquals("Failed to add the cartLine", true, cartLineDao.add(cartLine));

		// 5. update the cart
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);

		assertEquals("Failed to update the cart", true, cartLineDao.updateCart(cart));

	}

}
