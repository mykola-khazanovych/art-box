package com.artbox.storage;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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

		Collection<ArtBox> ArtBoxCollection = this.database.values();
		Iterator<ArtBox> iter = ArtBoxCollection.iterator();

		while (iter.hasNext()) {
			ArtBox en = (ArtBox) iter.next();
			if (en.getTheme().equalsIgnoreCase(theme)) {
				return en;
			}
		}

		return null;
	}

	public Set<Map.Entry<Integer, ArtBox>> getDatabase() {

		return Collections.unmodifiableSet(this.database.entrySet());
	}
}
