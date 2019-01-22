package com.mn.eshoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Md Nazish
 *
 */
@Entity
public class Address implements Serializable{
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
	
	/*@Column(name="user_id")
	private int userId;*/
	
	//------- Using Hibernate ManyToOne Uni-Directional Mapping with user
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//-------------------------------------
	@Column(name="adress_line1")
	@NotBlank(message="Please enter your address Line-1!")
	private String addressLine1;
	
	@Column(name="adress_line2")
	@NotBlank(message="Please enter your address Line-2!")
	private String addressLine2;
	
	@NotBlank(message="Please enter your city name.!")
	private String city;
	@NotBlank(message="Please enter your state name.!")
	private String state;
	@NotBlank(message="Please enter your country name.!")
	private String country;
	
	@Column(name="postal_code")
	@NotNull(message="Please enter your postal code.!")
	private Integer postalCode;
	
	@Column(name= "is_shipping")
	private boolean shipping;
	
	@Column(name= "is_billing")
	private boolean billing;
	
	/*
	 * setters and getters method for the fields
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}*/
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	public boolean isShipping() {
		return shipping;
	}
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	public boolean isBilling() {
		return billing;
	}
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	
	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [id=" + id + ", userId=" + user.getId() + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode="
				+ postalCode + ", shipping=" + shipping + ", billing=" + billing + "]";
	}
	
	
	
}
