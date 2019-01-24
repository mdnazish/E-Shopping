<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<%--  Demo - To Understand the concept  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-Shopping</title>
</head>
<!-- Just for Application testing purpose -->
<body>
${contextRoot} says - ${greeting}
</body> 
</html> 

--%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- to avoid Console Error HTTP Status 403: 
	- when we activate or deactivate product from "Manage Product" tab
	- & write ajax code to handle this problem in "eshopping.js" file-->
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>Shopping Cart - ${title}</title>

<script>
	window.menu = '${title}';
	
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/e-shopping.css" rel="stylesheet">

<!-- Business Tycoon Theme for this template -->
<link href="${css}/theme-business-tycoon.css" rel="stylesheet">

 <!-- Font Awesome CSS -->
<link href="${css}/font-awesome.css" rel="stylesheet">

<!-- Bootstrap DataTables CSS -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

<%-- <!-- Bootstrap DataTables Responsive CSS -->
<link href="${css}/responsive.dataTables.css" rel="stylesheet">
 --%>
</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content / Main Content -->

		<div class="content">

			<!-- Loading the home content -->
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load only when user click Products -->
			<c:if test="${userClickProducts == true or userClickCategoryProducts == true }">
				<%@include file="products.jsp"%>
			</c:if>
			
			<!-- Load only when user click Manage Products -->
			<c:if test="${userClickManageProducts == true }">
				<%@include file="manageProducts.jsp"%>
			</c:if>

			<!-- Load only when user click About Us -->
			<c:if test="${userClickAboutUs == true }">
				<%@include file="aboutUs.jsp"%>
			</c:if>

			<!-- Load only when user click Contact Us -->
			<c:if test="${userClickContactUs == true }">
				<%@include file="contactUs.jsp"%>
			</c:if>
			
			<!-- Load only when user click show product -->
			<c:if test="${userClickShowProduct == true }">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
		</div>
		<!-- Footer Linked here-->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		
		<!-- JQuery Form Validator -->
		<script src="${js}/jquery.validate.js"></script>
		
		<!-- DataTable Plugins -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- DataTable Bootstrap Script -->
		<script src="${js}/dataTables.bootstrap4.js"></script>
		
		<%-- <!-- DataTable Bootstrap Responsive Script -->
		<script src="${js}/dataTables.responsive.js"></script> --%>
		
		<!-- Bootbox Alert Script -->
		<script src="${js}/bootbox.min.js"></script>

		<!-- based on our project requirement eshopping.js -->
		<script src="${js}/eshopping.js"></script>
	</div>
</body>

</html>

