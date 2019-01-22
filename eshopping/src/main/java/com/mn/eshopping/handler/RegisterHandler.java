package com.mn.eshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.mn.eshopping.model.Register;
import com.mn.eshoppingbackend.dao.UserDao;
import com.mn.eshoppingbackend.dto.Address;
import com.mn.eshoppingbackend.dto.Cart;
import com.mn.eshoppingbackend.dto.User;

@Component
public class RegisterHandler {

	@Autowired
	UserDao userDao;

	public Register init() {
		return new Register();
	}

	public void addUser(Register register, User user) {
		register.setUser(user);
	}

	public void addBillingAddress(Register register, Address billingAddress) {
		register.setBillingAddress(billingAddress);
	}

	// to validate personal detail for signup
	public String validateUser(User user, MessageContext error) {
		String transitionValue = "success";
		// checking if password matches confirmPassword
		if (!(user.getPassword().equals(user.getConfirmPassword()))) {

			// it will build the message for the "confirmPassword" field
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("Password Does Not Matched.!")
					.build());
			transitionValue = "failure";
		}

		// checking the uniqueness of the email-id
		if (userDao.getUserByEmail(user.getEmail()) != null) {

			// it will build the message for the "confirmPassword" field
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("Email is already register.!")
					.build());
			transitionValue = "failure";
		}
		return transitionValue;
	}

	public String saveAll(Register register) {
		String transitionValue = "success";

		// fetch the user
		User user = register.getUser();
		if (user.getRole().equals("USER")) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		// save the user
		userDao.addUser(user);

		// fetch the address
		Address billingAddress = register.getBillingAddress();

		billingAddress.setUser(user);
		billingAddress.setBilling(true);

		// save the address
		userDao.addAddress(billingAddress);

		return transitionValue;
	}
}
