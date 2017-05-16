package com.artbox.storage;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

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

	public void printDatabase(HttpServletResponse response) {

		Set<Map.Entry<Short, ArtBoxEntity>> ArtBoxCollection = this.database.entrySet();
		Iterator<Map.Entry<Short, ArtBoxEntity>> iter = ArtBoxCollection.iterator();

		if (ArtBoxCollection.isEmpty()) {
			try {
				response.getWriter().append("Sorry! Database is empty!");
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		while (iter.hasNext()) {
			Map.Entry<Short, ArtBoxEntity> en = (Map.Entry<Short, ArtBoxEntity>) iter.next();
			try {
				response.getWriter().append("id = " + en.getKey() + " ").append(en.getValue().toString())
						.append("</p>");
				response.flushBuffer();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
