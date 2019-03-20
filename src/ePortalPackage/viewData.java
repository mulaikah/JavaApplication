package ePortalPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewData
 */
@WebServlet("/viewData")
public class viewData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection currentCon = ConnectionManager.getConnection();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try{
			String sql = "select student_id, firstname, lastname, address, faculty, programme, phone, email from student";
			PreparedStatement preparedStatement = (PreparedStatement) currentCon.prepareStatement(sql); 
			ResultSet rs = preparedStatement.executeQuery();
			String str = "<table><tr><th>Student Id</th><th>First Name</th><th>Last Name</th><th>Address</th><th>Faculty</th><th>Programme</th><th>Phone</th><th>Email</th></tr>";
			
			while (rs.next()){
				str += "<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td></tr>";
			}
			str += "</table>";
			out.println (str);
			currentCon.close();
			
		}catch (Exception e){
			System.err.println(e);
		}finally {
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
