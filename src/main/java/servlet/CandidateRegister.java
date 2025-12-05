package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.JDBCUtil;
import entity.Candidate;
import entity.Voter;


@WebServlet("/candidateregister")
public class CandidateRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CandidateRegister() {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("candidateregister.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Candidate c = new Candidate();
		c.setcName(request.getParameter("vname"));
		c.setcParty(request.getParameter("pname"));
		c.setVoterId(Integer.parseInt(request.getParameter("vid")));
		System.out.println(c);
		
		Connection con = JDBCUtil.getConnection();
		try {
			PreparedStatement pstmt =  con.prepareStatement("insert into candidates(c_name, c_party, voter_id) values(?,?,?)");
			pstmt.setString(1, c.getcName());
			pstmt.setString(2, c.getcParty());
			pstmt.setInt(3, c.getVoterId());
			
			int row = pstmt.executeUpdate();
			if(row > 0) {
				System.out.println("Data Inserted Successfully...");
				response.sendRedirect("login");
				return;
			}
			
		} catch (SQLException e) {
			System.out.println("Data not inserted");
			response.sendRedirect("candidateregister");
			e.printStackTrace();
		}
		
	}

}
