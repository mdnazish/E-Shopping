package com.mn.eshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mn.eshoppingbackend.dao.UserDao;
import com.mn.eshoppingbackend.dto.Address;
import com.mn.eshoppingbackend.dto.Cart;
import com.mn.eshoppingbackend.dto.User;

/**
 * @author Md Nazish
 *
 */
public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDao userDao;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mn.eshoppingbackend");
		context.refresh();
		
		userDao = (UserDao) context.getBean("userDao");
	}
	
	// Testing add functions for user,address and cart by using Hibernate Uni-directional & Bi-directional relationship with "user and cart" table
	
	/*@Test
	public void testAddFunctions() {
		
		//creating a new user
		user = new User();
		user.setFirstName("Zaqaullah");
		user.setLastName("Nawab");
		user.setEmail("zaqi@gmail.com");
		user.setContactNumber("9786543210");
		user.setRole("USER");
		user.setPassword("zaqi123");
		
		//adding an user to DB here
		assertEquals("Failed to add user!", true, userDao.addUser(user));
		
		//creating an address for user
		address = new Address();
		address.setAddressLine1("1-11-50/9 Begumpet Railway Station");
		address.setAddressLine2("Near Mohammadia Masjid");
		address.setCity("Hyderabad");
		address.setState("Telangana");
		address.setCountry("India");
		address.setPostalCode(500016);
		address.setBilling(true);
		
		//linking the address with user by using userId
		address.setUserId(user.getId());
		
		//adding an address to DB here
		assertEquals("Failed to add address!", true, userDao.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			
			//creating a cart for this user
			cart = new Cart();
			//cart.setUserId(user.getId());
			
			cart.setUser(user); // Using OneToOne Mapping in Cart.java
			
			//adding a cart to DB here
			assertEquals("Failed to add cart!", true, userDao.addCart(cart));
			
			//adding shipping address for this user
			address = new Address();
			address.setAddressLine1("102/BK Ansari Colony");
			address.setAddressLine2("Near Masjid");
			address.setCity("Ansansol");
			address.setState("Kolkata");
			address.setCountry("India");
			address.setPostalCode(430021);
			//set shipping to true
			address.setShipping(true);
			
			//link it with this user
			address.setUserId(user.getId());
			
			//adding the shipping address
			assertEquals("Failed to add shopping address!", true, userDao.addAddress(address));
		}
	}*/
	
	/*To avoid writting addCart(-) method in UserDao.java
	 * -> As soon as we store a user record, the cart record should also be stored simultaneously
	 */
	
	/*@Test
	public void testAddFunctions() {
		
		//creating a new user
		user = new User();
		user.setFirstName("Zaqaullah");
		user.setLastName("Nawab");
		user.setEmail("zaqi@gmail.com");
		user.setContactNumber("9786543210");
		user.setRole("USER");
		user.setPassword("zaqi123");
		
		if(user.getRole().equals("USER")) {
			
			//creating a cart for this user
			cart = new Cart();
			//cart.setUserId(user.getId());
			
			cart.setUser(user); // Using OneToOne Mapping in Cart.java
			
			//adding a cart to DB here
			//assertEquals("Failed to add cart!", true, userDao.addCart(cart));
			
			//attaching cart with this user
			user.setCart(cart);	
		}
		//adding an user to DB here
		assertEquals("Failed to add user!", true, userDao.addUser(user));
				
	}*/
	
	/*@Test
	public void testUpdateCart() {
		//fetching the user by its email
		user = userDao.getUserByEmail("atta.khan@gmail.com");
		if(user != null) {
		//getting the cart of the user
		cart = user.getCart();
		
		cart.setGrandTotal(54637);
		cart.setCartLines(2);
		}
		//updating the cart for this/specific user 
		assertEquals("Failed to update the cart", true, userDao.updateCart(cart));
	}*/
	
	/*@Test
	public void testAddAddress() {
		// I need to add an user
		//creating a new user
		user = new User();
		user.setFirstName("Ataullah");
		user.setLastName("Khan");
		user.setEmail("atta.khan@gmail.com");
		user.setContactNumber("8796543210");
		user.setRole("USER");
		user.setPassword("khan123");
		
		//adding an user to DB here
		assertEquals("Failed to add user!", true, userDao.addUser(user));
		
		// I am going to add the address
		//creating an address for this user
		address = new Address();
		address.setAddressLine1("1-11-50/9 Begumpet Railway Station");
		address.setAddressLine2("Near Mohammadia Masjid");
		address.setCity("Hyderabad");
		address.setState("Telangana");
		address.setCountry("India");
		address.setPostalCode(500016);
		address.setBilling(true);
		
		//attaching the user to the address
		address.setUser(user);
		//adding address to this user
		assertEquals("Failed to add address!", true, userDao.addAddress(address));
		
		// I am also going to add the shipping address
		//creating shipping address for this user
		address = new Address();
		address.setAddressLine1("105/BK Ansari Colony");
		address.setAddressLine2("Near Masjid");
		address.setCity("Ansansol");
		address.setState("Kolkata");
		address.setCountry("India");
		address.setPostalCode(430021);
		//set shipping to true
		address.setShipping(true);
		
		//attaching the user to the shipping address
		address.setUser(user);
		
		//adding the shipping address
		assertEquals("Failed to add shopping address!", true, userDao.addAddress(address));
	}*/
	
	/*@Test
	public void testAddNewShippingAddress() {
	
		//fetch the user for add new address
		user = userDao.getUserByEmail("atta.khan@gmail.com");
		if(user != null) {
		
		//creating new shipping address for this user
		address = new Address();
		address.setAddressLine1("1-11-50/9 Begumpet Railway Station");
		address.setAddressLine2("Near Mohammadia Masjid, Old Custum Basti");
		address.setCity("Hyderabad");
		address.setState("Telanga");
		address.setCountry("India");
		address.setPostalCode(500016);
		//set shipping to true
		address.setShipping(true);
		
		//attaching the user to the shipping address
		address.setUser(user);
		}
		//adding the new shipping address
		assertEquals("Failed to add new shopping address!", true, userDao.addAddress(address));
	}*/
	
	/*@Test
	public void testGetAddress() {
		
		//fetch the user
		user = userDao.getUserByEmail("atta.khan@gmail.com");
		if(user != null) {
		
			//fetch all the shipping addresses associated with this user
			assertEquals("Failed to fetch the billing address and Size doesn't match.!", "Hyderabad", userDao.getBillingAddress(user).getCity());
			
			//fetch all the shipping addresses associated with this user
			assertEquals("Failed to fetch list of all the shipping address and Size doesn't match.!", 2, userDao.getShippingAddresses(user).size());
		}
		else {
			System.out.println("User is not exist with this email.");
		}
			
	}*/
}
