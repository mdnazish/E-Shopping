<!-- Header -->
<%@include file="../shared/flows-header.jsp"%>

<body>
	<div class="wrapper">

		<!-- Navigation/ Navbar -->
		<%@include file="../shared/flows-navbar.jsp"%>

		<!-- Page Content / Main Content -->

		<div class="content">
			<div class="container">
				<div class="row">
					<div class="offset-sm-4 col-sm-4">
						<div class="text-center">
							<h1>Welcome!</h1>
							<h3>shoppingcart.com</h3>
							<h6>You can use your email as username to login!</h6>
							<!-- anchar tag to move to the success page -->
							<a href="${contextRoot}/login"
								class="btn btn-lg btn-success">Login Here!</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Footer  -->
	<%@include file="../shared/flows-footer.jsp"%>