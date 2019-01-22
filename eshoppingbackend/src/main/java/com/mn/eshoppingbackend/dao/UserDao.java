package com.mn.eshoppingbackend.dao;

import java.util.List;

import com.mn.eshoppingbackend.dto.Address;
import com.mn.eshoppingbackend.dto.Cart;
import com.mn.eshoppingbackend.dto.User;

public interface UserDao {

	//add a new user
	boolean addUser(User user);
	User getUserByEmail(String email);
	
	//add an address for the user
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> getShippingAddresses(User user);
	
	/* Alternative 
	 * - If those method give performance issue because of multiple query generated by Hibernate f/w
	 * - Use below given 2 methods
	 */
	// Address getBillingAddress(int userId);
	//List<Address> getShippingAddresses(int userId);
	
	
	//add a cart for the user 
	//boolean addCart(Cart cart); - After adding "cascade = CascadeType.ALL", we can avoid this method
	
	//update a cart for the user
	boolean updateCart(Cart cart);
}