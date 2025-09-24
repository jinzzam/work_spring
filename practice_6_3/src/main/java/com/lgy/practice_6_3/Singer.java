package com.lgy.practice_6_3;

import java.util.ArrayList;

public class Singer {
	private String name;
	private int num;
	private ArrayList<String> song;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public ArrayList<String> getSong() {
		return song;
	}
	public void setSong(ArrayList<String> song) {
		this.song = song;
	}
	public Singer(String name) {
		this.name = name;
	}
}
