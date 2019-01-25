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
    <title>Admin page</title>
</head>

<body>
<h1>Admin Page</h1>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<form action="UpdateLeagueOptions">
					<button type="submit" class="btn btn-primary">Refresh</button>
				</form>
			</div>
			<div class="col">
				<form action="Logout">
					<button type="submit" class="btn btn-primary">Logout</button>
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
		</div>
		<div class="row">
			<div class="col">
				<form action="SetWinner">
					<div class="form-group" style="width: 200px;">
						<label for="Option">Option ID</label> <input type="text"
							class="form-control" id="optionID" placeholder="Enter Option ID"
							name="optionID">
					</div>
					<div class="form-group">
						<label for="Team">Team Chosen:</label> <input type="text"
							class="form-control" id="teamChosen" placeholder="Enter winning team ID (1/2)"
							name="teamChosen">
					</div>
					<button type="submit" class="btn btn-primary">Purchase</button>
				</form>
			</div>
			<div class="col-fluid">
				<p>ongoing games</p>
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
			<div class="col-fluid">
				<form action="CreateGame">
					<div class="form-group" style="width: 200px;">
						<label for="oneName">Team One Name</label> <input type="text"
							class="form-control" id="teamOneName" placeholder="Enter Team One Name"
							name="teamOneName">
					</div>
					<div class="form-group" style="width: 200px;">
						<label for="oneOdds">Team One Odds</label> <input type="text"
							class="form-control" id="teamOneOdds" placeholder="Enter Team One Odds"
							name="teamOneOdds">
					</div>
					<div class="form-group" style="width: 200px;">
						<label for="twoName">Team Two Name</label> <input type="text"
							class="form-control" id="teamTwoName" placeholder="Enter Team Two Name"
							name="teamTwoName">
					</div>
					<div class="form-group" style="width: 200px;">
						<label for="twoOdds">Team Two Odds</label> <input type="text"
							class="form-control" id="teamTwoOdds" placeholder="Enter Team Two Odds"
							name="teamTwoOdds">
					</div>
					<button type="submit" class="btn btn-primary">Create Game</button>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>