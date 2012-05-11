<%@page import="ie.cit.cloudapp.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="styles/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<div id="head">
		<h1>
			<b>Dream Team - Sign Up</b>
		</h1>
		<p><%=new java.util.Date()%></p>
	</div>
	<div id="menu">
		<table align="center" cellpadding="5">
			<tr>
				<td><a href="home.jsp">Home</a></td>
				<td><a href="users.html">Sign Up</a></td>
			</tr>
		</table>
	</div>
	
		<h2>Registration</h2>
		<form method="post">
		<table>
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
	<div id="form">
		<c:forEach items="${users}" var="user" varStatus="row">
			<c:choose>
			<c:when test="${user.done}">
			<del>${user.firstName}</del>
			<del>${user.surname}</del>
			<del>${user.email}</del>
			</c:when>
			<c:otherwise>
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
			</c:otherwise>
			</c:choose>
		</c:forEach>

</body>
</html>