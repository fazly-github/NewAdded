package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePage {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	String columnValue = null;

	public String getDataFromDB(String columnName) {
		try {

//			setting properties of mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sqlUrl = "jdbc:mysql://localhost:3306/julynew2022";
			String sqlUsername = "root";
			String sqlPassword = "Root@2023";
			String sqlQuery = "Select * from users;";

//			create connection to local database
			connection = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);

//			empowering the connection reference variable to execute queries
			statement = connection.createStatement();

//			delivering the query
			resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {
				columnValue = resultSet.getString(columnName);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (resultSet !=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection !=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return columnValue;

	}
}
