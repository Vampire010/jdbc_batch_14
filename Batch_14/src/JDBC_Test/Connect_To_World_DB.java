package JDBC_Test;
import java.sql.*;
public class Connect_To_World_DB 
{
	private static  final String  query = "	";
	private static  final String  db_url="jdbc:oracle:thin:@localhost:1521:BATCH14";
	private static  final String  username ="sys as sysdba";
	private static  final String  password = "Girish@1234";
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
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
			int user_id = rs.getInt("user_id");

		
			System.out.println(user_id  );
		}
		con.close();		
	}
}
