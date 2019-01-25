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
<title>Register</title>
</head>
<body>

<div class="container">
  <h2>Register</h2>
  <form action="RegistrationServlet">
    <div class="form-group">
      <label for="username">Username:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter username" name="username">
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    <div class="form-group">
      <label for="confirmpwd">Confirm Password:</label>
      <input type="password" class="form-control" id="confirmpwd" placeholder="Confirm password" name="confirmpwd">
    </div>
    <button type="submit" class="btn btn-primary">Register</button>
    <a href="index.jsp" class="btn btn-primary">Home</a>
  </form>
  <p style="color:red">${errorMessageRegister}</p>
</div>

</body>
</html>