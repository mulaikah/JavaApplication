package ePortalPackage;

import java.util.*;  
import java.sql.*; 

public class LecturerDao {
	
   static Connection currentCon = null;
	 static PreparedStatement preparedStatement = null;
	 
	 public static int saveLecturer (LecturerBean lecturerBean){
		int status=0; 
		
	 try
	 {
	 currentCon = ConnectionManager.getConnection();
	 String query = "insert into lecturer(lecturer_id, lecturer_pswd, lecturer_name, position, lecturer_faculty, phone, lecturer_email) values (?,?,?,?,?,?,?)"; 
	 preparedStatement = currentCon.prepareStatement(query); 
	 preparedStatement.setString(1,lecturerBean.getLecturerId());
	 preparedStatement.setString(2,lecturerBean.getLecturerPassword());
	 preparedStatement.setString(3,lecturerBean.getLecturerName());
	 preparedStatement.setString(4,lecturerBean.getPosition());
	 preparedStatement.setString(5,lecturerBean.getLecturerFaculty());
	 preparedStatement.setString(6,lecturerBean.getPhone());
	 preparedStatement.setString(7,lecturerBean.getLecturerEmail());
	 
	 status=preparedStatement.executeUpdate();  

	 currentCon.close();  
 }catch(Exception ex){ex.printStackTrace();}  
   
 return status;  
}  	
	    public static int updateLecturer(LecturerBean lecturerBean){  
	    	 int status=0;  

	        try{  
	        	
	        currentCon = ConnectionManager.getConnection();
	       	 String query = "update lecturer set lecturer_pswd=?, lecturer_name=?, position=?, lecturer_faculty=?, phone=?, lecturer_email=? where lecturer_id=?"; 
	       	preparedStatement = currentCon.prepareStatement(query); 
		 preparedStatement.setString(1,lecturerBean.getLecturerPassword());
		 preparedStatement.setString(2,lecturerBean.getLecturerName());
		 preparedStatement.setString(3,lecturerBean.getPosition());
		 preparedStatement.setString(4,lecturerBean.getLecturerFaculty());
		 preparedStatement.setString(5,lecturerBean.getPhone());
		 preparedStatement.setString(6,lecturerBean.getLecturerEmail());
		 preparedStatement.setString(7,lecturerBean.getLecturerId());
	              
	            status=preparedStatement.executeUpdate();  
	              
	            currentCon.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int deleteLecturer(String lecturer_id){  
	        int status=0;  
	        try{  
	        	currentCon = ConnectionManager.getConnection();
	        	String query = "delete from lecturer where lecturer_id=?"; 
		       	preparedStatement = currentCon.prepareStatement(query);
		       
		       	preparedStatement.setString(1,lecturer_id);

	            status=preparedStatement.executeUpdate();  
	              
	            currentCon.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static LecturerBean getLecturerId(String lecturer_id){  
	        LecturerBean lecturerBean=new LecturerBean();  
	          
	        try{  
	        	
	        	currentCon = ConnectionManager.getConnection();
		       	 String query = "select * from lecturer where lecturer_id=?"; 
		       	preparedStatement = currentCon.prepareStatement(query); 

		       	preparedStatement.setString(1,lecturer_id);
		       	
	            ResultSet rs=preparedStatement.executeQuery();  
	            if(rs.next()){  
	            	lecturerBean.setLecturerId(rs.getString(1));  
	            	lecturerBean.setLecturerPassword(rs.getString(2));  
	            	lecturerBean.setLecturerName(rs.getString(3));  
	            	lecturerBean.setPosition(rs.getString(4));  
	            	lecturerBean.setLecturerFaculty(rs.getString(5));  
	            	lecturerBean.setPhone(rs.getString(6));  
	            	lecturerBean.setLecturerEmail(rs.getString(7));  
	            }  
	            currentCon.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return lecturerBean;  
	    }  
	    
	    public static List<LecturerBean> getAllLecturers(){  
	        List<LecturerBean> list=new ArrayList<LecturerBean>();  
	          
	        try{  
	        	currentCon = ConnectionManager.getConnection();
		       	 String query = "select * from lecturer"; 
		       	preparedStatement = currentCon.prepareStatement(query); 
		       	ResultSet rs=preparedStatement.executeQuery();  
	            
	            while(rs.next()){  
	            	LecturerBean lecturerBean=new LecturerBean();  
	            	
	            	lecturerBean.setLecturerId(rs.getString(1));  
	            	lecturerBean.setLecturerPassword(rs.getString(2));  
	            	lecturerBean.setLecturerName(rs.getString(3));  
	            	lecturerBean.setPosition(rs.getString(4));  
	            	lecturerBean.setLecturerFaculty(rs.getString(5));  
	            	lecturerBean.setPhone(rs.getString(6));  
	            	lecturerBean.setLecturerEmail(rs.getString(7));  
	                list.add(lecturerBean);  
	            }  
	            currentCon.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
	}  
