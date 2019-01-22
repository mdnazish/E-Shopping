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
								<h3>Sign Up - Personal Detail</h3>
							</div>

							<div class="card border-primary">
								<div class="card-body">
									<!-- Form Element -->
									<sf:form id="registerForm" method="POST" modelAttribute="user"
										class="form-horizontal">

										<div class="form-group row">
											<label class="col-form-label col-sm-4">First Name</label>
											<div class="col-md-8">
												<sf:input type="text" path="firstName" class="form-control"
													placeholder="First Name" />
												<sf:errors path="firstName" cssClass="help-block"
													element="em" />
											</div>
										</div>

										<div class="form-group row">
											<label class="col-form-label col-sm-4">Last Name</label>
											<div class="col-md-8">
												<sf:input type="text" path="lastName" class="form-control"
													placeholder="Last Name" />
												<sf:errors path="lastName" cssClass="help-block"
													element="em" />
											</div>
										</div>

										<div class="form-group row">
											<label class="col-form-label col-sm-4">Email</label>
											<div class="col-md-8">
												<sf:input type="text" path="email" class="form-control"
													placeholder="abc@zyx.com" />
												<sf:errors path="email" cssClass="help-block" element="em" />
											</div>
										</div>

										<div class="form-group row">
											<label class="col-form-label col-sm-4">Contact Number</label>
											<div class="col-md-8">
												<sf:input type="text" path="contactNumber"
													class="form-control" placeholder="XXXXXXXXXX"
													maxlength="10" />
												<sf:errors path="contactNumber" cssClass="help-block"
													element="em" />
											</div>
										</div>

										<div class="form-group row">
											<label class="col-form-label col-sm-4">Password</label>
											<div class="col-md-8">
												<sf:input type="password" path="password"
													class="form-control" placeholder="Password" />
												<sf:errors path="password" cssClass="help-block"
													element="em" />
											</div>
										</div>

										<div class="form-group row">
											<label class="col-form-label col-sm-4">Confirm
												Password</label>
											<div class="col-md-8">
												<sf:input type="password" path="confirmPassword"
													class="form-control" placeholder="Re-type password" />
												<sf:errors path="confirmPassword" cssClass="help-block"
													element="em" />
											</div>
										</div>

										<!-- radio button using bootstrap class of radio-inline -->
										<div class="form-group row">
											<label class="col-form-label col-sm-4">Select Role</label>
											<div class="col-md-8">
												<label class="radio-inline"> <sf:radiobutton
														path="role" value="USER" checked="checked" /> User
												</label> <label class="radio-inline"> <sf:radiobutton
														path="role" value="SUPPLIER" /> Supplier
												</label>
											</div>
										</div>

										<div class="form-group row">
											<div class="offset-md-4 col-md-8">
												<button type="submit" name="_eventId_billing"
													class="btn btn-primary">
													Next - Billing <span class="fa fa-chevron-right"></span>
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