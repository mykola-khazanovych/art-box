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


	public void setTheme(String theme) {
		this.theme = theme;
	}


	public void setAge(short age) {
		this.age = age;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + Float.floatToIntBits(cost);
		result = prime * result + ((theme == null) ? 0 : theme.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtBoxEntity other = (ArtBoxEntity) obj;
		if (age != other.age)
			return false;
		if (Float.floatToIntBits(cost) != Float.floatToIntBits(other.cost))
			return false;
		if (theme == null) {
			if (other.theme != null)
				return false;
		} else if (!theme.equals(other.theme))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArtBox: theme \"" + theme + "\" recommended age: " + age + " cost (w/o delivery) is " + cost;
	}
}
