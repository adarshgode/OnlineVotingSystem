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
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import Utils.JDBCUtil;
import entity.Voter;

@WebServlet("/savevote")
public class SaveVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SaveVoteServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Save Vote Called....");

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("voter") == null) {
            response.sendRedirect("login");
            return;
        }

        Voter voter = (Voter) session.getAttribute("voter");
        int vid = voter.getVoterId();
        
        int cid = Integer.parseInt(request.getParameter("cid"));

        String cname = request.getParameter("cname_" + cid);
        String pname = request.getParameter("pname_" + cid);

        
        
        Connection con = JDBCUtil.getConnection();
        
        if(!voter.isStatus()) {
        	try {
        		con.setAutoCommit(false);  


            String sql1 = "UPDATE candidates SET votecount = votecount + 1 WHERE c_id = ?";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, cid);
            ps1.executeUpdate();

            
            String sql2 = "UPDATE voter SET status = TRUE WHERE voter_id = ?"; 
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, vid);
            ps2.executeUpdate();

            con.commit();
            request.setAttribute("msg", 
                    "Voter ID: " + vid + "<br>" +
                    "Candidate Chosen: " + cname + "<br>" +
                    "Party: " + pname + "<br><br>" +
                    "<b>Thank you for participating in the democratic process.</b>"
            );

            System.out.println("Transaction Success");
			
		} catch (Exception e) {
		    e.printStackTrace();
		    try {
		        con.rollback(); 
		        System.out.println("Transaction Rolled Back");
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		    
		}
        }
        
        session.invalidate();
        request.getRequestDispatcher("successvote.jsp").forward(request, response);;
	}

}
