package pak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

public class StationDAL {
	public JSONArray getStations() {
		JSONArray ja = new JSONArray();
		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection(
					"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select trn_start,trn_end from MadhuStations");
			while (rs.next()) {
				JSONObject jo = new JSONObject();
				jo.put("from", rs.getString(1));
				jo.put("to", rs.getString(2));
				ja.put(jo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ja;
	}

	public JSONArray getTrains(String from, String to) {
		JSONArray ja = new JSONArray();
		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection(
					"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
			PreparedStatement s = c
					.prepareStatement("select trn_name from MadhuStations where trn_start=? and trn_end=?");
			s.setString(1, from);
			s.setString(2, to);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				JSONObject jo = new JSONObject();
				jo.put("train", rs.getString(1));
				ja.put(jo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ja;
	}

	public void setData(String[] no, String[] name, String[] age, String[] gen, String cla, String date, String from,
			String to, String train) {
		try {
			System.out.println("reshma");
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection(
					"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
			PreparedStatement s = c.prepareStatement("Insert into trn_trains values(?,?,?,?,?)");
			s.setString(1, from);
			s.setString(2, to);
			s.setString(3, train);
			s.setString(4, cla);
			s.setString(5, date);
			s.execute();
			for (int i = 0; i < no.length; i++) {
				PreparedStatement ss = c.prepareStatement("Insert into trn_passenger values(?,?,?,?)");
				ss.setString(1, no[i]);
				ss.setString(2, name[i]);
				ss.setString(3, age[i]);
				ss.setString(4, gen[i]);
				ss.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}