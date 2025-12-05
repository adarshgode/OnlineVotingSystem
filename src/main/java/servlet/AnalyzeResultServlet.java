package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.JDBCUtil;
import entity.Candidate;

@WebServlet("/analyzeresult")
public class AnalyzeResultServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Connection con = JDBCUtil.getConnection();

        List<Candidate> list = new ArrayList<>();
        int totalVotes = 0;
        int totalVoters = 0;
        int turnout = 0;

        try {
            // candidates + votes
            PreparedStatement ps = con.prepareStatement("SELECT * FROM candidates");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Candidate c = new Candidate(
                        rs.getInt("c_id"),
                        rs.getString("c_name"),
                        rs.getString("c_party"),
                        rs.getInt("votecount"),
                        rs.getInt("voter_id")
                );
                list.add(c);
                totalVotes += rs.getInt("votecount");
            }

            // total voters
            PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) AS total FROM voter");
            ResultSet rs2 = ps2.executeQuery();
            if (rs2.next()) totalVoters = rs2.getInt("total");

            // voters who voted
            PreparedStatement ps3 = con.prepareStatement("SELECT COUNT(*) AS voted FROM voter WHERE status = TRUE");
            ResultSet rs3 = ps3.executeQuery();
            if (rs3.next()) turnout = rs3.getInt("voted");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("list", list);
        req.setAttribute("totalVotes", totalVotes);
        req.setAttribute("totalVoters", totalVoters);
        req.setAttribute("turnout", turnout);

        req.getRequestDispatcher("analysis.jsp").forward(req, resp);
    }
}
