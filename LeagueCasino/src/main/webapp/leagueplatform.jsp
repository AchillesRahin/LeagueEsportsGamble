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
<title>League Platform</title>

<style>
body {margin: 0;}

ul.topnav {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

ul.topnav li {float: left;}

ul.topnav li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

ul.topnav li a:hover:not(.active) {background-color: #111;}

ul.topnav li a.active {background-color: #4CAF50;}

ul.topnav li.right {float: right;}

@media screen and (max-width: 600px){
    ul.topnav li.right, 
    ul.topnav li {float: none;}
}
</style>

</head>

<body>
	<div class="cotainer-fluid">
		<div class="row">
			<div class="col">
				<h1>League Prophet</h1>
			</div>
			<div class="col">
				<h4 style="text-align:right">Signed in as ${username}</h4>
			</div>
		</div>
	</div>


	<ul id="myDIV" class="topnav">
  		<li id="navhome"><a class="kappa active" href="leagueplatform.jsp">Platform</a></li>
  		<li id="betoptions"><a class="kappa" href="betoptions.jsp">My Bets</a>
  		<li id="navrules"><a class="kappa" href="rules.jsp">Rules</a></li>
  		<li class="right"><a href="Logout">Logout</a></li>
  		<li id="highscores" class="right"><a class="kappa" href="highscores.jsp">High Scores</a></li>
  		<li id="navcontact" class="right" ><a class="kappa" href="contact.jsp">Contact</a></li>
	</ul>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<p>Gold: ${money}</p>
				<form action="UpdateLeagueOptions">
					<button type="submit" class="btn btn-primary">Refresh</button>
				</form>
			</div>
			<div class="col">
			</div>
			<div class="col">
			</div>
			<div class="col">
			</div>
			<div class="col">
			</div>
			<div class="col">
			</div>
		</div>
		<div class="row">
			<div class="col">
				<form action="BuyOption">
					<div class="form-group" style="width: 200px;">
						<label for="Option">Option ID</label> <input type="text"
							class="form-control" id="optionID" placeholder="Enter Option ID"
							name="optionID">
					</div>
					<div class="form-group">
						<label for="Team">Team Chosen:</label> <input type="text"
							class="form-control" id="teamChosen" placeholder="Pick which team will win (1/2)"
							name="teamChosen">
					</div>
					<div class="form-group">
						<label for="Amount">Risk:</label> <input type="text"
							class="form-control" id="amountBet" placeholder="How much you want to risk"
							name="amountBet">
					</div>
					<button type="submit" class="btn btn-primary">Purchase</button>
				</form>
			</div>
			<div class="col-fluid">
				<table>
					<tr>
						<th colspan="5">Options</th>
					</tr>
					<tr>
						<th class="border">ID</th>
						<th class="border">TeamOne</th>
						<th class="border">PointsOne</th>
						<th class="border">TeamTwo</th>
						<th class="border">PointsTwo</th>
					</tr>
					<c:forEach var="tradingoption" items="${tradingOptions }">
						<tr>
							<td>${tradingoption.getLeagueOptionID() }</td>
							<td>${tradingoption.getTeamOne() }</td>
							<td>${tradingoption.getOnePoints() }</td>
							<td>${tradingoption.getTeamTwo() }</td>
							<td>${tradingoption.getTwoPoints() }</td>
							<td></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col"></div>
		</div>
	</div>


</body>
</html>