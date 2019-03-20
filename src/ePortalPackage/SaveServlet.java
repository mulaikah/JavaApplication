package ePortalPackage;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
         
        String student_id = request.getParameter("student_id");
		String student_pswd = request.getParameter("student_pswd");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		String faculty = request.getParameter("faculty");
		String programme = request.getParameter("programme");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String email = request.getParameter("email");

		StudentBean studentBean = new StudentBean();
		studentBean.setStudentId(student_id);
		studentBean.setStudentPassword(student_pswd);
		studentBean.setFirstName(firstname);
		studentBean.setLastName(lastname);
		studentBean.setAddress(address);
		studentBean.setFaculty(faculty);
		studentBean.setProgramme(programme);
		studentBean.setPhone(phone);
		studentBean.setEmail(email);

        int status=StudentDao.saveStudent(studentBean);  
		
        if(status>0){  
      	  out.println("<script type=\"text/javascript\">");  
          out.println("alert('Record saved successfully!');");  
          out.println("</script>");
        request.getRequestDispatcher("viewStudent.jsp").include(request, response);  
        }else{  
        	out.println("<script type=\"text/javascript\">");  
            out.println("alert('Sorry! unable to save record');");  
            out.println("</script>");
          request.getRequestDispatcher("addStudent.jsp").include(request, response);  
        }  
          
        out.close();  
    }  
  
}  