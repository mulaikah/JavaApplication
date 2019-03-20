package ePortalPackage;

public class StudentBean {

	private String student_id;
    private String student_pswd;
    private String firstname;
    private String lastname;
    private String address;
    private String faculty;
    private String programme;
    private int phone;
    private String email;
    public boolean valid;
  	
    public String getFirstName() {
       return firstname;
	}

    public void setFirstName(String newFirstName) {
    	firstname = newFirstName;
	}

	
    public String getLastName() {
       return lastname;
			}

    public void setLastName(String newLastName) {
    	lastname = newLastName;
			}
			

    public String getStudentPassword() {
       return student_pswd;
	}

    public void setStudentPassword(String newStudentPassword) {
    	student_pswd = newStudentPassword;
	}
	
			
    public String getStudentId() {
       return student_id;
			}

    public void setStudentId(String newStudentId) {
    	student_id = newStudentId;
			}

    public String getAddress() {
        return address;
 	}

     public void setAddress(String newAddress) {
    	 address = newAddress;
 	}
 	
     public String getFaculty() {
        return faculty;
 			}

     public void setFaculty(String newFaculty) {
    	 faculty = newFaculty;
 			}
 			

     public String getProgramme() {
        return programme;
 	}

     public void setProgramme(String newProgramme) {
        programme = newProgramme;
 	}
 	
 			
     public int getPhone() {
 		return phone;
 	}

 	public void setPhone(int newPhone) {
 		phone = newPhone;
 	}
 	
 	public String getEmail() {
        return email;
 	}

     public void setEmail(String newEmail) {
        email = newEmail;
 	}
 	
     public boolean isValid() {
         return valid;
  	}

      public void setValid(boolean newValid) {
         valid = newValid;
  	}	
   
}
