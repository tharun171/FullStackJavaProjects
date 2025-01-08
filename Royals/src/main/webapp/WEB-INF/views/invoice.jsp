<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text\html" charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<!-- convert html page to pdf -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js"></script>
<title>Royals Main Page</title>
<!-- Responsive meta tag -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Font Awesome  -->
<script src="https://kit.fontawesome.com/5069618204.js" crossorigin="anonymous"></script>
<title>Cart</title>
<style type="text/css">
	<%@include file="/WEB-INF/views/invoice.css"%>
</style>
</head>
<body id="invoice">
	<div class="bodyPage">
		<div class="bodyContent">
			<div class="logo">
				<img alt="Royals Restaurant" src="<%=request.getContextPath()%>/images/logo3.jpg" width="200" height="52">
			</div>
			<div class="heading">
				<h5>Tax Invoice</h5>
			</div>
			<div class="restoBox">
				<div class="restoBox1">
					<table>
						<tr class="row1">
							<td>Invoice to :  </td>
							<td>${accountDetails.name}</td>
						</tr>
						<tr class="row1">
							<td>Email:  </td>
							<td>${accountDetails.email}</td>
						</tr>
						<tr class="row1">
							<td>PhoneNumber:  </td>
							<td>${accountDetails.phoneNumber}</td>
						</tr>
						<tr class="row1">
							<td>customer Address:  </td>
							<td>${address}</td>
						</tr>
						<tr>
							<td>Date Of Invoice:  </td>
							<td>${date}</td>
						</tr>
					</table>
				</div>
				<div  class="restoBox2">
					<table>
						<tr class="row1">
							<td>Restaurant Name:  </td>
							<td>  Royals Restaurant</td>
						</tr>
						<tr class="row1">
							<td>GSTIN:</td>
							<td>AHO986TY54FCG6</td>
						</tr>
						<tr class="row1">
							<td>Restaurant Address:</td>
							<td>25/3 d-block ground floor,
							marathahalli multiplex road,
							beside Hdfc bank, bangalore 560037,karnataka</td>
						</tr>
						<tr class="row1">
							<td>Invoice id:</td>
							<td>15478594587559</td>
						</tr>
						<tr>
							<td>Service of description</td>
							<td>Restaurant Service</td>
						</tr>
						
					</table>
				</div>
			</div>
			<div class="items">
					<table>
						<tr>
							<td id="title1">Description</td>
							<td id="foodType">Veg /NonVeg</td>
							<td id="price">Unit Price</td>
							<td id="quantity">Quantity</td>
							<td id="totalPrice">Total value(Rs.)</td>
						</tr>
					</table>
				<c:forEach items="${userSelectedList}" var="item" varStatus="i">
					<table>
						<tr>
							<td id="title">${item.title}</td>
							<td id="foodType">${item.foodType}</td>
							<td id="price">${item.price}</td>
							<td id="quantity">${quantity[i.index]}</td>
							<td id="totalPrice">${totalPrice[i.index]}</td>
						</tr>
					</table>
				</c:forEach>
			</div>
			<div class="subTable">
				<table class="subTab">
					<tr class="subTab">
						<td class="subTab" id="subtotal">subtotal</td>
						<td class="subtotal" id="totalPrice">${subTotal}</td>
					</tr>
				</table>
			</div>
			<div class="items1">
				<div>
					<table border="0">
						<tr><td class="deliveryfeelast">Delivery Fee</td></tr>
						<tr><td class="deliveryfeelast">Delivery Tip</td></tr>
						<tr><td class="deliveryfeelast" id="">platform Fee</td></tr>
						<tr><td class="deliveryfeelast" id="">Gst + Taxes</td></tr>
						<tr><td class="deliveryfeelast1" id=""><p id="">TotalPrice to Pay</p></td></tr>
					</table>
				</div>
				<div>
					<table>
						<tr><td id="rightbox">${cartVariables.deliveryfee}</td></tr>
						<tr><td id="rightbox">${deliveryTip}</td></tr>
						<tr><td id="rightbox">${cartVariables.platformfee}</td></tr>
						<tr><td id="rightbox">${cartVariables.gst}</td></tr>
						<tr><td id="rightbox">${total}</td></tr>
					</table>
				</div>
			</div>
			<div class="bottom">
					<p id="bot">Details of ECO under GST</p>
					<p id="bot">Name: Royal Technologies of private Limited(Royals)</p>
					<p id="bot">Address: No 55,Sy No 8 to 14,Ground floor,Outer Ring Road,Bengaluru - 560103</p>
					<p id="bot">GSTIN : 29HJHSJK45SJHUSU4</p>
			</div>
		</div>
	</div>
</body>
</html>