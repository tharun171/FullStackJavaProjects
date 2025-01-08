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
<title>Cart</title>
<style type="text/css">
	<%@include file="/WEB-INF/views/cart.css"%>
</style>
</head>
<body>
	<header>
		<%@include file="mainPageHeader.jsp" %>
	</header>
	<div class="bodyOfCart">
		<div class="section1">
			<div><h5>Delivery Address</h5></div>
			<div class="matterSection1">
				<div>Delivering to -</div>
				${address}
			</div>
		</div>
		<div class="section2">
			<div class="box1">
				<h4>Items In cart</h4>
			</div>
			<div class="head">
						<p id="abc1">Title</p>
						<p id="abc2">Veg/NonVeg</p>
						<p id="abc3">Price of (1)</p>
						<p id="abc4">quantity</p>
						<p id="abc5">TotalPrice</p>
			</div>
			<div class="box2">
				<c:forEach items="${userSelectedItems}" var="item">
					<c:set var="idprice" value="${item.price}"/>
					<div class="item" id="${idprice}">
						<p id="item1" class="item1">${item.title}</p>
						<p id="item2">${item.foodType}</p>
						<p id="item3" class="${item.title}">${item.price}</p>
						<div class="button">
							<div class="btn1"><button class="realBtn" id="${item.title}${item.price}" 
							onclick="minus('${item.title}','${item.foodId}')">-</button></div>
							<c:set var="quantity" value="1"></c:set>
							<div class="btn2" id="quantity${item.title}">${quantity}</div>
							<div class="btn3"><button class="realBtn plus" id="${item.title}${item.price}" onclick="plus('${item.title}','${item.foodId}')">+</button></div>
						</div>
						<p class="item5" id="totalPrice${item.title}">${item.price}</p>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="section3">
			
		</div>
	</div>
	<div class="middleBox">
		<div class="section1"></div>
		<div class="section2 msection">
			<div class="boxTwo">
				<div class="billing">
				<p class="billing-item">item Total</p>
				<p class="billing-item" id="totalPrice">totalPrice</p>
			</div>
			<div class="billing">
				<p class="billing-item">Delivery Fee</p>
				<p class="billing-item" id="deliveryfee">${cartVariables.deliveryfee}</p>
			</div>
			<div class="billing-item">Use coupons that we provide</div>
			<div><hr></div>
			<div class="billing">
				<p class="billing-item">Delivery tip</p>
				<div class="button1">
					<div class="btn1"><button class="realBtn" onclick="minusTip()">-</button></div>
					<div class="btn2" id="deliverytip">${cartVariables.deliverytip}</div>
					<div class="btn3"><button class="realBtn plus" onclick="plusTip()">+</button></div>
				</div>
				<p class="billing-item" id="deliverytipvalue">0</p>
			</div>
			<div class="billing">
				<p class="billing-item">platform fee</p>
				<p class="billing-item" id="platformfee">${cartVariables.platformfee}</p>
			</div>
			<div class="billing">
				<p class="billing-item">Gst + restaurent charges</p>
				<p class="billing-item" id="gst">${cartVariables.gst}</p>
			</div>
			<div><hr></div>
			<div class="billing">
				<p class="billing-item">to pay</p>
				<p class="billing-item" id="total">total</p>
			</div>
			</div>
			<button class="checkout" type="submit"><a class="invoice" href="#" onclick="invoice()">CheckOut</a></button>
		</div>	
		<div class="section3"></div>
	</div>
	<footer>
		<%@include file="mainfooter.jsp" %>
		<spring:url value="/resources/js/cart.js" var="cartJs"/>
		<script src="${cartJs}"></script>
		<script src="<c:url value='/js/cart.js' />"></script>
	</footer>
</body>
</html>