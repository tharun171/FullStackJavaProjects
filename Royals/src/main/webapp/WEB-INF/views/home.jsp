<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Responsive meta tag -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text\html" charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Font Awesome  -->
<script src="https://kit.fontawesome.com/5069618204.js" crossorigin="anonymous"></script>
<title>Royals</title>
<!-- Adding CSS to this JSP file -->
<style>
<%@include file="/WEB-INF/views/home.css"%>
</style>
<!-- JSTL -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- GOOGLE FONT -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
</head>
<body>
<header>
	<nav class="navbar navbar-light" style="background-color:rgb(210, 166, 121);">
		<a class="navbar-brand" href="#">
    		<img class="nav-logo" src="<%=request.getContextPath()%>/images/royalcrown.jpg" width="30" height="30" alt="Royals">
  		</a>
	</nav>
</header>
<div class="firstbox">
	<div class="box1">
		<div class="logobox">
			<img class="mainBoxLogo" src="<%=request.getContextPath()%>/images/royalcrownNobg.jpg" 
			width="30" height="30" alt="Royals">
		</div>
		<div class="signup">
			<div class="matter">
				<h3 class="title">Royal Restaurants</h3>
			</div>
			<form:form class="form" action="phonenumberOtpCheck" method="Post" modelAttribute="loginBean">
					<div>
						<form:input class="phonenumber" path="phoneNumber" placeholder="Enter 10 DIGIT Registered mobile number..." required="true"/>
					</div>
					<div>
						<form:button class="otpButton">Get OTP!</form:button>
					</div>
			</form:form>
			<form:form class="form1" action="otpCheck" method="Post" modelAttribute="otpBean">
					<div>
						<form:input class="otpCheck" path="otpCheck" placeholder="Enter 6 DIGIT OTP here..." required="true"/>
					</div>
					<div>
						<form:button class="verifyOtpButton">Verify !</form:button>
					</div>
					
			</form:form>
			<div class="others">
			<span class="errormessage">
					<spring:hasBindErrors name="otpBean">
						<form:errors path="*" cssClass="errormessage"/>
					</spring:hasBindErrors>
				</span>
				<span class="errormessage">${errormessage}</span>
				<span class="successmessage">${successmessage}</span>
				<p class="othersText1">Don't have an account with US?</p>
				<p class="othersText2">Create One!</p>
				<a href="signUp"><button class="signup-btn">Sign Up</button></a>
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
	<div id="demo" class="carousel slide" data-bs-ride="carousel" >
 		<!-- Indicators/dots -->
  			<div class="carousel-indicators">
			    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
			    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
			    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
  			</div>
  		<!-- The slideshow/carousel -->
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="<%=request.getContextPath()%>/images/deliveryavail.jpg" alt="delivery available" class="d-block carousel-images">
		      <div class="carousel-caption">
		        <h3 class="carousel-htext">Home delivery</h3>
		        <p class="carousel-ptext">Get food at your doorstep!</p>
		      </div>
		    </div>
    		<div class="carousel-item">
			      <img src="<%=request.getContextPath()%>/images/pic2modify.jpeg" alt="Chicago" class="d-block carousel-images">
			      <div class="carousel-caption">
			        <!-- <h3 class="carousel-htext">Chicago</h3>  -->
			        <!-- <p class="carousel-ptext">Thank you, Chicago!</p>  -->
			      </div> 
    		</div>
		    <div class="carousel-item">
		      <img src="<%=request.getContextPath()%>/images/pic3.jpeg" alt="New York" class="d-block carousel-images">
		      <div class="carousel-caption">
		        <h3 class="carousel-htext" style="color:black;">BBQ Every Wednesday</h3>
		        <p class="carousel-ptext" style="color:black;">At Rs 599+Taxes!</p>
		      </div>  
		    </div>
  		</div>
  		<!-- Left and right controls/icons -->
	  	<button class="carousel-control-prev carousel-buttons" type="button" data-bs-target="#demo" data-bs-slide="prev">
	    	<span class="carousel-control-prev-icon"></span>
	  	</button>
	  	<button class="carousel-control-next carousel-buttons" type="button" data-bs-target="#demo" data-bs-slide="next">
	    	<span class="carousel-control-next-icon"></span>
	 	</button>
	</div>
</div>
<footer>
	<div class="footer-block">
			<p class="footer-matter">Royal Restaurants 2023 <i id="icon" class="fa-regular fa-copyright"></i></p>
			<p class="footer-matter"><a class="footer-matter" href="mailto:RoyalsResto@gmail.com?subject=Feedback%20To%20RoyalResto%20on">Click envelope to email us <i id="icon" class="fa-solid fa-envelope" style="color: #ffffff;"></i></a></p>
			<p class="footer-matter"><i id="icon" class="fa-solid fa-phone" style="color: #0558ff;"></i> +91 9638527412</p>
	</div>
</footer>
</body>
</html>