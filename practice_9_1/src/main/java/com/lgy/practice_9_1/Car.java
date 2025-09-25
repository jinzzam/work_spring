package com.lgy.practice_9_1;

public class Car {
	private String stock;
	private int capRank;
	private String product;
	
	public void getCarInfo() {
		System.out.println("회사 : " + getStock());
		System.out.println("시총 : " + getCapRank());
		System.out.println("제품 : " + getProduct());
	}
	
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public int getCapRank() {
		return capRank;
	}
	public void setCapRank(int capRank) {
		this.capRank = capRank;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}

	
}
