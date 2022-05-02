package JDBC_Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete_Rec 
{
	private static  final String  query = "delete from employee where emp_id=101;";
	private static  final String  db_url="jdbc:mysql://localhost:3306/world?user=root";
	private static  final String  username ="root";
	private static  final String  password = "1992";

	public void Delete_Rec_tc01() throws SQLException
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
		Delete_Rec delete_data = new Delete_Rec();
		delete_data.Delete_Rec_tc01();
	}

}
