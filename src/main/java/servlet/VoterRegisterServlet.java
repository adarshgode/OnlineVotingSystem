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

@WebServlet("/voterregister")
public class VoterRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public VoterRegisterServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("voterregister.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Voter v = new Voter();
		v.setAdharNo(request.getParameter("ano"));
		v.setName(request.getParameter("vname"));
		v.setPassword(request.getParameter("vpass"));
		v.setAge(Integer.parseInt(request.getParameter("age")));
		System.out.println(v);
		
		Connection con = JDBCUtil.getConnection();
		try {
			PreparedStatement pstmt =  con.prepareStatement("insert into voter(adhar_no, name, password, age) values(?,?,?,?)");
			pstmt.setString(1, v.getAdharNo());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getPassword());
			pstmt.setInt(4, v.getAge());
			
			int row = pstmt.executeUpdate();
			if(row > 0) {
				System.out.println("Data Inserted Successfully...");
				response.sendRedirect("login");
				return;
			}
			
		} catch (SQLException e) {
			System.out.println("Data not inserted");
			response.sendRedirect("voterregister");
			e.printStackTrace();
		}
		
	}

}
