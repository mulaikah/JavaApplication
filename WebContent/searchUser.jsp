<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br/><br/>
    <form method="post" name="frm" action="SearchServlet">
      <table border="0" width="300" align="center" bgcolor="#ee99ff">
        <tr><td colspan=2 style="font-size:12pt;" align="center">
        <h3>Search User</h3></td></tr>
        <tr><td ><b>Please enter your username 	</b></td>
          <td>: <input type="text" name="student_id" id="student_id" />
        </td></tr>      
        	
        	<tr><td ><b>Please enter your password 	</b></td>
          <td>: <input type="text" name="student_pswd" id="student_pswd" />
        </td></tr>
		
        <tr><td colspan=2 align="center">
        <input  type="submit" name="submit" value="Search"></td></tr>
      </table>
    </form>
</body>
</html>

