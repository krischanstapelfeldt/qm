package de.globalposeidon.Qualitaet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWorker {

	Connection connection = null;

	// Constructor generates necessary strucutures in given database
	public DBWorker(String database) {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + database
					+ ".db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(5);

			statement
					.executeUpdate("create table if not exists person(id integer, name string)");

			statement.executeUpdate("insert into person values(1, 'leo')");
			statement.executeUpdate("insert into person values(2, 'yui')");
			ResultSet rs = statement.executeQuery("select * from person");
			while (rs.next()) {
				// read the result set
				System.out.println("name = " + rs.getString("name"));
				System.out.println("id = " + rs.getInt("id"));
			}
		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// if ClassNotFound occurs, the library is not included
			// in the classpath
			System.err.println(e.getMessage());
		}
	}

	protected void finalize() throws Exception {
		if (connection != null)
			connection.close();
		System.out.println("Connection closed");
	}

	public static void main(String[] args) throws Exception{
		// Legt eine neue Testdatenbank an mit sinnlosen Werten
		DBWorker db = new DBWorker("TEST");
		db.finalize();
	}
}