<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
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

<title>Royals</title>
<!-- Adding CSS to this JSP file -->
<style>
<%@include file="/WEB-INF/views/mainPage.css"%>
</style>
</head>
<body onload="newOne()">
	<header>
		<div class="navbar">
			<div class="logo">
				<div class="logo-brand">
					<a href="<%=request.getContextPath()%>/${userId}/main"><img alt="royal-logo" src="<%=request.getContextPath()%>/images/logo3.jpg" width="300" height="62"></a>
				</div>
			</div>
			<div class="types">
				<div class="types1">
					<a href="#Refreshments" class="items">Refreshments</a>
					<a href="#Starters(Veg&NonVeg)" class="items">Starters(Veg&NonVeg)</a>
					<a href="#Breakfast" class="items">Breakfast</a>
					<a href="#PureVeg" class="items">PureVeg</a>
					<a href="#PureNonVeg" class="items">PureNonVeg</a>
				</div>
				<div class="types2">
					<a href="#Desserts" class="items">Desserts</a>
					<a href="#Royals Specials" class="items">Royals Specials</a>
					<a href="#" class="items">BBQ</a>
				</div>
			</div>
			<div class="rightSide">
				<div class="cart">
					<div><p id="cartItems" class="cart-total">${itemsInCart}</p></div>
					<div><a href="<%=request.getContextPath()%>/cart" id="cart" onclick="func()"><i class="fa-solid fa-cart-shopping" style="color: #fbff00;"></i></a></div>
					<!-- href="<%=request.getContextPath()%>/${userId}/cart"	 -->		
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
	<div class="mainCarousel">
			<%@include file="mainCarousel.jsp" %>
			<!-- increase carousel width and add royals specials
			dropdown button not working -->
	</div>
	<!-- <p>${items}</p>  -->
	<div class="bottom">	 
		<c:forEach items="${allItems}" var="list" varStatus="status1">
			<!-- printing list index -->
			<!-- <span>${status1.index}</span> -->
			<!-- printing complete list -->
			<!-- <span>${list}</span>  -->
			<!-- printing list[0].food -->
			<div id="${list[2].food}" class="foodType" style="margin-left:37px;"><h5>${list[0].food}</h5></div>
			<!-- this one iterates upto no of items in list allItems.length=7 so it comes from 0 to 6
			but we dont have 6 items in every div so we cant use this -->
			<!--  <div id="${list[status1.index].food}">${list[status1.index].food}</div> -->
			<div class="wrapper">
				<c:forEach items="${list}" var="listObj" varStatus="status">
					<%@ page import="java.util.ArrayList" %>
					<%@ page import="java.util.List" %>
					<%@page import="com.project.foodApp.BusinessBeans.Item"%>
					<!-- printing index inside big list -->
					<!-- <span>${status.index}</span> -->
					<!-- printing list -->
					<!-- <span>${list}</span>  -->
					<c:set var="food" value="${listObj.food}"/>
					<div class="item">
							<div class="matter">
									<div class="matter1">
										<c:set var="foodtype" value="${listObj.foodType}"></c:set>
										<c:if test="${foodtype eq 'veg'}">
											<div class="food"><img class="foodIcon" src="<%=request.getContextPath()%>/images/veg.jpg" alt="${listObj.foodType}"/></div>
										</c:if>
										<c:if test="${foodtype eq 'nonveg'}">
											<div class="food"><img class="foodIcon" src="<%=request.getContextPath()%>/images/nonveg.jpg" alt="${listObj.foodType}"/></div>
										</c:if>
										<div class="name"><p class="title">${listObj.title}</p></div>
										<div class="rupee"><i class="fa-solid fa-indian-rupee-sign fa-sm"></i>  ${listObj.price}</div>
									</div>
									<div class="matter2">
										<div><i class="fa-solid fa-star staricon" style="color: #156100;"></i></div>
										<div class="rating">${listObj.rating}</div>
										<div class="peopleOrdered">(${listObj.noOfPeopleOrdered})</div>
									</div>
									<div class="matter3">
										<a href="#" onclick="return false;" title="" data-bs-toggle="popover" data-bs-trigger="focus" data-bs-content="${listObj.itemDetails}"
										class="moreDetails">More Details<i class="fa-solid fa-light fa-arrow-right fa-beat-fade fa-sm arrow"></i></a>
									</div>
							</div>
							<div class="pic">
								<div class="picbox1"><img class="pics" src="<%=request.getContextPath()%>${listObj.image}" alt="${listObj.alternateImageName}"></div>
								<c:set var="foodid" value="${listObj.foodId}"/>
								<div class="picbox2"><button type="button" class="add" name="add" id="${listObj.foodId}" onclick="handleButtonClick(${foodid})">ADD</button></div>
								<c:forEach items ="${items}" var="item">
									<!-- ${item} this is used for printing list  -->
									<c:set var="item" value="${item}"/>
										<c:if test="${item==foodid}">
											<div class="picbox2"><button type="button" class="add" name="add" id="${listObj.foodId}" onclick="handleButtonClick(${foodid})">ADDED</button></div>
										</c:if>			
								</c:forEach>
								<div class="picbox3"><p class="caption">${listObj.customisable}</p></div>
							</div>	
					</div>
				</c:forEach>
			</div>
		</c:forEach>
	
	</div>
	<footer>
		<%@include file="mainfooter.jsp"%>
		<script>
			var popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'))
			var popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
			  return new bootstrap.Popover(popoverTriggerEl)
			})
			
		</script>
		<script src="<c:url value='/js/mainPage.js' />"></script>
	</footer>
</body>
</html>