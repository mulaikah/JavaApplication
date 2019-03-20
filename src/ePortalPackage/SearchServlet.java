package ePortalPackage;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        Connection currentCon = ConnectionManager.getConnection();
//        PrintWriter out = response.getWriter();
		
        Statement st;
        try {
        	System.out.println("Connected!");
            String student_id = request.getParameter("student_id");
//            String student_pwd= request.getParameter("student_pwd");
//            String firstname = request.getParameter("firstname");
//            String lastname = request.getParameter("lastname");
//            String address = request.getParameter("address");
//            String faculty = request.getParameter("faculty");
//            String programme = request.getParameter("programme");
//            String phone = request.getParameter("phone");
//            String email = request.getParameter("email");
 
            ArrayList al = null;
            ArrayList student_id_list = new ArrayList();
            String query = "select * from student where student_id='" + student_id + "' ";
 
            System.out.println("query " + query);
            st = currentCon.createStatement();
            ResultSet rs = st.executeQuery(query);
 
            while (rs.next()) {
                al = new ArrayList();
                al.add(rs.getString(1));
                al.add(rs.getString(2));
                al.add(rs.getString(3));
                al.add(rs.getString(4));
                al.add(rs.getString(5));
                al.add(rs.getString(6));
                al.add(rs.getString(7));
                al.add(rs.getString(8));                
                al.add(rs.getString(9));

 
                System.out.println("al :: " + al);
                student_id_list.add(al);
            }
 
            request.setAttribute("piList", student_id_list);
                        
            RequestDispatcher view = request.getRequestDispatcher("/searchView.jsp");
            view.forward(request, response);
            currentCon.close();
            System.out.println("Disconnected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
  
	}

