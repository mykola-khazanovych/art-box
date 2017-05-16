package com.artbox.storage;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.artbox.model.ArtBoxEntity;

public class ArtBoxStorage {

	private static volatile ArtBoxStorage instance;
	private static volatile short id = 1;
	private volatile Map<Short, ArtBoxEntity> database = Collections.synchronizedMap(new HashMap<>());

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

	public boolean add(ArtBoxEntity item) {
		this.database.put(id, item);
		id++;
		return database.containsValue(item);
	}

	public boolean remove(short id) {
		this.database.remove(id);
		return !database.containsKey(id);
	}

	public ArtBoxEntity find(String theme) {

		Collection<ArtBoxEntity> ArtBoxCollection = this.database.values();
		Iterator<ArtBoxEntity> iter = ArtBoxCollection.iterator();

		while (iter.hasNext()) {
			ArtBoxEntity en = (ArtBoxEntity) iter.next();
			if (en.getTheme().equalsIgnoreCase(theme)) {
				return en;
			}
		}

		return null;
	}

	public Set<Map.Entry<Short, ArtBoxEntity>> getDatabase() {

		return this.database.entrySet();
	}
}
