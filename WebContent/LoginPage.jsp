<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
                                <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Login Page</title>
	</head>

	<body>
	<table class="header">
	<tr>
		<td align="center">
			<img src="images/banner6.png" width="800" height="200">
		</td>
	</tr>
</table>


	<form action="LoginServlet">

			Please enter your username 		
			<input type="text" name="username"/><br>		
		
			Please enter your password
			<input type="text" name="password"/>
			
			<input type="submit" value="submit">			
		
		</form>
 
<table class="footer">
	<tr>
		<td align="center">
<div><p>&copy; 2019 ePortal. All Rights Reserved. | Designed by University of Mulaikah</p></div>	
		</td>
	</tr>
</table>
	
		
	</body>
</html>