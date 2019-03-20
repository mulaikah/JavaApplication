package ePortalPackage;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  


@WebServlet("/EditCourseServlet2")
public class EditCourseServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	          throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        int course_id = Integer.parseInt(request.getParameter("course_id"));
			String course_name = request.getParameter("course_name");
			int credit_hour = Integer.parseInt(request.getParameter("credit_hour"));
			String classGroup = request.getParameter("classGroup");
	          
			CourseBean courseBean = new CourseBean();

			courseBean.setCourseId(course_id);
			courseBean.setCourseName(course_name);
			courseBean.setCreditHour(credit_hour);
			courseBean.setClassGroup(classGroup);
	          
	        int status=CourseDao.updateCourse(courseBean);  
	        if(status>0){  
	        	out.println("<script type=\"text/javascript\">");  
	            out.println("alert('Record update successfully!');");  
	            out.println("</script>");
	            request.getRequestDispatcher("viewCourse.jsp").include(request, response);
	        }else{  
	        	out.println("<script type=\"text/javascript\">");  
	            out.println("alert('Sorry! unable to update record');");  
	            out.println("</script>");
	            request.getRequestDispatcher("viewCourse.jsp").include(request, response);
	        }  
	          
	        out.close();  
	    }  
	  
	}  