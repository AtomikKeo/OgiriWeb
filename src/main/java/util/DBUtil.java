package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/ogiri";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	static {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBSドライバのロードに失敗しました");
		}
	}

	public Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
		return con;
	}

	public void closeConnenction(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
