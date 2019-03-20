<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="ePortalPackage.StudentBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
	<link rel="stylesheet" type="text/css" href="default.css">
<title>ePortal | University Of Mulaikah</title>
</head>

<body>
	<table class="header">
		<tr>
			<td align="center"><img src="images/banner6.png" width="800"
				height="200"></td>
			<td class="headertext"><p>
					<strong>ePortal</strong>
				</p></td>
		</tr>
	</table>

	<jsp:include page="navbar.jsp"></jsp:include>
	
	<table class="contentcolor">
		<tr>
	<td >INFORMATION DETAILS</td>
	</tr>
	</table>

	<table class="details" >
	<%
			StudentBean currentUser = ((StudentBean) (session.getAttribute("currentSessionUser")));
		%>

		<tr>
			<td>Full Name :</td>
			<td><%=currentUser.getFirstName() + " " + currentUser.getLastName()%></td>
		</tr>
		<tr>
			<td>Address :</td>
			<td><%=currentUser.getAddress() + " " %></td>
		</tr>
		<tr>
			<td>Faculty :</td>
			<td><%=currentUser.getFaculty() + " " %></td>
		</tr>
		<tr>
			<td>Program :</td>
			<td><%=currentUser.getProgramme() + " " %></td>
		</tr>
		<tr>
			<td>Phone :</td>
			<td><%=currentUser.getPhone() + " " %></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><%=currentUser.getEmail() + " "%></td>
		</tr>

	</table>

<table class="contentcolor">
		<tr>
	<td >REGISTERED COURSES</td>
	</tr>
	</table>
	


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


</head>


