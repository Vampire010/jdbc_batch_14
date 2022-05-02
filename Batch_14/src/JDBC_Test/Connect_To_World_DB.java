package JDBC_Test;
import java.sql.*;
public class Connect_To_World_DB 
{
	private static  final String  query = "Select * from employee;";
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
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next())
		{
			int emp_id = rs.getInt("emp_id");
			String empname = rs.getString("empname");
			String emp_dept = rs.getString("emp_dept");
		
			System.out.println(emp_id + " , " + empname +" , " + emp_dept );
		}
		con.close();		
	}
}
