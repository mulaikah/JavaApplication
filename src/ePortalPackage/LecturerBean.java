package ePortalPackage;

public class LecturerBean {

	private String lecturer_id;
    private String lecturer_pswd;
    private String lecturer_name;
    private String position;
    private String lecturer_faculty;
    private String phone;
    private String lecturer_email;
    public boolean valid;
  	
    public String getLecturerId() {
        return lecturer_id;
 			}

     public void setLecturerId(String newLecturerId) {
    	 lecturer_id = newLecturerId;
 			}
     
    public String getLecturerPassword() {
        return lecturer_pswd;
 	}

     public void setLecturerPassword(String newLecturerPassword) {
    	 lecturer_pswd = newLecturerPassword;
 	}
     
     public String getLecturerName() {
         return lecturer_name;
  	}

      public void setLecturerName(String newLecturerName) {
     	 lecturer_name = newLecturerName;
  	}
      
      public String getPosition() {
          return position;
   			}

       public void setPosition(String newPosition) {
      	 position = newPosition;
   			}
      
      public String getLecturerFaculty() {
          return lecturer_faculty;
   	}
      
     public void setLecturerFaculty(String newLecturerFaculty) {
    	 lecturer_faculty = newLecturerFaculty;
 	}
 	
     public String getPhone() {
  		return phone;
  	}

  	public void setPhone(String newPhone) {
  		phone = newPhone;
  	}
      
 	public String getLecturerEmail() {
        return lecturer_email;
 	}

     public void setLecturerEmail(String newLecturerEmail) {
    	 lecturer_email = newLecturerEmail;
 	}
 	
     public boolean isValid() {
         return valid;
  	}

      public void setValid(boolean newValid) {
         valid = newValid;
  	}	
   
}
