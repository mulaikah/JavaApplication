package ePortalPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginLecturerServlet")
public class LoginLecturerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, IOException {

try
{	    

     LecturerBean lecturerBean = new LecturerBean();
     lecturerBean.setLecturerId(request.getParameter("lecturer_id"));
     lecturerBean.setLecturerPassword(request.getParameter("lecturer_pswd"));

     lecturerBean = LecturerDao2.login(lecturerBean);
	   		    
     if (lecturerBean.isValid())
     {
	        
          HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionUser",lecturerBean); 
          response.sendRedirect("lecturerLogged.jsp"); //logged-in page      		
     }
	        
     else 
          response.sendRedirect("invalidLogin.jsp"); //error page 
} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}