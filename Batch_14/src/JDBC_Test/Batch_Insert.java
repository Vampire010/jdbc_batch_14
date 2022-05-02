package JDBC_Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Batch_Insert 
{
	//private static  final String  query = "delete from employee where emp_id=101;";
	private static  final String  db_url="jdbc:mysql://localhost:3306/world?user=root";
	private static  final String  username ="root";
	private static  final String  password = "1992";

	public void Insert_Rec_tc01() throws SQLException
	{
		//Establish a Connection	
				Connection con = DriverManager.getConnection(db_url, username, password);
							
				//Create a statement using con object
				Statement stmt = con.createStatement();
				con.setAutoCommit(false);
					stmt.addBatch("insert into employee values(101,'john','Dev');");
					stmt.addBatch("insert into employee values(102,'smith','QA');");
					stmt.addBatch("insert into employee values(103,'Ram','IT');");
					stmt.addBatch("insert into employee values(104,'Laxman','Dev');");
					stmt.addBatch("insert into employee values(105,'Kushal','SYSDB');");
					
					int[] updateCounts = stmt.executeBatch();
					for(int i =0; i<updateCounts.length ; i++)
					{
						System.out.println(" row(s) affected " + updateCounts[i]);
					}	
				con.commit();
				
				
	}
	public static void main(String[] args) throws SQLException 
	{
		Batch_Insert BCI= new Batch_Insert();
		BCI.Insert_Rec_tc01();
	}

}
