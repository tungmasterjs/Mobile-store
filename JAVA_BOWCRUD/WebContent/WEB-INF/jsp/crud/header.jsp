<%@page import="java.util.List"%>
<%@page import="model.item" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>Mobile Store</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resouce/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resouce/css/asm_intern_java_web.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resouce/css/all.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resouce/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resouce/js/all.js"></script>
</head>
<body>
<header>
		<div class="container">
			<h1>Products</h1>
			<p>Add the available products in our store</p>
			<%	
				int qty = 0;
				if(session.getAttribute("cart")!=null){
				List<item> list = (List<item>) session.getAttribute("cart");
				
				for(item itemPro:list){
					qty+=itemPro.getQty();
				}
			}
			%>
			<a href="cartPage"><button class="LogOut btn btn-light ">(<%=qty%>) <i class="fa fa-shopping-cart"></i> view cart</button></a>
			
		</div>
</header>