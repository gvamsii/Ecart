package com.ecart.miracle.models;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private long id;
	
	private String name;
	
	private int price;
	
	private String brand;
	
	private String size;
	
	private int quantity;
	
	private String colour;
	
	private String description;
	
	private String image;
	
	private String seller;
	


	public Product(long id, String name, int price, String brand, String size, int quantity, String colour,
			String description, String image, String seller) {
		super();
		this.id = id;
		this.name = name; 
		this.price = price;
		this.brand = brand; 
		this.size = size;
		this.quantity = quantity;
		this.colour = colour;
		this.description = description;
		this.image = image;
		this.seller = seller;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Product() {
		super();
	} 

}
