package ticketBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBC {
	public ArrayList<Stations> connection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5434/postgres","postgres","1234");
		Statement st = c.createStatement();
		String query = "select * from trains";
		ResultSet rs = st.executeQuery(query);
		ArrayList<Stations> as = new ArrayList<>();
		while (rs.next()) {
			as.add(new Stations(rs.getString(3), rs.getString(4)));
		}
		return as;
	}

	public ArrayList<Train> trainconnection(String from, String to) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5434/postgres","postgres","1234");
		//Statement st = c.createStatement();
		// String query = "select * from Hemu_trains where trn_start=${from} and trn_end=${to}";
		PreparedStatement ps = c.prepareCall("select * from trains where from_station=? and to_station=?");
		ps.setString(1, from);
		ps.setString(2, to);
		ArrayList<Train> at = new ArrayList<>();
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			at.add(new Train(rs.getString(2)));
		}
		return at;
	}
	public int insert(String from,String to,String train,String cls,String dt,ArrayList<Passengers> ap) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5434/postgres","postgres","1234");
		PreparedStatement ps = c.prepareCall("insert into hemu_ticket(fromm,too,tname,classs,tdate) values(?,?,?,?,?) returning pnrno");
		ps.setString(1, from);
		ps.setString(2, to);
		ps.setString(3, train);
		ps.setString(4, cls);
		ps.setString(5, dt);
		ResultSet rs=ps.executeQuery();
		int pnrno=0;
		if(rs.next()) {
			pnrno=rs.getInt(1);
		}
		for(Passengers p:ap) {
			PreparedStatement ps1 = c.prepareCall("insert into passenger values(?,?,?,?)");
			ps1.setInt(4, pnrno);
			ps1.setString(1, p.getName());
			ps1.setString(2, p.getAge());
			ps1.setString(3, p.getGender());
			ps1.executeUpdate();
		}
		return pnrno;
		
	}
}