package com.vti.Candidate.Ultils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JBDCUltils {
	private Connection connection;

	public JBDCUltils() {
		
	}
	public Connection connect()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, SQLException {

		String url = "jdbc:mysql://localhost:3306/candidate?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username ="root";
		String password = "root";

		// Step 1: register the driver class with DriverManager
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: get a Database Connection
		connection = DriverManager.getConnection(url, username, password);

		return connection;
	}


	public void disconnect() throws SQLException {
		connection.close();
	}

}
