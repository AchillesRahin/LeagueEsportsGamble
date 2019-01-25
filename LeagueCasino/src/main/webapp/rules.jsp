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
  		<li id="navhome"><a class="kappa" href="leagueplatform.jsp">Platform</a></li>
  		<li id="betoptions"><a class="kappa" href="betoptions.jsp">My Bets</a>
  		<li id="navrules"><a class="kappa active" href="rules.jsp">Rules</a></li>
  		<li class="right"><a href="Logout">Logout</a></li>
  		<li id="highscores" class="right"><a class="kappa" href="highscores.jsp">High Scores</a></li>
  		<li id="navcontact" class="right" ><a class="kappa" href="contact.jsp">Contact</a></li>
	</ul>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<p>Use your gold to bet on games.</p>
				<p>Games are subjectively weighted for example if you have C9 vs Golden Guardians naturally most would say there's a 95% or more
				chance of winning. Also weighting rewards will make there more incentive to bet on an upset and will avoid just betting on "obvious" teams.</p>
				<p>Simple example say the one above C9 vs Golden Guardians. Say the odds are 5:1 in favor of C9.
				So payoffs will be as follows: Bet 100 on C9 and C9 wins you gain 20 gold. Bet 100 on Golden Guardians and say they somehow win
				you gain 500.
				<p>You don't need to worry too much about the math, but in general you can divide your bet by the integer odds of your team then
				multiply the value by the integer odds of the enemy team.</p>
			</div>
		</div>
	</div>
</body>
</html>