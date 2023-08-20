<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%
		String fare = request.getParameter("fare");
		String pnr =  request.getParameter("pnr");
		%>
		<h1>Your Ticket Booking is Successfull</h1>
		<h2>
			Your total fare :<%=fare%></h2>
		<h2>
			Your Pnr Number :<%=pnr%></h2>
	</center>
</body>
</html>