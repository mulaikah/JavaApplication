package ePortalPackage;

import java.util.*;  
import java.sql.*; 

public class StudentDao {
	
   static Connection currentCon = null;
	 static PreparedStatement preparedStatement = null;
	 
	 public static int saveStudent (StudentBean studentBean){
		int status=0; 
		
	 try
	 {
	 currentCon = ConnectionManager.getConnection();
	 String query = "insert into student(student_id, student_pswd, firstname, lastname, address, faculty, programme, phone, email) values (?,?,?,?,?,?,?,?,?)"; 
	 preparedStatement = currentCon.prepareStatement(query); 
	 preparedStatement.setString(1,studentBean.getStudentId());
	 preparedStatement.setString(2,studentBean.getStudentPassword());
	 preparedStatement.setString(3,studentBean.getFirstName());
	 preparedStatement.setString(4,studentBean.getLastName());
	 preparedStatement.setString(5,studentBean.getAddress());
	 preparedStatement.setString(6,studentBean.getFaculty());
	 preparedStatement.setString(7,studentBean.getProgramme());
	 preparedStatement.setInt(8,studentBean.getPhone());
	 preparedStatement.setString(9,studentBean.getEmail());	 
	 
	 status=preparedStatement.executeUpdate();  

	 currentCon.close();  
 }catch(Exception ex){ex.printStackTrace();}  
   
 return status;  
}  	
	    public static int updateStudent(StudentBean studentBean){  
	    	 int status=0;  

	        try{  
	        	
	        currentCon = ConnectionManager.getConnection();
	       	 String query = "update student set student_pswd=?, firstname=?,lastname=?,address=?,faculty=?,programme=?,phone=?,email=? where student_id=?"; 
	       	preparedStatement = currentCon.prepareStatement(query); 
		 preparedStatement.setString(1,studentBean.getStudentPassword());
		 preparedStatement.setString(2,studentBean.getFirstName());
		 preparedStatement.setString(3,studentBean.getLastName());
		 preparedStatement.setString(4,studentBean.getAddress());
		 preparedStatement.setString(5,studentBean.getFaculty());
		 preparedStatement.setString(6,studentBean.getProgramme());
		 preparedStatement.setInt(7,studentBean.getPhone());
		 preparedStatement.setString(8,studentBean.getEmail());	 
		 preparedStatement.setString(9,studentBean.getStudentId());
	              
	            status=preparedStatement.executeUpdate();  
	              
	            currentCon.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int deleteStudent(String student_id){  
	        int status=0;  
	        try{  
	        	currentCon = ConnectionManager.getConnection();
	        	String query = "delete from student where student_id=?"; 
		       	preparedStatement = currentCon.prepareStatement(query);
		       
		       	preparedStatement.setString(1,student_id);

	            status=preparedStatement.executeUpdate();  
	              
	            currentCon.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static StudentBean getStudentId(String student_id){  
	        StudentBean studentBean=new StudentBean();  
	          
	        try{  
	        	
	        	currentCon = ConnectionManager.getConnection();
		       	 String query = "select * from student where student_id=?"; 
		       	preparedStatement = currentCon.prepareStatement(query); 

		       	preparedStatement.setString(1,student_id);
		       	
	            ResultSet rs=preparedStatement.executeQuery();  
	            if(rs.next()){  
	            	studentBean.setStudentId(rs.getString(1));  
	            	studentBean.setStudentPassword(rs.getString(2));  
	            	studentBean.setFirstName(rs.getString(3));  
	            	studentBean.setLastName(rs.getString(4));  
	            	studentBean.setAddress(rs.getString(5));  
	            	studentBean.setFaculty(rs.getString(6));  
	            	studentBean.setProgramme(rs.getString(7));  
	            	studentBean.setPhone(rs.getInt(8));  
	            	studentBean.setEmail(rs.getString(9));  
	            }  
	            currentCon.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return studentBean;  
	    }  
	    
	    public static List<StudentBean> getAllStudents(){  
	        List<StudentBean> list=new ArrayList<StudentBean>();  
	          
	        try{  
	        	currentCon = ConnectionManager.getConnection();
		       	 String query = "select * from student"; 
		       	preparedStatement = currentCon.prepareStatement(query); 
		       	ResultSet rs=preparedStatement.executeQuery();  
	            
	            while(rs.next()){  
	            	StudentBean studentBean=new StudentBean();  
	            	
	                studentBean.setStudentId(rs.getString(1));  
	            	studentBean.setStudentPassword(rs.getString(2));  
	            	studentBean.setFirstName(rs.getString(3));  
	            	studentBean.setLastName(rs.getString(4));  
	            	studentBean.setAddress(rs.getString(5));  
	            	studentBean.setFaculty(rs.getString(6));  
	            	studentBean.setProgramme(rs.getString(7));  
	            	studentBean.setPhone(rs.getInt(8));  
	            	studentBean.setEmail(rs.getString(9));  
	                list.add(studentBean);  
	            }  
	            currentCon.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
	}  
