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
<%@include file="/WEB-INF/views/verifySignUp.css"%>
</style>
<!-- JSTL -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- GOOGLE FONT -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Sofia">
</head>
<body>
	<!-- header page -->
	<%@include file="header.jsp"%>
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
				<form:form class="signup-form" action="sendOtp" method="Post"
					modelAttribute="signUpDetails">
					<table>
						<tr>
							<td><form:input class="signup-input" path="phoneNumber" placeholder="enter your phonenumber..." disabled="true"/></td>
							<td><a href="sendOtp"><form:button class="otpButton">Get OTP!</form:button></a></td>
						</tr>
					</table>
				</form:form>
				<!-- this form is used to check otp of user with our otp -->
				<form:form class="signup-form2" action="verifyOtp" method="Post"
					modelAttribute="otpValidation">
					<table>
						<tr>
							<td><form:input class="signup-input" path="userOtp" placeholder="Enter your six DIGIT OTP..."/></td>
							<td><a href="verifyOtp"><form:button class="verifyOtpButton">Verify OTP!</form:button></a></td>
						</tr>
					</table>
				</form:form>
				<div class="signup-others">
					<span class="errormessage">${errormessage}</span><span class="successmessage">${successmessage}</span>
					<a href="signUp"><button class="login-btn">Go Back!</button></a>
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
	<!-- Footer page -->
	<%@ include file="footer.jsp" %>
</body>
</html>