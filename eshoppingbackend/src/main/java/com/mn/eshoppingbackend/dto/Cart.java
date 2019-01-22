package com.mn.eshoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Md Nazish
 *
 */
@Entity
public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * private fields
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/*
	 * @Column(name="user_id") 
	 * private int userId;
	 */

	// -------- Using Hibernate OneToOne Uni-Directional Mapping with user

	@OneToOne
	private User user;

	// getter and setter for mapping
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	// ---------------------------------------------

	@Column(name = "grand_total")
	private double grandTotal;

	@Column(name = "cart_lines")
	private int cartLines;

	/*
	 * setters & getters method for the fields
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public int getUserId() { return userId; }
	 * 
	 * public void setUserId(int userId) { this.userId = userId; }
	 */
	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getCartLines() {
		return cartLines;
	}

	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cart [id=" + id + ", userId=" + user.getId() + ", grandTotal=" + grandTotal + ", cartLines=" + cartLines
				+ "]";
	}

}
