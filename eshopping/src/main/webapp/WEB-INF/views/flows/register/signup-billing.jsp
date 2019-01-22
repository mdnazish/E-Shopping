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
					<div class="col-md-8 offset-md-2">
						<div class="card card-primary">
							<div class="card-header bg-primary text-white">
								<h3>Sign Up - Billing Address</h3>
							</div>

							<div class="card border-primary">
								<div class="card-body">
									<!-- Form Element -->
									<sf:form id="billingForm" method="POST"
										modelAttribute="billing" class="form-horizontal">

										<div class="form-group row">
											<label class="col-form-label col-sm-4">Address 1:</label>
											<div class="col-md-8">
												<sf:input type="text" path="addressLine1"
													class="form-control"
													placeholder="Enter Residential Address " />
												<sf:errors path="addressLine1" cssClass="help-block"
													element="em" />
											</div>
										</div>

										<div class="form-group row">
											<label class="col-form-label col-sm-4">Address 2:</label>
											<div class="col-md-8">
												<sf:input type="text" path="addressLine2"
													class="form-control" placeholder="Enter Permanent Address " />
												<sf:errors path="addressLine2" cssClass="help-block"
													element="em" />
											</div>
										</div>

										<div class="form-group row">
											<label class="col-form-label col-sm-4">City</label>
											<div class="col-md-8">
												<sf:input type="text" path="city" class="form-control"
													placeholder="Enter City Name" />
												<sf:errors path="city" cssClass="help-block" element="em" />
											</div>
										</div>

										<div class="form-group row">
											<label class="col-form-label col-sm-4">State</label>
											<div class="col-md-8">
												<sf:input type="text" path="state" class="form-control"
													placeholder="Enter State Name" maxlength="10" />
												<sf:errors path="state" cssClass="help-block" element="em" />
											</div>
										</div>

										<div class="form-group row">
											<label class="col-form-label col-sm-4">Country</label>
											<div class="col-md-8">
												<sf:input type="text" path="country" class="form-control"
													placeholder="Enter Country Name" />
												<sf:errors path="country" cssClass="help-block" element="em" />
											</div>
										</div>

										<div class="form-group row">
											<label class="col-form-label col-sm-4">Postal Code</label>
											<div class="col-md-8">
												<sf:input type="text" path="postalCode" class="form-control"
													placeholder="Enter Postal Code" />
												<sf:errors path="postalCode" cssClass="help-block"
													element="em" />
											</div>
										</div>

										<!-- submit button for moving to the Personal Detail Page -->
										<div class="form-group row">
											<div class="offset-md-4 col-md-8">
												<button type="submit" name="_eventId_personal"
													class="btn btn-primary">
													<span class="fa fa-chevron-left"></span> Previous - Personal 
												</button>

												<!-- submit button for moving to the Confirm Page -->
												<button type="submit" name="_eventId_confirm"
													class="btn btn-primary">
													Next - Confirm <span class="fa fa-chevron-right"></span>
												</button>
											</div>
										</div>

									</sf:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	<!-- Footer  -->
	<%@include file="../shared/flows-footer.jsp"%>