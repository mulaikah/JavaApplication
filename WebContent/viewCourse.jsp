<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="ePortalPackage.CourseBean"%>

<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="ePortalPackage.CourseDao"%>
<%@ page import="ePortalPackage.ConnectionManager"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

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
			<td>COURSE LIST</td>
		</tr>
	</table>

<%  
List<CourseBean> list=CourseDao.getAllCourses();  
request.setAttribute("list",list);  
%>  
	<table class="courseDetails">

		<tr>
			<th>Course Id</th>
			<th>Course Name</th>
			<th>Credit Hour</th>
			<th>Group</th>
			<th>Edit</th>
			<th>Delete</th>

		</tr>
		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.getCourseId()}</td>
				<td>${u.getCourseName()}</td>
				<td>${u.getCreditHour()}</td>
				<td>${u.getClassGroup()}</td>
				<td><a href="EditCourseServlet?course_id=${u.getCourseId()}">Edit</a></td>
				<td><a href="DeleteCourseServlet?course_id=${u.getCourseId()}">Delete</a></td>
			</tr>
		</c:forEach>

	</table>

	<br />
	<br />
	<table class="button">
		<tr>
			<td><a href="addCourse.html">Add New Course</a></td>
		</tr>
	</table>
	<br />
	<table class="button">
		<tr>
			<td><a href="lecturerLogged.jsp">Back</a></td>
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

