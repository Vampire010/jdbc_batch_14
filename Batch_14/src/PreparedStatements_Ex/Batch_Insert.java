package PreparedStatements_Ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch_Insert 
{

	private static  final String  query = "insert into employee(emp_id,empname,emp_dept) values(?,?,?);";
	private static  final String  db_url="jdbc:mysql://localhost:3306/world?user=root";
	private static  final String  username ="root";
	private static  final String  password = "1992";
	
	public void batch_insert_Tc01() throws SQLException
	{
		try
		{
		Connection con = DriverManager.getConnection(db_url, username, password);
		
		//Create a statement using con object
			PreparedStatement stmt = con.prepareStatement(query);
			con.setAutoCommit(false);
				stmt.setInt(1, 103);
				stmt.setString(2, "keen");
				stmt.setString(3, "DA");
				stmt.addBatch();
				
				stmt.setInt(1, 104);
				stmt.setString(2, "Dan");
				stmt.setString(3, "QA");
				stmt.addBatch();
				
				stmt.setInt(1, 106);
				stmt.setString(2, "Tony");
				stmt.setString(3, "BA");
				stmt.addBatch();
				
				int[] updatecounts = stmt.executeBatch();
				for(int i =0 ; i<updatecounts.length;i++)
				{
					System.out.println("employee table created successfully " + updatecounts[i] + " row(s) affected ");
				}
				con.commit();
				con.setAutoCommit(true);
				con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws SQLException 
	{
		Batch_Insert insr = new Batch_Insert();
		insr.batch_insert_Tc01();
	}

}
