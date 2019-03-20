package ePortalPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ePortalPackage.RegisterBean;
import ePortalPackage.ConnectionManager;

public class RegisterDao 
{
	public String registerUser(RegisterBean registerBean)
	 {
        String student_id=registerBean.getStudentId(); 
        String student_pswd=registerBean.getStudentPassword();
        String firstname=registerBean.getFirstName();
        String lastname=registerBean.getLastName();
        String address=registerBean.getAddress();
        String faculty=registerBean.getFaculty();
        String programme=registerBean.getProgramme();
        int phone=registerBean.getPhone(); 
        String email=registerBean.getEmail();
	 
	 Connection con = null;
	 PreparedStatement preparedStatement = null;
	 
	 try
	 {
	 con = ConnectionManager.getConnection();
	 String query = "insert into student(student_id,student_pswd,firstname,lastname,address,faculty,programme,phone,email) values (?,?,?,?,?,?,?,?,?)"; 
	 preparedStatement = con.prepareStatement(query); 
	 preparedStatement.setString(1, student_id);
	 preparedStatement.setString(2, student_pswd);
	 preparedStatement.setString(3, firstname);
	 preparedStatement.setString(4, lastname);
	 preparedStatement.setString(5, address);
	 preparedStatement.setString(6, faculty); 
	 preparedStatement.setString(7, programme);
	 preparedStatement.setInt(8, phone);
	 preparedStatement.setString(9, email);
	 
	 
	 int i= preparedStatement.executeUpdate();
	 
	 if (i!=0)  //Just to ensure data has been inserted into the database
	 return "SUCCESS"; 
	 }
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 
	 return "Oops.. Something went wrong there..!"; 
	 }
	}

 