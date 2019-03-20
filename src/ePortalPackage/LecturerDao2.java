package ePortalPackage;

//5import java.util.*;  
import java.sql.*; 

public class LecturerDao2 {
	
	static Connection currentCon = null;
	   static ResultSet rs = null;  
		
	   public static LecturerBean login(LecturerBean lecturerBean) {
		
	      //preparing some objects for connection 
	      Statement stmt = null;    
		
	      String lecturer_id = lecturerBean.getLecturerId();    
	      String lecturer_pswd = lecturerBean.getLecturerPassword();   
		    
	      String searchQuery =
	            "select * from lecturer where lecturer_id='"
	                     + lecturer_id
	                     + "' AND lecturer_pswd='"
	                     + lecturer_pswd
	                     + "'";
		    
	   // "System.out.println" prints in the console; Normally used to trace the process
	   System.out.println("Your username is " + lecturer_id);          
	   System.out.println("Your password is " + lecturer_pswd);
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
	         lecturerBean.setValid(false);
	      } 
		        
	      //if user exists set the isValid variable to true
	      else if (more) 
	      {
	  		String lecturer_name = rs.getString("lecturer_name");
			String position = rs.getString("position");
			String lecturer_faculty = rs.getString("lecturer_faculty");
			String phone = rs.getString("phone");
			String lecturer_email = rs.getString("lecturer_email");
		     	
	         System.out.println("Welcome " + lecturer_name);
	         lecturerBean.setLecturerName(lecturer_name);
	         lecturerBean.setPosition(position);
         	lecturerBean.setLecturerFaculty(lecturer_faculty);  
         	lecturerBean.setPhone(phone);  
         	lecturerBean.setLecturerEmail(lecturer_email);  
	         lecturerBean.setValid(true);
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

	return lecturerBean;
		
	   }	
	}