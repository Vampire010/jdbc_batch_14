package PreparedStatements_Ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert_Data
{

	private static  final String  query = "insert into employee(emp_id,empname,emp_dept) values(?,?,?);";
	private static  final String  db_url="jdbc:mysql://localhost:3306/world?user=root";
	private static  final String  username ="root";
	private static  final String  password = "1992";
	
	public static void main(String[] args) throws SQLException 
	{
		 Connection con = DriverManager.getConnection(db_url, username, password);
				
				//Create a statement using con object
				PreparedStatement stmt = con.prepareStatement(query);
					stmt.setInt(1, 102);
					stmt.setString(2, "Trunk");
					stmt.setString(3, "DEV");
					//Excute Query
					int rs = stmt.executeUpdate();
					
					System.out.println("employee table created successfully " + rs + " row(s) affected ");
					stmt.close();
					con.close();
				
		}
	}
