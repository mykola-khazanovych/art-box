package com.artbox.model;

import com.artbox.builder.ArtBoxBuilder;

public class ArtBox {

	private String theme;
	private int age;
	private float cost;

	public ArtBox(ArtBoxBuilder builder) {
		this.theme = builder.getTheme();
		this.age = builder.getAge();
		this.cost = builder.getCost();
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
