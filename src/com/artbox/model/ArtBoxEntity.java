package com.artbox.model;

public class ArtBoxEntity {

	private String theme;
	private short age;
	private float cost;

	public ArtBoxEntity() {
		super();
	}
	
	public ArtBoxEntity(String theme, short age, float cost) {
		this.theme = theme;
		this.age = age;
		this.cost = cost;
	}

	public String getTheme() {
		return theme;
	}


	public short getAge() {
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
