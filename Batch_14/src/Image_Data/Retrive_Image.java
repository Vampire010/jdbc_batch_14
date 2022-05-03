package Image_Data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Retrive_Image {
	private static  final String  query = "Select * from image_data";
	private static  final String  db_url="jdbc:oracle:thin:@localhost:1521:BATCH14";
	private static  final String  username ="sys as sysdba";
	private static  final String  password = "Girish@1234";
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	public static void main(String[] args) throws SQLException, FileNotFoundException 
	{
		Connection con = DriverManager.getConnection(db_url,username ,password);
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rst = pst.executeQuery();
				
		while(rst.next())
		{
			System.out.println(rst.getObject(1) + " " + rst.getBlob(2));
			
		}
		
	}

}
