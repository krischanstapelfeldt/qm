/*
 * package de.globalposeidon.Qualitaet.model; import java.sql.Connection; import java.sql.DriverManager; import java.sql.ResultSet; import
 * java.sql.SQLException; import java.sql.Statement; public class DBWorker { private Connection connection = null; private Statement
 * statement; private final String database; // Constructor generates necessary strucutures in given database public DBWorker(final String
 * database) { this.database = database; try { Class.forName("org.sqlite.JDBC"); connection = DriverManager.getConnection("jdbc:sqlite:" +
 * database + ".db"); statement = connection.createStatement(); statement.setQueryTimeout(5); createStructures(); ResultSet rs; rs =
 * getTable(DBTable.APARTMENT); rs = getTable(DBTable.BUILDING); rs = getTable(DBTable.ENTRANCE); rs = getTable(DBTable.METER); rs =
 * getTable(DBTable.PERSON); rs = getTable(DBTable.READING); finalize(); } catch (final SQLException e) { // if the error message is
 * "out of memory", // it probably means no database file is found e.printStackTrace(); System.err.println(e.getMessage()); } catch (final
 * ClassNotFoundException e) { // if ClassNotFound occurs, the library is not included // in the classpath
 * System.err.println(e.getMessage()); } catch (final Exception e) { // TODO Auto-generated catch block e.printStackTrace(); } }
 * @Override protected final void finalize() throws Exception { if (connection != null) { connection.close(); }
 * System.out.println("\nCreated schema in DB file " + database + ".db"); } private void createStructures() throws SQLException {
 * statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Apartment` " + "(`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
 * "`id_entrance` INTEGER NOT NULL);"); statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Building` " +
 * "(`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," + "`id_buildingStructure` INTEGER NOT NULL);");
 * statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Entrance` " + "(`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
 * "`id_building` INTEGER NOT NULL);"); statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Meter` " +
 * "(`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
 * "`lastRead` TEXT,`value` INTEGER NOT NULL,`valueFirst` INTEGER,`id_meterType` INTEGER NOT NULL);");
 * statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Person` " + "(`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
 * "`name` TEXT,`surname` TEXT,`phone` TEXT,`mail` TEXT,`id_apartment` INTEGER);"); statement
 * .executeUpdate("CREATE TABLE IF NOT EXISTS `Reading` " + "(`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
 * "`id_meter` INTEGER NOT NULL,`date` TEXT,`value` INTEGER,`id_readingInfo` INTEGER NOT NULL,`id_meterReader` INTEGER NOT NULL);"); }
 * public final ResultSet getTable(final DBTable table) throws SQLException { ResultSet rs; switch (table) { case APARTMENT: rs =
 * statement.executeQuery("SELECT * FROM Apartment"); break; case BUILDING: rs = statement.executeQuery("SELECT * FROM Building"); break;
 * case ENTRANCE: rs = statement.executeQuery("SELECT * FROM Entrance"); break; case METER: rs =
 * statement.executeQuery("SELECT * FROM Meter"); break; case PERSON: rs = statement.executeQuery("SELECT * FROM Person"); break; case
 * READING: rs = statement.executeQuery("SELECT * FROM Reading"); break; default: rs = null; } return rs; } }
 */
