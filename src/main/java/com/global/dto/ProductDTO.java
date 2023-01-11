package com.global.dto;

import lombok.Data;


public class ProductDTO {
	
	private Long id;
	private String name;
	private double price;
	private double weight;
	private String description;
	private int categoryId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", price=" + price + ", weight=" + weight + ", description="
				+ description + ", categoryId=" + categoryId + "]";
	}
	public ProductDTO(Long id, String name, double price, double weight, String description, int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.description = description;
		this.categoryId = categoryId;
	}
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	

}
