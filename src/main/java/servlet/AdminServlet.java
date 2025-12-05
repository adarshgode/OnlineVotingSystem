package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.ConvertResultSetToList;
import Utils.JDBCUtil;
import entity.Candidate;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public AdminServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = JDBCUtil.getConnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from candidates order by votecount desc limit 2");
			ResultSet rs = pstmt.executeQuery();
			List<Candidate> list = rs != null ? ConvertResultSetToList.convertToList(rs) : null;
			
			request.setAttribute("list", list) ;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}


}
