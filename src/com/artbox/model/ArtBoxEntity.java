package com.artbox.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class ArtBoxEntity {
	
private String theme;
private short age;
private float cost;

@Override
public String toString(){
	return "ArtBox: theme \"" + theme + " recommended age: " + age + " cost (w/o delivery) is " + cost;
}
}
