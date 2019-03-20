package ePortalPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ePortalPackage.RegisterBean;
import ePortalPackage.RegisterDao;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String student_id = request.getParameter("student_id");
		String student_pswd = request.getParameter("student_pswd");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		String faculty = request.getParameter("faculty");
		String programme = request.getParameter("programme");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String email = request.getParameter("email");

		RegisterBean registerBean = new RegisterBean();

		registerBean.setStudentId(student_id);
		registerBean.setStudentPassword(student_pswd);
		registerBean.setFirstName(firstname);
		registerBean.setLastName(lastname);
		registerBean.setAddress(address);
		registerBean.setFaculty(faculty);
		registerBean.setProgramme(programme);
		registerBean.setPhone(phone);
		registerBean.setEmail(email);

		RegisterDao registerDao = new RegisterDao();

		String userRegistered = registerDao.registerUser(registerBean);

		if (userRegistered.equals("SUCCESS")) {
			request.getRequestDispatcher("/test.jsp").forward(request, response);
		} else {
			request.setAttribute("errMessage", userRegistered);
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
		}
	}
}