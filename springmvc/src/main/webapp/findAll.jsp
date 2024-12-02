<%@page import="springmvc.dto.StudentDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find All</title>
</head>
<body>
<% List<StudentDto> dtos=(List<StudentDto>) request.getAttribute("obj"); %>
	<table border="3px" cellpadding="5px" cellspacing="3px">
		<tr>
			<th>Email</th>
			<th>name</th>
			<th>Password</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<%
		if (dtos != null) {
		%>
		<%
		for (StudentDto st : dtos) {	
		%>

		<tr>
			<td><%=st.getEmail()%></td>
			<td><%=st.getName()%></td>
			<td><%=st.getPassword()%></td>
			 <td><a href="did?email=<%=st.getEmail()%>">Delete</a></td>
			<td><a
				href="update.jsp?email=<%=st.getEmail()%>&&name=<%=st.getName()%>&&password<%=st.getPassword()%>">Edit</a>
			</td> 
		</tr>
		<%
		}
		%>
		<tr>
			<td colspan="5"><a href="deleteAll"><button>delete</button></a></td>
		</tr>
		<%
		} else {
		%>
		<tr>
			<td colspan="5"><center>No Data Found</center></td>
		</tr>

		<%
		}
		%>
	</table>


</body>
</html>