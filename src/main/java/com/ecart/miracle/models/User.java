package com.ecart.miracle.models;




import javax.persistence.*;
@Entity
public class User {
	

	@GeneratedValue (strategy =  GenerationType.AUTO )
	private int id;

	private String firstname;
	
	private String lastname;

	private String gender;
	@Id
	private Long mobile;

	private String email;

	private String adress;

	private String password;
	
	private String userid;
	
	private String role;
	
	private String cart;
	 
	private String wishlist;
	
	private String updated_quantity;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) { 
		this.gender = gender;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(long i) {
		this.mobile = i;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCart() {
		return cart;
	}

	public void setCart(String cart) {
		this.cart = cart;
	}

	public String getWishlist() {
		return wishlist;
	}

	public void setWishlist(String wishlist) {
		this.wishlist = wishlist;
	}

	public String getUpdtaed_quantity() {
		return updated_quantity;
	}

	public void setUpdtaed_quantity(String updtaed_quantity) {
		this.updated_quantity = updtaed_quantity;
	}

	public User(int id, String firstname, String lastname, String gender, Long mobile, String email, String adress,
			String password, String userid, String role, String cart, String wishlist, String updated_quantity) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.adress = adress;
		this.password = password;
		this.userid = userid;
		this.role = role;
		this.cart = cart;
		this.wishlist = wishlist;
		this.updated_quantity = updated_quantity;
	}

	public User() {
		super();
	}

	

	
	

	
}
