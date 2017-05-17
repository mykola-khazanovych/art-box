package com.artbox.model;

public class ArtBox {

	private String theme;
	private int age;
	private float cost;

	public ArtBox() {
		super();
	}
	
	public ArtBox(String theme, int age, float cost) {
		this.theme = theme;
		this.age = age;
		this.cost = cost;
	}

	public String getTheme() {
		return theme;
	}


	public int getAge() {
		return age;
	}


	public float getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return "ArtBox: theme \"" + theme + "\" recommended age: " + age + " cost (w/o delivery) is " + cost;
	}
}
