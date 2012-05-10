<%@page import="ie.cit.cloudapp.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
<jsp:useBean id="repo" class="ie.cit.cloudapp.UserRepository" scope="application"></jsp:useBean>
	<div id="head">
		<h1>
			<b>The Chronicle - Sign Up</b>
		</h1>
		<p><%=new java.util.Date()%></p>
	</div>
	<div id="menu">
		<table align="center" cellpadding="5">
			<tr>
				<td><a href="main.jsp">Home</a></td>
				<td><a href="news.jsp">News</a></td>
				<td><a href="signUp.jsp">Sign Up</a></td>
				<td><a href="reviews.jsp">Reviews</a></td>
			</tr>
		</table>
	</div>
	<div id="form">
		<c:if test="${(! empty param.firstName) && (! empty param.surname) && (! empty param.email) }"> 
			<%
				User user = new User();
				user.setFirstName(request.getParameter("firstName"));
				user.setSurname(request.getParameter("surname"));
				user.setEmail(request.getParameter("email"));
				repo.addUser(user);
			%>

		</c:if>

		<c:forEach items="${repo.users}" var="user">
			<table border=1>
				<tr>
					<td>First Name</td>
					<td>Surname</td>
					<td>Email</td>
				</tr>
				<tr>
					<td>${user.firstName}</td>
					<td>${user.surname}</td>
					<td>${user.email}</td>
				</tr>
			</table>
		</c:forEach>
		<h2>Registration</h2>
		<table>
			<form>
				<tr>
					<td>First Name:</td>
					<td><input name="firstName"></td>
				</tr>
				<tr>
					<td>Surname:</td>
					<td><input name="surname"></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input name="email"></td>
				</tr>
				<tr>
					<td><input type="submit"></td>
				</tr>
		</table>
		</form>
	</div>

</body>
</html>