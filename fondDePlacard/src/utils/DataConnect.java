package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {
	
	private static Connection connection;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");// on charge le pilote jdbc s'il trouve pas, une exception
			connection=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/placard?useSSL=false","root", "");
		} catch (Exception e) {  // ici une seul exeption pour les deux( classNot found et sqlException
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
	public static void closeConnection (Connection c) throws SQLException{
		c.close();
	}
}
