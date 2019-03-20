package ePortalPackage;

import java.util.*;  
import java.sql.*; 

public class StudentDao2 {
	
	static Connection currentCon = null;
	   static ResultSet rs = null;  
		
	   public static StudentBean login(StudentBean studentBean) {
		
	      //preparing some objects for connection 
	      Statement stmt = null;    
		
	      String student_id = studentBean.getStudentId();    
	      String student_pswd = studentBean.getStudentPassword();   
		    
	      String searchQuery =
	            "select * from student where student_id='"
	                     + student_id
	                     + "' AND student_pswd='"
	                     + student_pswd
	                     + "'";
		    
	   // "System.out.println" prints in the console; Normally used to trace the process
	   System.out.println("Your username is " + student_id);          
	   System.out.println("Your password is " + student_pswd);
	   System.out.println("Query: "+searchQuery);
		    
	   try 
	   {
	      //connect to DB 
	      currentCon = ConnectionManager.getConnection();
	      stmt=currentCon.createStatement();
	      rs = stmt.executeQuery(searchQuery);	        
	      boolean more = rs.next();
		       
	      if (!more) 
	      {
	         System.out.println("Sorry, you are not a registered user! Please sign up first");
	         studentBean.setValid(false);
	      } 
		        
	      //if user exists set the isValid variable to true
	      else if (more) 
	      {
	  		String firstname = rs.getString("firstname");
			String lastname = rs.getString("lastname");
			String address = rs.getString("address");
			String faculty = rs.getString("faculty");
			String programme = rs.getString("programme");
			int phone = rs.getInt("phone");
			String email = rs.getString("email");
		     	
	         System.out.println("Welcome " + firstname);
	         studentBean.setFirstName(firstname);
	         studentBean.setLastName(lastname);
         	studentBean.setAddress(address);  
         	studentBean.setFaculty(faculty);  
         	studentBean.setProgramme(programme);  
         	studentBean.setPhone(phone);  
         	studentBean.setEmail(email);  
	         
	         studentBean.setValid(true);
	      }
	   } 

	   catch (Exception ex) 
	   {
	      System.out.println("Log In failed: An Exception has occurred! " + ex);
	   } 
		    
	   //some exception handling
	   finally 
	   {
	      if (rs != null)	{
	         try {
	            rs.close();
	         } catch (Exception e) {}
	            rs = null;
	         }
		
	      if (stmt != null) {
	         try {
	            stmt.close();
	         } catch (Exception e) {}
	            stmt = null;
	         }
		
	      if (currentCon != null) {
	         try {
	            currentCon.close();
	         } catch (Exception e) {
	         }

	         currentCon = null;
	      }
	   }

	return studentBean;
		
	   }	
	}