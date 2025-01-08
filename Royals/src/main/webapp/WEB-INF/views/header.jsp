<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<%@include file="/WEB-INF/views/header.css"%>
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
</body>
</html>