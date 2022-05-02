package JDBC_Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_The_DB 
{

	private static  final String  query = "update employee set empname='smith' where emp_id = 101;";
	private static  final String  db_url="jdbc:mysql://localhost:3306/world?user=root";
	private static  final String  username ="root";
	private static  final String  password = "1992";
	
	public void updateRecord() throws SQLException
	{
		//Establish a Connection	
		Connection con = DriverManager.getConnection(db_url, username, password);
					
		//Create a statement using con object
		Statement stmt = con.createStatement();
		
		int rs = stmt.executeUpdate(query);
		System.out.println(" row(s) affected " + rs);
		
	}
	
	public static void main(String[] args) throws SQLException 
	{

		Update_The_DB update_rec= new Update_The_DB();
		update_rec.updateRecord();
				
		
	}

}
