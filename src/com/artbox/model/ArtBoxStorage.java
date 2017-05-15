package com.artbox.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class ArtBoxStorage {
	
	private static volatile ArtBoxStorage instance;
	private static volatile short id = 1;
	private volatile Map<Short,ArtBoxEntity> database = Collections.synchronizedMap(new HashMap<>());
	
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
	
	public boolean add(ArtBoxEntity item){
		this.database.put(id, item);
		id++;
		return database.containsValue(item);
	}
	
	public boolean remove(short id){
		this.database.remove(id);
		return !database.containsKey(id);
	}
}
