<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update">
		Name:<input type="text" placeholder="enter the username" name="name" value="<%=request.getParameter("name")%>"><br>
		email:<input type="text" readonly="readonly"  name="email" value="<%=request.getParameter("email")%>"><br>
		Password:<input type="password" placeholder="enter the password"
			name="password"><br> 
		<button>Submit</button>
	</form>
</body>
</html>