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
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <!-- Optional Bootstrap theme -->
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
  	<script type="text/javascript">
		function toggleContent(a) {
  			// Get the DOM reference
  			if (a===1){
  				toggleStuff("home");
  				hide("rules");
  				hide("contact");
  			}
  			if (a===2){
  				toggleStuff("rules");
  				hide("home");
  				hide("contact");
  			}
  			if (a===3){
  				toggleStuff("contact");
  				hide("home");
  				hide("rules");
  			}
		}
		
		function toggleStuff(str){
			var contentId = document.getElementById(str);
			contentId.style.display = "block"; 
		}
		
		function hide(str){
			var contentId = document.getElementById(str);
			contentId.style.display = "none";
		}
	</script>
<title>League Casino Homepage</title>
</head>
<body>
	<h1 style="align:center;">League Prophet</h1>

	<ul id="myDIV" class="topnav">
  		<li id="navhome"><a class="kappa active" href="#home" onclick="toggleContent(1)">Home</a></li>
  		<li id="navrules"><a class="kappa" href="#rules" onclick="toggleContent(2)">Rules</a></li>
  		<li id="navcontact"><a class="kappa" href="#contact" onclick="toggleContent(3)">Contact</a></li>
  		<li class="right"><a href="Login.jsp">Login</a></li>
  		<li class="right"><a href="register.jsp">Register</a>
	</ul>
	
	<script>
		// Add active class to the current button (highlight it)
		var header = document.getElementById("myDIV");
		var btns = header.getElementsByClassName("kappa");
		for (var i = 0; i < btns.length; i++) {
  			btns[i].addEventListener("click", function() {
    		var current = document.getElementsByClassName("active");
    		current[0].className = current[0].className.replace(" active", " inactive");
			this.className += " active";
  		});
	}
	</script>

	<div id="home" style="display:block;">
		<p1>Ever wanted to gamble on full teams in a fun friendly environment? Look no further!</p1>
		<p1>Right now my focus will be league of legends because it's the best game :) </p1>
	</div>
	<div id="rules" style="display:none;">
		<p1>Use your gold to bet on games.</p1>
		<p1>Games are subjectively weighted for example if you have C9 vs Golden Guardians naturally most would say there's a 95% or more
		chance of winning. Also weighting rewards will make there more incentive to bet on an upset and will avoid just betting on "obvious" teams.</p1>
		<p1>Simple example say the one above C9 vs Golden Guardians. Say the odds are 5:1 in favor of C9.
		So payoffs will be as follows: Bet 100 on C9 and C9 wins you gain 20 gold. Bet 100 on Golden Guardians and say they somehow win
		you gain 500. </p1>
		<p1>You don't need to worry too much about the math, but in general you can divide your bet by the integer odds of your team then
		multiply the value by the integer odds of the enemy team.</p1>
	</div>
	<div id="contact" style="display:none;">
		<p1>Any questions or comments you can email me at LeagueCasino@gmail.com </p1>
	</div>
	


</body>
</html>