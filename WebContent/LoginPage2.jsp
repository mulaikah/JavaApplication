<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<link rel="stylesheet" type="text/css" href="default.css">
                                <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>ePortal | University Of Mulaikah</title>
</head>

<body>
	<table class="header">
		<tr>
			<td align="center"><img src="images/banner6.png" width="800"
				height="200"></td>
				<td class="headertext"><p><strong>ePortal</strong></p>
		</td>
		</tr>
	</table>
	
<%-- 	<jsp:include page="navbar.jsp"></jsp:include> --%>

	<div id="info" align="center">
		<h1>Login</h1>
		<br /> <br /> <br /> <br /> <br /> 


		<form action="LoginServlet2">

			<table cellpadding="4" cellspacing="1">
				<tr>
					<td>Please enter your student ID :</td>
					<td><input type="text" name="student_id" /></td>
				</tr>
				<tr>
					<td>Please enter your password   :</td>
					<td><input type="password" name="student_pswd" /></td>
				</tr>

				<tr>
					<td align="right"><input type="submit" value="Submit" />
				</tr>
			</table>
		</form>
	</div>

	<br />
	<br />
	<br />
	<br />
	<br /> 
	<br /> 
	<table class="footer">
		<tr>
			<td align="center">
				<p class="legal">&copy; 20109 ePortal Student. All Rights
					Reserved. | Designed by University Of Mulaikah</p>
			</td>
		</tr>
	</table>


</body>
</html>