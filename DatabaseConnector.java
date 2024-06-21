package consolebasedproject1;

	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class DatabaseConnector {
	    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mobileshopmanagement";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "harimysql777...";

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
	    }
}


