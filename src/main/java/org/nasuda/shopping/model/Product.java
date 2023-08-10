package org.nasuda.shopping.model;

import java.io.Serializable;

public class Product implements Serializable {
    
	private Integer itemId;
	private String name;
	private Integer price;

	public Product() {
	} 
    
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String toString(){
		StringBuilder result = new StringBuilder();
		result.append("Product: ");
		result.append(this.itemId + ", ");
		result.append(this.name + ", ");
		result.append(this.price);
		return result.toString();
	}


}
