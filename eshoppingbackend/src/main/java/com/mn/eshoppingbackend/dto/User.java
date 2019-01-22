package com.mn.eshoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

/**
 * @author Md Nazish
 *
 */
@Entity
@Table(name = "user_detail")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * private fields for User
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	@NotBlank(message="Please enter your first name.!")
	private String firstName;

	@Column(name = "last_name")
	@NotBlank(message="Please enter your last name.!")
	private String lastName;

	@Column(name = "contact_number")
	@NotBlank(message="Please enter your contact number.!")
	private String contactNumber;

	@NotBlank(message="Please enter your email address.!")
	private String email;
	
	@NotBlank(message="Please enter your password.!")
	private String password;
	
	private String role;
	private boolean enabled = true;
	
	//To confirm password transient field
	@Transient
	@NotBlank(message="Please enter your password again.!")
	private String confirmPassword;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	//--------------------------------------------

	/*
	 * Use Hibernate OneToOne Bi-Directional Mapping with cart. mappedBy - To avoid
	 * "cart_id" coulumn as null in user_detail table & "user_detail" will become
	 * owner/parent of this relationship. cascade - To avoid writting addCart(-)
	 * method in UserDao.java -> As soon as we store a user record, the cart record
	 * should also be stored simultaneously.
	 */
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Cart cart;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	// ---------------------------------------

	/*
	 * setter & getter methods for the fields
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/*
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNumber="
				+ contactNumber + ", email=" + email + ", role=" + role + ", password=" + password + ", enabled="
				+ enabled + "]";
	}

}
