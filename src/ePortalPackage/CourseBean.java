package ePortalPackage;

public class CourseBean {
	
	private int course_id;
    private String course_name;
    private int credit_hour;
    private String classGroup;
  	
    public int getCourseId() {
       return course_id;
	}

    public void setCourseId(int newCourseId) {
    	course_id = newCourseId;
	}

    public String getCourseName() {
        return course_name;
 	}

     public void setCourseName(String newCourseName) {
    	 course_name = newCourseName;
 	}
     
     public int getCreditHour() {
         return credit_hour;
  	}

      public void setCreditHour(int newCreditHour) {
    	  credit_hour = newCreditHour;
  	}

       public String getClassGroup() {
           return classGroup;
    	}

        public void setClassGroup(String newClassGroup) {
        	classGroup = newClassGroup;
    	}
}
