<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-sm-12">
				<div class="alert alert-success alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>${message}</strong>
				</div>
			</div>
		</c:if>
		<div class="col-md-8 offset-md-2">
			<div class="card card-primary">
				<div class="card-header bg-primary text-white">
					<h5>
						<strong>Product Management</strong>
					</h5>
				</div>
				<div class="card border-primary">
					<div class="card-body">
						<!-- Form Element -->
						<sf:form modelAttribute="product"
							action="${contextRoot}/manage/products" method="POST"
							enctype="multipart/form-data">
							<div class="form-group row">
								<label class="col-form-label col-sm-4" for="name">Enter
									Product Name :</label>
								<div class=" col-md-8">
									<sf:input class="form-control" type="text" path="name"
										id="name" placeholder="Product Name" />
									<sf:errors path="name" cssClass="help-block" element="em" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-form-label col-sm-4" for="brand">Enter
									Brand Name :</label>
								<div class=" col-md-8">
									<sf:input class=" form-control" type="text" path="brand"
										id="brand" placeholder="Brand Name" />
									<sf:errors path="brand" cssClass="help-block" element="em" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-form-label col-sm-4" for="description">Product
									Description :</label>
								<div class=" col-md-8">
									<sf:textarea class="form-control" path="description"
										id="discription" rows="4" placeholder="Write a description" />
									<sf:errors path="description" cssClass="help-block"
										element="em" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-form-label col-sm-4" for="unitPrice">Enter
									Unit Price <b>(&#8377;)</b> :
								</label>
								<div class=" col-md-8">
									<sf:input class=" form-control" type="number" path="unitPrice"
										id="unitPrice" placeholder="Enter Unit Price" />
									<sf:errors path="unitPrice" cssClass="help-block" element="em" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-form-label col-sm-4" for="quantity">Quantity
									Available :</label>
								<div class=" col-md-8">
									<sf:input class=" form-control" type="number" path="quantity"
										id="quantity" placeholder="Quantity Available" />
								</div>
							</div>
							<!-- File element for Image Upload -->
							<div class="form-group row">
								<label class="col-form-label col-sm-4" for="file">Select
									an Image :</label>
								<div class=" col-md-8">
									<sf:input class="form-control" type="file" path="file"
										id="file" />
									<sf:errors path="file" cssClass="help-block" element="em" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-form-label col-sm-4" for="categoryId">Select
									Category :</label>
								<div class=" col-md-8">
									<sf:select class="form-control" id="categoryId" path="categoryId"
										items="${categories}" itemLabel="name" itemValue="id" />
									<c:if test="${product.id==0}">
									<br/>
									
									<!-- Adding Button to Open the Modal for "Add New Category" --> 
									<div class="text-right">
									<button type="button" data-toggle="modal" data-target="#addCategoryModal" class="btn btn-outline-info btn-sm">Add New Category</button>
									</div>
									</c:if>
								</div>
								
							</div>
							<!--  Hidden Fields for Product -->
							<sf:hidden path="id" />
							<sf:hidden path="code" />
							<sf:hidden path="supplierId" />
							<sf:hidden path="active" />
							<sf:hidden path="purchases" />
							<sf:hidden path="views" />
							<div class="form-group row">
								<div class=" offset-md-4 col-md-8">
									<input class="btn btn-primary" type="submit" name="submit"
										id="submit" value="Submit" />
								</div>
							</div>
						</sf:form>
					</div>
					<div class="card-footer border-primary">
						<small class="text-muted">Add a New Product or Update an Existing Product.</small>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Product Table for Admin -->
	<%@include file="./adminUpdateProducts.jsp"%>
	
	<!-- Add New Category for Admin -->
	<%@include file="./addNewCategory.jsp"%>

</div>