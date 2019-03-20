package ePortalPackage;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Student</h1>");  
        String student_id=request.getParameter("student_id");  
          
        StudentBean studentBean =StudentDao.getStudentId(student_id);
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='student_id' value='"+studentBean.getStudentId()+"'/></td></tr>");  
        out.print("<tr><td>Password:</td><td><input type='text' name='student_pswd' value='"+studentBean.getStudentPassword()+"'/> </td></tr>");  
        out.print("<tr><td>First Name:</td><td><input type='text' name='firstname' value='"+studentBean.getFirstName()+"'/></td></tr>");  
        out.print("<tr><td>Last Name:</td><td><input type='text' name='lastname' value='"+studentBean.getLastName()+"'/></td></tr>");
        out.print("<tr><td>Address:</td><td><input type='text' name='address' value='"+studentBean.getAddress()+"'/></td></tr>");  
        out.print("<tr><td>Faculty:</td><td>");  
        out.print("<select name='faculty' style='width:150px'>");    
        out.print("<option>Faculty of Languages and Communication</option>");  
        out.print("<option>Faculty of Music and Performing Art</option>");  
        out.print("<option>Faculty of Human Science</option>");  
        out.print("<option>Faculty of Art,Computing and Creative Industry </option>");  
        out.print("<option>Faculty of Management and Economics </option>");  
        out.print("<option>Faculty of Science and Mathematics </option>");  
        out.print("</select>"); 
        out.print("<tr><td>Program:</td><td><input type='text' name='programme' value='"+studentBean.getProgramme()+"'/></td></tr>");  
        out.print("<tr><td>Phone:</td><td><input type='text' name='phone' value='"+studentBean.getPhone()+"'/></td></tr>");
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+studentBean.getEmail()+"'/></td></tr>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  
