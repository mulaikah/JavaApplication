package ePortalPackage;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add New Student</a>");  
        out.println("<h1>Student List</h1>");  
          
        List<StudentBean> list=StudentDao.getAllStudents();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Student Id</th><th>Password</th><th>First Name</th><th>Last Name</th><th>Address</th><th>Faculty</th><th>Program</th><th>Phone</th><th>Email</th><th>Edit</th><th>Delete</th></tr>");  
        for(StudentBean studentBean:list){  
         out.print("<tr><td>"+studentBean.getStudentId()+"</td><td>"+studentBean.getStudentPassword()+"</td><td>"+studentBean.getFirstName()+"</td><td>"+studentBean.getLastName()+"</td><td>"+studentBean.getAddress()+"</td><td>"+studentBean.getFaculty()+"</td><td>"+studentBean.getProgramme()+"</td><td>"+studentBean.getPhone()+"</td><td>"+studentBean.getEmail()+"</td><td><a href='EditServlet?student_id="+studentBean.getStudentId()+"'>edit</a></td><td><a href='DeleteServlet?student_id="+studentBean.getStudentId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  