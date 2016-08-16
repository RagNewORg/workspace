package com.amazon.search.tool;





public class Product {
	
	private String itemName ;
	private String itemDetails;
	private String itemManufacturer;
	private String asin;

	public String getAsin() {
		return asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(String itemDetails) {
		this.itemDetails = itemDetails;
	}
	public String getItemManufacturer() {
		return itemManufacturer;
	}
	public void setItemManufacturer(String itemManufacturer) {
		this.itemManufacturer = itemManufacturer;
	}
	

}