package com.lgy.project_6_4;

import java.util.ArrayList;

public class Animation {
	private String title;
	private int madeIn;
	private ArrayList<String> member;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMadeIn() {
		return madeIn;
	}
	public void setMadeIn(int madeIn) {
		this.madeIn = madeIn;
	}
	public ArrayList<String> getMember() {
		return member;
	}
	public void setMember(ArrayList<String> member) {
		this.member = member;
	}
	public Animation(String title) {
		this.title = title;
	}
	
	
}
