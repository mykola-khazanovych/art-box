package com.artbox.model;

public class ArtBoxBuilder {
	
	private String theme;
	private int age;
	private float cost;
	
	public ArtBoxBuilder() {
		super();
	}
	
	public ArtBoxBuilder theme (String val) {
		this.theme = val;
		return this;
	}
	
	public ArtBoxBuilder age (int val) {
		this.age = val;
		return this;
	}
	
	public ArtBoxBuilder cost (float val) {
		this.cost = val;
		return this;
	}
	
	public ArtBox build() {
		return new ArtBox(this);
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
}
