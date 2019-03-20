package ePortalPackage;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/ViewCourseServlet")  
public class ViewCourseServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='addCourse.html'>Add New Course</a>");  
        out.println("<h1>Course List</h1>");  
          
        List<CourseBean> list=CourseDao.getAllCourses();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Course Id</th><th>Course Name</th><th>Credit Hour</th><th>Group</th><th>Edit</th><th>Delete</th></tr>");  
        for(CourseBean courseBean:list){  
         out.print("<tr><td>"+courseBean.getCourseId()+"</td><td>"+courseBean.getCourseName()+"</td><td>"+courseBean.getCreditHour()+"</td><td>"+courseBean.getClassGroup()+"</td><td><a href='EditCourseServlet?course_id="+courseBean.getCourseId()+"'>edit</a></td><td><a href='DeleteCourseServlet?course_id="+courseBean.getCourseId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  