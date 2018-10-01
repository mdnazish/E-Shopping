package com.mn.eshoppingbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	/*
	 * private fields as per DB columns
	 * @Id is recommended for @Entity annotation
	 * @GeneratedValue is used to auto generate unique ID
	 * @Column is used to map fields with DB column (Note : Optional, if column name and field name are same) 
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String code;
	
	@NotBlank(message="Please Enter Product Name!")
	private String name;
	
	@NotBlank(message="Please Enter Brand Name!")
	private String brand;
	/*
	 * @JsonIgnore -
	 * Now we will add @JsonIgnore to ignore the fields that we don't want to sent in the form of JSON.
 	 */
	
	@JsonIgnore 
	@NotBlank(message="Please Enter Description For Product!")
	private String description;
	
	@Column(name = "unit_price")
	@Min(value=1, message="The Price Can't be Less than 1 !")
	private double unitPrice;
	
	private int quantity;
	
	@JsonIgnore // doesn't convert this field into JSON Format at the time of Testing GET Or POST request using Postman etc...
	@Column(name = "is_active")
	private boolean active;
	
	@JsonIgnore
	@Column(name = "category_id")
	private int categoryId;
	
	@JsonIgnore
	@Column(name = "supplier_id")
	private int supplierId;
	
	private int purchases;
	private int views;
	
	/*
	 * To insert an image we have to use a transient field for uploading a file,
	 * It would be transient as we don't have to persist into DB but as a file.
	 * 
	 */
	@Transient
	private MultipartFile file;
	
	/*
	 * no-args / minimal / default constructor 
	 * To generate a unique random number
	 */
	public Product() {
		
		this.code = "PRD"+UUID.randomUUID().toString().substring(26).toUpperCase();
		
	}
	
	// getters and setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getPurchases() {
		return purchases;
	}
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	// toSting() method to achieve meaningful result
	@Override
	public String toString() {
		return "Products [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", active=" + active
				+ ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", purchases=" + purchases + ", views="
				+ views + "]";
	}
	
	
	
}
