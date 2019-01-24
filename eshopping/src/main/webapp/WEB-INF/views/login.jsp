<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

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

</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
			role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home"> Shopping
						Cart </a>
				</div>
			</div>
		</nav>

		<!-- Page Content / Main Content -->

		<div class="content">
			<div class="container">
			
			<!-- This will be displayed if Login Credentials are Wrong -->
				<c:if test="${not empty message}">
					<div class="row">
						<div class="col-md-6 offset-md-2">
							<div class="alert alert-danger">${message}</div>

						</div>
					</div>
				</c:if>
				
				<div class="row">
					<div class="col-md-6 offset-md-2">
						<div class="card card-primary">
							<div class="card-header bg-primary text-white">
								<h3>Login Here</h3>
							</div>

							<div class="card border-primary">
								<div class="card-body">
									<!-- Form Element -->
									<form action="${contextRoot}/login" method="POST"
										class="form-horizontal" id="loginForm">
										<div class="form-group row">
											<label for="username" class="col-md-4 control-label">Email:
											</label>
											<div class="col-md-8">
												<input type="text" name="username" id="username"
													class="form-control" placeholder="Enter Username" />
											</div>
										</div>
										<div class="form-group row">
											<label for="password" class="col-md-4 control-label">Password:
											</label>
											<div class="col-md-8">
												<input type="password" name="password" id="password"
													class="form-control" placeholder="Enter Password" />
											</div>
										</div>
										<div class="form-group row">
											<div class="offset-sm-4 col-sm-4">
												
												<!-- To avoid client-side error - HTTP Status 403: couldn't verify the provided CSRF token because your session was not found. 
														Solution-1: add <csrf disabled="true"/> in spring-security.xml file  OR
														Solution-2: write below <input type="hidden" ...  ...  />
												-->
												
												<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
												<input type="submit" value="Login" class="btn btn-primary" />
											</div>
										</div>
									</form>

								</div>
								<div class="card-footer">
									<div class="text-right">
										New User - <a href="${contextRoot}/register">Register Here</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Footer Linked here-->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>

		<!-- JQuery Form Validator -->
		<script src="${js}/jquery.validate.js"></script>

		<!-- based on our project requirement eshopping.js -->
		<script src="${js}/eshopping.js"></script>
	</div>
</body>

</html>

