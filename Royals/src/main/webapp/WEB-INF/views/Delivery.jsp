<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text\html" charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>Royals Main Page</title>
<!-- Responsive meta tag -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Font Awesome  -->
<script src="https://kit.fontawesome.com/5069618204.js" crossorigin="anonymous"></script>
<title>Delivery Page</title>

<style type="text/css">
	<%@include file="/WEB-INF/views/delivery.css"%>
</style>
</head>
<body>
	<header>
		<%@include file="mainPageHeader.jsp" %>
	</header>
	<div class="middle">
		<div class="section1">
			<div class="table1">
				<form:form action="AddDeliveryAddress" method="GET" modelAttribute="Delivery">
					<h5 class="head">Fill Here to Add Address</h5>
					<table>
						<tr>
							<td class="left">Door No.</td>
							<td class="right"><form:input class="right" path="doorNo" required="true"/></td>
						</tr>
						<tr>
							<td class="left">Street/LandMark</td>
							<td class="right"><form:input class="right" path="street" required="true"/></td>
						</tr>
						<tr>
							<td class="left">city Area and other Details</td>
							<td class="right"><form:input class="right" path="city" required="true"/></td>
						</tr>
						<tr>
							<td class="left">PinCode</td>
							<td class="right"><form:input class="right" path="pincode" required="true"/></td>
						</tr>
					</table>
					<input class="sub" type="submit" value="Add Address">
				</form:form>
				<div class="successmessage">${successmessage}</div>
				<div class="failuremessage">${failuremessage}</div>
			</div>
		</div>
		<div class="section2">
			<div class="section2Data">
				<div class="heading"><h5>All Addresses</h5></div>
				<div class="message">
				${listMessage1}</div>
				<div class="message">
				${listMessage2}</div>
				<c:forEach items="${allAddressList}" varStatus="i" var="item">
					<div id="${i.index}" class="addressItem">
						<div class="${i.index}"  onclick="func1(${i.index})" name="abc">${item}</div>
						<button class="button setprimary" onclick="set(${i.index},this)">Set Primary</button>
						<button class="button" onclick="func(${i.index})">Remove Address</button>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<footer>
		<%@include file="mainfooter.jsp" %>
		<spring:url value="js/delivery.js" var="deliveryJs"/>
<script src="<c:url value='/js/delivery.js' />"></script>
	</footer>
</body>
</html>