package JDBC_Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_Table 
{
	private static  final String  query = "create table image_data(Id int,data BLOB)";
	private static  final String  db_url="jdbc:oracle:thin:@localhost:1521:BATCH14";
	private static  final String  username ="sys as sysdba";
	private static  final String  password = "Girish@1234";
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
				Class.forName(DB_DRIVER);
				//Establish a Connection	
				Connection con = DriverManager.getConnection(db_url, username , password);
					
				//Create a statement using con object
				Statement stmt = con.createStatement();
				
				//Excute Query
				int rs = stmt.executeUpdate(query);
				
				System.out.println("image_data table created successfully " + rs + " row(s) affected ");
				con.close();
	}
}
