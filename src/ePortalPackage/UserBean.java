package ePortalPackage;

public class UserBean {
	
    private String username;
    private String password;
    private String firstname;
    private String lastname;
   // private String name;
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
//    public String getName() {
//        return name;
// 	}
//
//     public void setName(String newName) {
//        name = newName;
// 	}		

    public String getPassword() {
       return password;
	}

    public void setPassword(String newPassword) {
       password = newPassword;
	}
	
			
    public String getUsername() {
       return username;
			}

    public void setUserName(String newUsername) {
       username = newUsername;
			}

				
    public boolean isValid() {
       return valid;
	}

    public void setValid(boolean newValid) {
       valid = newValid;
	}	
}
