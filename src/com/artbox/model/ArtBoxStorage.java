package com.artbox.model;

import java.util.ArrayList;
import java.util.List;

public class ArtBoxStorage {
	private static volatile ArtBoxStorage instance;
	private List<ArtBoxEntity> artBoxStorage = new ArrayList<>();

	private ArtBoxStorage() {
	};

	public static ArtBoxStorage getInstance() {
		if (instance == null) {
			synchronized (ArtBoxStorage.class) {
				if (instance == null) {
					instance = new ArtBoxStorage();
					return instance;
				}
			}
		}
		return instance;
	}
	
	public Boolean add(ArtBoxEntity item){
		this.artBoxStorage.add(item);
		return true;
	}
}
