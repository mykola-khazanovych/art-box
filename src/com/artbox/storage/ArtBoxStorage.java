package com.artbox.storage;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.artbox.model.ArtBox;

public class ArtBoxStorage {

	private static volatile ArtBoxStorage instance;
	private static volatile int id = 1;
	private volatile Map<Integer, ArtBox> database = Collections.synchronizedMap(new HashMap<>());

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

	public boolean add(ArtBox item) {
		
		this.database.put(id, item);
		id++;
		return database.containsValue(item);
	}

	public boolean removeById(int id) {
		
		this.database.remove(id);
		return !database.containsKey(id);
	}

	public ArtBox findByTheme(String theme) {

		Collection<ArtBox> artBoxCollection = this.database.values();
		
		for(ArtBox en: artBoxCollection) {
			if (en.getTheme().equalsIgnoreCase(theme)) {
				return en;
			}
		}

		return null;
	}

	public Map<Integer, ArtBox> getAll() {

		return Collections.unmodifiableMap(this.database);
	}
}
