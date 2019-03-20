package ePortalPackage;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/EditCourseServlet")
public class EditCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	           throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<h1>Update Course</h1>");  
	        String course_id=request.getParameter("course_id");  
	          
	        CourseBean courseBean =CourseDao.getCourseId(course_id);
	          
	        out.print("<form action='EditCourseServlet2' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='course_id' value='"+courseBean.getCourseId()+"'/></td></tr>");  
	        out.print("<tr><td>Password:</td><td><input type='text' name='course_name' value='"+courseBean.getCourseName()+"'/> </td></tr>");  
	        out.print("<tr><td>Credit Hour:</td><td>");  
	        out.print("<select name='credit_hour' style='width:150px'>");    
	        out.print("<option>1</option>");  
	        out.print("<option>2</option>");  
	        out.print("<option>3</option>");  
	        out.print("<option>4</option>");  
	        out.print("<option>5</option>");  
	        out.print("<option>6</option>");  
	        out.print("</select>");
	        out.print("<tr><td>Group:</td><td>");  
	        out.print("<select name='classGroup' style='width:150px'>");    
	        out.print("<option>A</option>");  
	        out.print("<option>B</option>");  
	        out.print("<option>C</option>");  
	        out.print("<option>D</option>");  
	        out.print("</select>");
 	        out.print("</td></tr>");  
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	          
	        out.close();  
	    }  
	}  
