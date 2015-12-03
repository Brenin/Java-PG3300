// Created by Eirikur Lundin

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB implements AutoCloseable {

	Connection con;

	public ConnectToDB(String user, String password) throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
				+ "test", user, password);
	}

	public void close() throws SQLException {
		con.close();
	}

	public Connection getConnection() {
		return con;
	}
}
