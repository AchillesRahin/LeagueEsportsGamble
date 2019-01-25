<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <!-- Optional Bootstrap theme -->
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
<title>Platform</title>
</head>
<body>
<div class="container">
<p>this is the platform kappa </p>
<p> Signed in as ${username}</p>

<p> Select a game below to enter </p>

</div>
<div class="container">
<a href="leagueplatform.jsp"><img src="<c:url value='/images/leaguelogo.jpg'/>" class=".img-responsive" width="400" height="300"/></a>
</div>
</body>
</html>