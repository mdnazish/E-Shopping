package com.mn.eshopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mn.eshopping.model.UserModel;
import com.mn.eshoppingbackend.dao.UserDao;
import com.mn.eshoppingbackend.dto.User;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;

	@Autowired
	private UserDao userDao;

	private UserModel userModel = null;

	@ModelAttribute("userModel")
	public UserModel getUserModel() {

		if (session.getAttribute("userModel") == null) {

			// add the user model
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = userDao.getUserByEmail(authentication.getName());

			if (user != null) {

				// create a new UserModel to pass the user details
				userModel = new UserModel();
				userModel.setId(user.getId());
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());

				if (userModel.getRole().equals("USER")) {

					// set the cart only if user is a buyer.
					userModel.setCart(user.getCart());
				}
				// set the userModel in the session.
				session.setAttribute("userModel", userModel);
				return userModel;
			}
		}

		return (UserModel) session.getAttribute("userModel");
	}
}
