package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utils.JDBCUtil;
import entity.Voter;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public LoginServlet() {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("vname");
        String pass = request.getParameter("vpass");

        String sql = "SELECT * FROM voter WHERE name = ? AND password = ?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();

            HttpSession session = request.getSession();
            Voter voter = null;
            
            if (rs.next()) {
                voter = new Voter(
                        rs.getInt("voter_id"),
                        rs.getString("adhar_no"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getInt("age"),
                        rs.getBoolean("status")
                );

                session.setAttribute("voter", voter);
            } else {
                request.setAttribute("error", "Invalid Username or Password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }

            System.out.println(voter.isStatus());
            if (voter.isStatus() == true) {
            		response.sendRedirect("successvote");
            		return;
            }

            if (voter.getRole().equals("admin")) {
                response.sendRedirect("admin");
                return;
            }
            
            response.sendRedirect("votingpage");

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database Error Occurred");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
