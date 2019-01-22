package com.mn.eshopping.model;

import java.io.Serializable;

import com.mn.eshoppingbackend.dto.Address;
import com.mn.eshoppingbackend.dto.User;

public class Register implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private Address billingAddress;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
}
