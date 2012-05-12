<%@page import="ie.cit.cloudapp.Player" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="styles/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dream Team</title>
</head>
<body>
<div id="head">
<h1>Dream Team (Controller)</h1>
<p><%= new java.util.Date()%></p>

<a href="j_spring_security_logout">Logout: <security:authentication property="principal.username"/></a>
</div>

<form method="post">
		<table border=1>
			<tr>
				<th>Team Name:</th>
				<th><input name="name"></th>
			</tr>
			<tr>
				<td>Goalkeeper:</td>
				<td><input name="gk"></td>
			</tr>
			<tr>
				<td>Right Back:</td>
				<td><input name="rb"></td>
			</tr>
			<tr>
				<td>Centre back:</td>
				<td><input name="cb1"></td>
			</tr>
			<tr>
				<td>Centre back:</td>
				<td><input name="cb2"></td>
			</tr>
			<tr>
				<td>Left back:</td>
				<td><input name="lb"></td>
			</tr>
			<tr>
				<td>Right Wing:</td>
				<td><input name="rw"></td>
			</tr>
			<tr>
				<td>Centre Midfield:</td>
				<td><input name="cm1"></td>
			</tr>
			<tr>
				<td>Centre Midfield:</td>
				<td><input name="cm2"></td>
			</tr>
			<tr>
				<td>Left Wing:</td>
				<td><input name="lw"></td>
			</tr>
			<tr>
				<td>Striker:</td>
				<td><input name="st1"></td>
			</tr>
			<tr>
				<td>Striker:</td>
				<td><input name="st2"></td>
			</tr>

			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>

	</form>
	

	<c:forEach items="${players}" var="player" varStatus="row">
		<c:choose>
			<c:when test="${player.done}">
				<del>${players.name}</del>
				<del>${players.gk}</del>
				<del>${players.rb}</del>
				<del>${players.cb1}</del>
				<del>${players.cb2}</del>
				<del>${players.lb}</del>
				<del>${players.rw}</del>
				<del>${players.cm1}</del>
				<del>${players.cm2}</del>
				<del>${players.lw}</del>
				<del>${players.st1}</del>
				<del>${players.st2}</del>
			</c:when>
			<c:otherwise>
				<table border=1 align="center">
					<tr>
						<th>Team Name:</th>
						<td>${player.name}</td>
					</tr>
					<tr>
						<th>Goalkeeper</th>
					</tr>
					<tr>
						<td>${player.gk}</td>
					</tr>
					<tr>
						<th>Right-Back</th>
						<th>Centre Back</th>
						<th>Centre Back</th>
						<th>Left-Back</th>
					</tr>
					<tr>
						<td>${player.rb}</td>
						<td>${player.cb1}</td>
						<td>${player.cb2}</td>
						<td>${player.lb}</td>
					</tr>
					<tr>
						<th>Right Wing</th>
						<th>Centre Mid</th>
						<th>Centre Mid</th>
						<th>Left Wing</th>
					</tr>
					<tr>
						<td>${player.rw}</td>
						<td>${player.cm1}</td>
						<td>${player.cm2}</td>
						<td>${player.lw}</td>
					</tr>
					<tr>
						<th>Striker</th>
						<th>Striker</th>
					</tr>
					<tr>
						<td>${player.st1}</td>
						<td>${player.st2}</td>
					</tr>
					<tr>
						<td>
							<form method="post">
								<input name="_method" type="hidden" value="delete"> <input
									name="playerId" type="hidden" value="${player.id }"> <input
									type="submit" value="Delete">
							</form>
						</td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<div id="footer">
	<p>
		Copyright (C) 2012 dreamTeam.com. All rights reserved
	</p>
	
	</div>

	
</body>
</html>