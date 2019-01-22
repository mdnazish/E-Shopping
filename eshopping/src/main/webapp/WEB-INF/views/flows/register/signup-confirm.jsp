<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

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

					<div class="container">
						<div class="row">
							<!--  column to display the address  -->
							<div class="col-sm-6">
								<div class="card card-primary">
									<div class="card-header bg-primary text-white">
										<h4>Personal Detail</h4>
									</div>
									<div class="card-body">
										<!-- code to display the Personal Details -->
										<div class="text-center">
											<h4>${register.user.firstName} ${register.user.lastName}</h4>
											<h5>Email: ${register.user.email}</h5>
											<h5>Contact Number: ${register.user.contactNumber}</h5>
											<h5>Role: ${register.user.role}</h5>

										</div>

									</div>
									<div class="card-footer">
										<!-- anchar tag to move to the edit of address page -->
										<a href="${flowExecutionUrl}&_eventId_personal"
											class="btn btn-primary">Edit</a>
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="card card-primary">
									<div class="card-header bg-primary text-white">
										<h4>Billing Address</h4>
									</div>
									<div class="card-body">
										<!-- code to display the communication address -->
										<div class="text-center">
											<h5>${register.billingAddress.addressLine1}</h5>
											<h5>${register.billingAddress.addressLine2}</h5>
											<h5>${register.billingAddress.city}-
												${register.billingAddress.postalCode}</h5>
											<h5>${register.billingAddress.state}-
												${register.billingAddress.country}</h5>
										</div>
									</div>
									<div class="card-footer">
										<!-- anchar tag to move to the edit of address page -->
										<a href="${flowExecutionUrl}&_eventId_billing"
											class="btn btn-primary">Edit</a>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="offset-sm-4 col-sm-4">
								<div class="text-center">
									<!-- anchar tag to move to the success page -->
									<a href="${flowExecutionUrl}&_eventId_submit"
										class="btn btn-primary">Confirm</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer  -->
	<%@include file="../shared/flows-footer.jsp"%>