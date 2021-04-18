package report;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {

	public static Connection getConnection() throws Exception {
		Properties properties = new Properties();
		String filePath = DBUtil.class.getResource("db.properties").getPath();
		properties.load(new FileReader(filePath));
		
		String MYSQL_DRIVER = properties.getProperty("MYSQL_DRIVER");
		String URL = properties.getProperty("URL");
		String userName = properties.getProperty("username");
		String passWord = properties.getProperty("password");
		
		Class.forName(MYSQL_DRIVER);
		Connection connection = DriverManager.getConnection(URL, userName, passWord);
		if(connection ==null) {
			System.out.println("Database Connect Fail.");
		}
		
		return connection;
	}
}
