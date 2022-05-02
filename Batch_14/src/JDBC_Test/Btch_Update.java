package JDBC_Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Btch_Update {

	private static  final String  db_url="jdbc:mysql://localhost:3306/world?user=root";
	private static  final String  username ="root";
	private static  final String  password = "1992";

	public void update_Rec_tc01() throws SQLException
	{
		//Establish a Connection	
				Connection con = DriverManager.getConnection(db_url, username, password);
							
				//Create a statement using con object
				Statement stmt = con.createStatement();
				con.setAutoCommit(false);
					stmt.addBatch("update employee set empname='ramya' where emp_id = 101;");
					stmt.addBatch("update employee set empname='Tulsi' where emp_id = 102;");
					stmt.addBatch("update employee set empname='Lisa' where emp_id = 104;");
					
					int[] updateCounts = stmt.executeBatch();
					for(int i =0; i<updateCounts.length ; i++)
					{
						System.out.println(" row(s) affected " + updateCounts[i]);
					}	
				con.commit();
	}
	public static void main(String[] args) throws SQLException {
		Btch_Update b = new Btch_Update();
		b.update_Rec_tc01();
	}

}
