package Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Candidate;

public class ConvertResultSetToList {
	public static List<Candidate> convertToList(ResultSet rs) {
		List<Candidate> list = new ArrayList<>();
		
		try {
			while(rs.next()) {
				 Candidate cd = new Candidate(
			        rs.getInt("c_id"),
			        rs.getString("c_name"),
			        rs.getString("c_party"),
			        rs.getInt("votecount"),
			        rs.getInt("voter_id"));
				 
			        list.add(cd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
