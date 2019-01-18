<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!-- Bootstrap Modal for "Add New Category"-->
<div class="modal fade" id="addCategoryModal" role="dialog"
	tabindex="-1">
	<div class="modal-dialog " role="document">
		<div class="modal-content">
			<!-- Modal Header -->
			<div class="modal-header text-center">
				<h4 class="modal-title w-100 ">Add new category</h4>
				<button type="button" class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<!-- Add Category Form (Here "id" for validation, code in eshopping.js -->
				<sf:form id="categoryForm" modelAttribute="addCategory"
					action="${contextRoot}/manage/category" method="POST"
					class="form-horizental">
					<div class="form-group row">
						<label for="category_name" class="control-label  col-md-4">
							Category Name</label>
						<div class="col-md-8">
							<sf:input type="text" path="name" id="category_name"
								class="form-control" />
							<sf:errors path="name" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="form-group row">
						<label for="category_description" class="control-label col-md-4">
							Description</label>
						<div class="col-md-8">
							<sf:textarea cols="" rows="5" path="description"
								id="category_decription" class="form-control"
								placeholder="Add Description" />
							<sf:errors path="description" cssClass="help-block" element="em" />
						</div>
					</div>
					<div class="form-group ">
						<div class="modal-footer d-flex justify-content-center">
							<input type="submit" value="Add Category"
								class="btn btn-outline-primary">
							<button type="button" class="btn btn-outline-danger"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</sf:form>
			</div>
		</div>
	</div>
</div>