<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Royals Main Page</title>
<!-- Responsive meta tag -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text\html" charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Font Awesome  -->
<script src="https://kit.fontawesome.com/5069618204.js" crossorigin="anonymous"></script>
<title>Royals</title>
<!-- Adding CSS to this JSP file -->
<style>
<%@include file="/WEB-INF/views/mainPageHeader.css"%>
</style>
</head>
<body>
<header>
		<div class="navbar">
			<div class="logo">
				<div class="logo-brand">
					<a href="<%=request.getContextPath()%>/${userId}/main"><img alt="royal-logo" src="<%=request.getContextPath()%>/images/logo3.jpg" width="300" height="62"></a>
				</div>
			</div>
			<div class="types">
				<div class="types1">
					<a href="<%=request.getContextPath()%>/${userId}/main" class="items">Refreshments</a>
					<a href="<%=request.getContextPath()%>/${userId}/main" class="items">Biryani</a>
					<a href="<%=request.getContextPath()%>/${userId}/main" class="items">Breakfast</a>
					<a href="<%=request.getContextPath()%>/${userId}/main" class="items">Lunch</a>
					<a href="<%=request.getContextPath()%>/${userId}/main" class="items">Dinner</a>
				</div>
				<div class="types2">
					<a href="<%=request.getContextPath()%>/${userId}/main" class="items">Desserts</a>
					<a href="<%=request.getContextPath()%>/${userId}/main" class="items">BBQ</a>
					<a href="<%=request.getContextPath()%>/${userId}/main" class="items">Royals Specials</a>
				</div>
			</div>
			<div class="rightSide">
				<div class="cart">
					<div><p class="cart-total">${itemsInCart}</p></div>
					<div><a href="<%=request.getContextPath()%>/cart"><i class="fa-solid fa-cart-shopping" style="color: #fbff00;"></i></a></div>
					
				</div>
				<div class="dropdownaccount">
					<ul class="nav nav-pills">
					  <li class="nav-item dropdown">
					    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" 
					    href="#" style="color:rgb(255, 255, 102);"><i class="fa-solid fa-user userIcon" style="color: #fff700;"></i>${username}</a>
					    <ul class="dropdown-menu" style="background-color:black;width: 190.727273px;margin-left: 40px;">
					      <li><a class="dropdown-item" href="<%=request.getContextPath()%>/accountDetails">Account Details</a></li>
					      <li><a class="dropdown-item" href="#">History</a></li>
					      <li><a class="dropdown-item" href="<%=request.getContextPath()%>/delivery">Delivery Address</a></li>
					      <li><hr class="dropdown-divider" style="background-color:white;"></li>
      					  <li><a class="itemlast" href="<%=request.getContextPath()%>/logout">Logout</a></li>
					    </ul>
					  </li>
					 </ul>
				</div>
			</div>
		</div>
	</header>
</body>
</html>