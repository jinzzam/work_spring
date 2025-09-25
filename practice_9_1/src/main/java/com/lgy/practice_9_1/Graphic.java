package com.lgy.practice_9_1;

public class Graphic {
	private String stock;
	private int capRank;
	
	public void getGraphicInfo() {
		System.out.println("회사 : " + getStock());
		System.out.println("시총 : " + getCapRank());
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
	
}
