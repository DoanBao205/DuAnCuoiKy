package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class QLBN {
	public Connection getConnection() throws SQLException {
		String URL = "jdbc:mySQL://localhost:3306/management";
		Connection con = DriverManager.getConnection(URL, "root", "");
		return con;
	}
}
