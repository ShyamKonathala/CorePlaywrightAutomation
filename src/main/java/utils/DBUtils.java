package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	
	private static final String DB_URL = 
	        "jdbc:sqlserver://ceiusea2db-uat-sql.22dc87ca0a41.database.windows.net:1433;" +
	        "databaseName=core_uat;" +
	        "encrypt=true;" +
	        "trustServerCertificate=true;" +
	        "loginTimeout=30;";
	    private static final String USER = "cedevops";
	    private static final String PASS = "H@rsc0!";

	    // Thread-local connection (each thread has its own)
	    private static ThreadLocal<Connection> threadLocalConn = new ThreadLocal<>();

	    /**
	     * Get a thread-safe connection
	     */
	    public static Connection getConnection() throws SQLException {
	        Connection conn = threadLocalConn.get();
	        if (conn == null || conn.isClosed()) {
	            conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            threadLocalConn.set(conn);
	        }
	        return conn;
	    }

	    /**
	     * Execute a query and return ResultSet.
	     * Caller must close ResultSet.
	     */
	    public static ResultSet executeQuery(String query) throws SQLException {
	        Statement stmt = getConnection().createStatement();
	        return stmt.executeQuery(query);
	    }

	    /**
	     * Close all resources for this thread
	     */
	    public static void closeResources(ResultSet rs, Statement stmt) {
	        try { if (rs != null) rs.close(); } catch (Exception ignored) {}
	        try { if (stmt != null) stmt.close(); } catch (Exception ignored) {}
	    }

	    /**
	     * Close connection for current thread
	     */
	    public static void closeConnection() {
	        try {
	            Connection conn = threadLocalConn.get();
	            if (conn != null && !conn.isClosed()) {
	                conn.close();
	            }
	            threadLocalConn.remove(); // remove reference to avoid leaks
	        } catch (SQLException ignored) {}
	    }

}
