<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@tag description="Header Tag" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
	
<link rel="stylesheet" href='<c:url value="/assets/css/bootstrap.min.css" />'>
<link rel="stylesheet" href='<c:url value="/assets/css/main.css" />'>
<link rel="stylesheet" href='<c:url value="/assets/css/font-awesome.min.css" />'>	
	
<title> Leave Management System </title>
</head>
	
<body>
<nav>
	<div  class="navbar navbar-fixed-top">
		<div class="navbar-header">
		<a class="navbar-brand" href="#"> 
			<img src='<c:url value="/assets/images/oandblogo.png" />' alt="Orange & Bronze Software Labs, Inc." title="Orange & Bronze Software Labs, Inc." id="navLogo">
		</a>
		</div>
		<a href="login" role="button" title="Logout" id="navLogout">
			<i class="fa fa-power-off fa-2x" aria-hidden="true"></i>
		</a>
	</div> 
</nav>
	