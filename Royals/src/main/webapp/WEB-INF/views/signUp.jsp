<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Responsive meta tag -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text\html" charset="UTF-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap js -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Font Awesome  -->
<script src="https://kit.fontawesome.com/5069618204.js"
	crossorigin="anonymous"></script>
<title>Royals</title>
<!-- Adding CSS to this JSP file -->
<!-- home.css added so that we can get same page as login page -->
<style>
<%@include file="/WEB-INF/views/home.css"%>
<%@include file="/WEB-INF/views/signUp.css"%>
</style>
<!-- JSTL -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- GOOGLE FONT -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Sofia">
</head>
<body>
	<!-- header file -->
	<%@ include file="header.jsp" %>
	<div class="firstbox">
		<div class="box1">
			<div class="logobox">
				<img class="mainBoxLogo"
					src="<%=request.getContextPath()%>/images/royalcrownNobg.jpg"
					width="30" height="30" alt="Royals">
			</div>
			<div class="signup">
				<div class="sign-up-matter">
					<h3 class="title">Royal Restaurants</h3>
				</div>
				<form:form class="signup-form" action="verifySignUpDetails" method="Post"
					modelAttribute="signUpMA">
					<table>
						<tr>
							<td><label>Name</label></td>
							<td><form:input path="name" class="signup-input" placeholder="enter your name..." required="true"/></td>
						</tr>
						<tr>
							<td><label>Email</label></td>
							<td><form:input type="email" class="signup-input" path="email" placeholder="enter your email..."/></td>
						</tr>
						<tr>
							<td><label>PhoneNumber</label></td>
							<td><form:input class="signup-input" type="number" path="phoneNumber" placeholder="enter your phonenumber..." required="true"/></td>
						</tr>
						<tr>
							<td colspan="2"><form:checkbox class="agreeMessagesBox" path="agreeMessages" label="I Agree that Royals can send me messages" required="true"/></td>
						</tr>
					</table>
					<!-- This is used to submit the page -->
					<a href="verifySignUpDetails"><button class="verifyPhone-btn">Verify Phone Number</button></a>
					<span class="errormessage">
						<spring:hasBindErrors name="signUpMA">
							<form:errors path="*" cssClass="errormessage"/>
						</spring:hasBindErrors>
					</span>
				</form:form>
				<div class="signup-others">
					<span class="errormessage">${errormessage}</span>
					<p class="othersText2">Already have an account with US?</p>
					<a href="home"><button class="login-btn">login Here!</button></a>
				</div>
			</div>
		</div>
		<div class="box2">
		<img class="maincraving" src="<%=request.getContextPath()%>/images/cravingMain.jpg" 
			width="30" height="30" alt="maincraving">
		</div>
	</div>
	<div class="secondbox">
		<!-- Carousel -->
		<%@ include file="carousel.jsp" %>
	</div>
	<!-- footer.jsp -->
	<%@ include file="footer.jsp" %>
</body>
</html>