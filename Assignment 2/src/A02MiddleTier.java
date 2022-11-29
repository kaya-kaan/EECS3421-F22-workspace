import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class A02MiddleTier { // This class will contain your code for interacting with Database, acquire the
								// query result and display it in the GUI text area.
	Connection conn;
	int ID; // Global variable so every event has a unique ID.

	public A02MiddleTier() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a02_schema", "root", "root1234");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Event");
			while (rs.next()) {
				ID++; // for every tuple in the table, increment the ID so each new tuple has a unique
						// ID value.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createEvent(String eventName) throws SQLException { // Insert new event tuple.
		ID++;
		Statement stmt = conn.createStatement();
		String query = "INSERT INTO Event (ID, Name, EventWebLink, CFPText) values (" + ID + ", '" + eventName
				+ "', 'link', 'email')";
		stmt.executeUpdate(query);
	}

	public void createEventConference(String eventDate) throws SQLException { // Insert new EventConference tuple
		Statement stmt = conn.createStatement();
		String query = "insert into EventConference (EventID, City, Country, EvDate) values (" + ID
				+ ", 'city', 'country', '" + eventDate + "')";
		stmt.executeUpdate(query);
	}

	public void createEventJournal(String journalName) throws SQLException { // Insert new EventJournal tuple
		Statement stmt = conn.createStatement();
		String query = "insert into EventJournal (EventID, JournalName, Publisher) values (" + ID + ", '" + journalName
				+ "', 'publisher')";
		stmt.executeUpdate(query);
	}

	public void createEventBook() throws SQLException { // Insert new EventBook
		Statement stmt = conn.createStatement();
		String query = "insert into EventBook (EventID, Publisher) values (" + ID + ", 'publisher')";
		stmt.executeUpdate(query);
	}

	public String outputEvent() throws SQLException { // Display Event table
		String result = "";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Event");
		while (rs.next()) {
			result = result + rs.getInt("ID") + ", " + rs.getString("Name") + ", " + rs.getString("EventWebLink") + ", "
					+ rs.getString("CFPText") + "\n";
		}
		return result;
	}

	public String outputEventConference() throws SQLException { // Display EventConference Table
		String result = "";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from EventConference");
		while (rs.next()) {
			result = result + rs.getInt("EventID") + ", " + rs.getString("City") + ", " + rs.getString("Country") + ", "
					+ rs.getDate("EvDate") + "\n";
		}
		return result;
	}

	public String outputEventJournal() throws SQLException { // Display EventJournal Table
		String result = "";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from EventJournal");
		while (rs.next()) {
			result = result + rs.getInt("EventID") + ", " + rs.getString("JournalName") + ", "
					+ rs.getString("Publisher") + "\n";
		}
		return result;
	}

	public String outputEventBook() throws SQLException { // Display EventBook Table
		String result = "";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from EventBook");
		while (rs.next()) {
			result = result + rs.getInt("EventID") + ", " + rs.getString("Publisher") + "\n";
		}
		return result;
	}
}