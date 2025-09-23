package com.lgy.spring_test;

public class MyCapital {
	private Capital capital;
	private String str;
	
	public void alpha() {
		capital.alphabet(str);
	}

	public Capital getCapital() {
		return capital;
	}

	public void setCapital(Capital capital) {
		this.capital = capital;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
