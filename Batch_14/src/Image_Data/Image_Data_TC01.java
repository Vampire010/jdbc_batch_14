package Image_Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Image_Data_TC01 
{
	private static  final String  query = "insert into image_data values(?,?)";
	private static  final String  db_url="jdbc:oracle:thin:@localhost:1521:BATCH14";
	private static  final String  username ="sys as sysdba";
	private static  final String  password = "Girish@1234";
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	public static void main(String[] args) throws SQLException, FileNotFoundException 
	{
		Connection con = DriverManager.getConnection(db_url,username ,password);
		PreparedStatement pst = con.prepareStatement(query);
		
		File myFile = new File("C:/Users/giris/OneDrive/Desktop/orcle.jpg");
		FileInputStream fin = new FileInputStream(myFile);
			pst.setInt(1, 100);
			pst.setBinaryStream(2,fin, (int)myFile.length());
			pst.executeUpdate();
			System.out.println("Record inserted");

	}

}
