package com.tactfactory.enchere.daogen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public final class ConnectionProvider {
	private static volatile ConnectionProvider instance;

	private ConnectionProvider() { }

	static {
		try {
			DriverManager.registerDriver(new Driver());
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public static ConnectionProvider getInstance() {
		if (instance == null) {
			synchronized (ConnectionProvider.class) {
				if (instance == null) {
					instance = new ConnectionProvider();
				}
			}
		}

		return instance;
	}

	public Connection getConnection() {
		Connection result = null;

		try {
			result = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cours_enchere", "dev", "dev");
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		return result;
	}
}
