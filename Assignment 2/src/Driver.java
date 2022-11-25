import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try{
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kaan", "root", "07miray07");
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery("select * from people");
				while (myRs.next()) {
					System.out.println(myRs.getString("Name"));
				}
			}
			catch(Exception exc){
				exc.printStackTrace();
			}
		}
	}
