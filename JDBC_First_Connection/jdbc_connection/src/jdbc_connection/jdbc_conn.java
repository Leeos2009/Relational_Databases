package jdbc_connection;
import java.sql.*;
public class jdbc_conn {
	 private static final String USERNAME = "root";
	   private static final String PASSWORD = "955gehc8A_";
	   private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	   private static final String URL = "jdbc:mysql://localhost:3306/Estate_Agents?autoReconnect=true&useSSL=false";
	   private static Connection conn = null;
	public static void main(String args[]) throws Exception {
		
	
		//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Estate_Agents", "root", "955gehc8A_");
	   try {
		   Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	   conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
	   
	   Statement st = conn.createStatement();
	   ResultSet rs = st.executeQuery("Select * FROM Branch");
	   
	   while (rs.next()) {
		  String branchNo = rs.getString("branchNo");
		  String street = rs.getString("street");
		  String city = rs.getString("city");
		  String postcode = rs.getString("postcode");
		  
		  System.out.println(branchNo + "\t" + street + "\t" + city + "\t" + postcode);
	   }
	   }
	   catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
	throw ex;
	   }
	   
}
}
