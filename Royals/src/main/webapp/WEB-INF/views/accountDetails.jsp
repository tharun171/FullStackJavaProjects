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
<title>account Details</title>
<!-- CSS -->
<style>
<%@include file="/WEB-INF/views/accountDetails.css" %> 
</style>
</head>
<body>
	<header>
		<%@include file="mainPageHeader.jsp" %>
	</header>
	<div class="middle">
		<div class="section1">
		
		</div>
		<div class="section2">
			<div class="mainBox">
				<div class="heading">
					<h2>Account Details</h2>
				</div>
				<div class="formBox">
					<form:form action="updateAccountDetails" modelAttribute="accountDetailsNew" method="post">
						<table>
							<tr>
								<td><label class="label">Name</label></td>
								<td><form:input path="name" class="inputs" disabled="true"/></td>
								<!-- this is used to give warning msg if user detail already are other user email -->
								<td><span class="messages"></span></td>
							</tr>
							<tr>
								<td><label class="label">PhoneNumber</label></td>
								<td><form:input path="phoneNumber" class="inputs" disabled="true"/></td>
								<td><span class="messages"></span></td>
							</tr>
							<tr>
								<td><label class="label">Email</label></td>
								<td><form:input path="email" class="inputs" disabled="true"/></td>
								<td><span class="messages"></span></td>
							</tr>
							<tr>
								<td><label class="label">JoinedDate</label></td>
								<td><form:input path="joinedDate" disabled="true" class="inputs"/></td>
								<td><span class="messages"></span></td>
							</tr>
						</table>
						<div class="buttons">
							<div><input class="update" type="submit" value="Update" disabled/></div>
							<div class="lastBox">
							<button class="last" onclick="location.href='<%= request.getContextPath() %>/${accountDetails.getUserId()}/main'" 
							type="button">Home!</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<div class="section3">
				
		</div>
	</div>
	<footer>
		<%@include file="mainfooter.jsp" %>
	</footer>
</body>
</html>