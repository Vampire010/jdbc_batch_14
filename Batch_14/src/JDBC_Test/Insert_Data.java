package JDBC_Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_Data {

		private static  final String  query = "insert into employee values(101,'john','Dev')";
		private static  final String  db_url="jdbc:mysql://localhost:3306/world?user=root";
		private static  final String  username ="root";
		private static  final String  password = "1992";

	public static void main(String[] args) throws SQLException 
	{
		//Establish a Connection	
		Connection con = DriverManager.getConnection(db_url, username, password);
		
		//Create a statement using con object
		Statement stmt = con.createStatement();
		
		//Excute Query
		int rs = stmt.executeUpdate(query);
		
		System.out.println("employee table created successfully " + rs + " row(s) affected ");
		con.close();
	}

}
