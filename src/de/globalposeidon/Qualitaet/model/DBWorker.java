package de.globalposeidon.Qualitaet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWorker {

	Connection connection = null;
	Statement statement;
	final String database;
	
	
	// Constructor generates necessary strucutures in given database
	public DBWorker(String database) {
		this.database = database;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + database
					+ ".db");
			statement = connection.createStatement();
			statement.setQueryTimeout(5);

			createStructures();
			
/*			ResultSet rs = statement.executeQuery("select * from person");
			while (rs.next()) {
				// read the result set
				System.out.println("name = " + rs.getString("name"));
				System.out.println("id = " + rs.getInt("id"));
			} */
			finalize();
		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			e.printStackTrace();
			System.err.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// if ClassNotFound occurs, the library is not included
			// in the classpath
			System.err.println(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void finalize() throws Exception {
		if (connection != null)
			connection.close();
		System.out.println("\nCreated schema in DB file "+database+".db");
	}
	
	private void createStructures() throws SQLException{
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Apartment` "
				+ "(`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
				+ "`id_entrance` INTEGER NOT NULL);");
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Building` "
				+ "(`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
				+ "`id_buildingStructure` INTEGER NOT NULL);");
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Entrance` "
				+ "(`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
				+ "`id_building` INTEGER NOT NULL);");
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Meter` "
				+ "(`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
				+ "`lastRead` TEXT,`value` INTEGER NOT NULL,`valueFirst` INTEGER,`id_meterType` INTEGER NOT NULL);");
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Person` "
				+ "(`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
				+ "`name` TEXT,`surname` TEXT,`phone` TEXT,`mail` TEXT,`id_apartment` INTEGER);");
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Reading` "
				+ "(`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
				+ "`id_meter` INTEGER NOT NULL,`date` TEXT,`value` INTEGER,`id_readingInfo` INTEGER NOT NULL,`id_meterReader` INTEGER NOT NULL);");
	}
}