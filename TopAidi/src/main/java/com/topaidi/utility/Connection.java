package com.topaidi.utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
	private static Connection instance = null;

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("topaidi");
	
	private Connection() {}

	public static Connection getInstance() {
		if (instance == null) {
			instance = new Connection();
		}

		return instance;
	}
	
	public static void stop() {
		Connection inst = getInstance();
		inst.getEmf().close();
		instance = null;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}
}
