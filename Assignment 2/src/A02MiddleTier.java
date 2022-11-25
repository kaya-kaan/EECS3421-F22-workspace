import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class A02MiddleTier {
	//This class will contain your code for interacting with Database, acquire the query result and display it in the GUI text area.

	public A02MiddleTier(){
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kaan", "root", "07miray07");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from people");
			while (myRs.next()) {
				System.out.println(myRs.getString("Name"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
