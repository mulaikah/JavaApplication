package ePortalPackage;

import java.util.*;  
import java.sql.*; 

public class CourseDao {

   static Connection currentCon = null;
	 static PreparedStatement preparedStatement = null;
	 
	 public static int saveCourse (CourseBean courseBean){
		int status=0; 
		
	 try
	 {
	 currentCon = ConnectionManager.getConnection();
	 String query = "insert into course(course_id, course_name, credit_hour, classGroup) values (?,?,?,?)"; 
	 preparedStatement = currentCon.prepareStatement(query); 
	 preparedStatement.setInt(1,courseBean.getCourseId());
	 preparedStatement.setString(2,courseBean.getCourseName());
	 preparedStatement.setInt(3,courseBean.getCreditHour());
	 preparedStatement.setString(4,courseBean.getClassGroup());
	 
	 status=preparedStatement.executeUpdate();  

	 currentCon.close();  
 }catch(Exception ex){ex.printStackTrace();}  
   
 return status;  
}  	
	    public static int updateCourse(CourseBean courseBean){  
	    	 int status=0;  

	        try{  
	        	
	        currentCon = ConnectionManager.getConnection();
	       	 String query = "update course set course_name=?, credit_hour=?,classGroup=? where course_id=?"; 
	       	preparedStatement = currentCon.prepareStatement(query); 
	   	 preparedStatement.setString(1,courseBean.getCourseName());
		 preparedStatement.setInt(2,courseBean.getCreditHour());
		 preparedStatement.setString(3,courseBean.getClassGroup());
		 preparedStatement.setInt(4,courseBean.getCourseId());
	              
	            status=preparedStatement.executeUpdate();  
	              
	            currentCon.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int deleteCourse(int course_id){  
	        int status=0;  
	        try{  
	        	currentCon = ConnectionManager.getConnection();
	        	String query = "delete from course where course_id=?"; 
		       	preparedStatement = currentCon.prepareStatement(query);
		       
		       	preparedStatement.setInt(1,course_id);

	            status=preparedStatement.executeUpdate();  
	              
	            currentCon.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static CourseBean getCourseId(String course_id){  
	        CourseBean courseBean=new CourseBean();  
	          
	        try{  
	        	
	        	currentCon = ConnectionManager.getConnection();
		       	 String query = "select * from course where course_id=?"; 
		       	preparedStatement = currentCon.prepareStatement(query); 

		       	preparedStatement.setString(1,course_id);
		       	
	            ResultSet rs=preparedStatement.executeQuery();  
	            if(rs.next()){  
	            	courseBean.setCourseId(rs.getInt(1));  
	            	courseBean.setCourseName(rs.getString(2));  
	            	courseBean.setCreditHour(rs.getInt(3));  
	            	courseBean.setClassGroup(rs.getString(4));  
	            }  
	            currentCon.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return courseBean;  
	    }  
	    public static List<CourseBean> getAllCourses(){  
	        List<CourseBean> list=new ArrayList<CourseBean>();  
	          
	        try{  
	        	currentCon = ConnectionManager.getConnection();
		       	 String query = "select * from course"; 
		       	preparedStatement = currentCon.prepareStatement(query); 
		       	ResultSet rs=preparedStatement.executeQuery();  
	            
	            while(rs.next()){  
	            	CourseBean courseBean=new CourseBean();  
	            	
	            	courseBean.setCourseId(rs.getInt(1));  
	            	courseBean.setCourseName(rs.getString(2));  
	            	courseBean.setCreditHour(rs.getInt(3));  
	            	courseBean.setClassGroup(rs.getString(4));  
	                list.add(courseBean);  
	            }  
	            currentCon.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
	}  
