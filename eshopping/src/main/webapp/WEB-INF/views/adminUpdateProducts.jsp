
<!-- Adding breadcrumb component -->
<div class="row">
	<div class="col-md-12">
		<div class="card-header bg-primary text-center text-white">
			<h4>
				<strong>Available Products </strong>
			</h4>
		</div>
	</div>
	<div class="col-md-12" style="overflow: auto;">
		<table id="adminProductsTable"
			class="table table-hover table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>&#160;</th>
					<!-- Non-Breaking Space &nbsp; -->
					<th>Name</th>
					<th>Brand</th>
					<th>Quantity</th>
					<th>Unit Price</th>
					<th>Active</th>
					<th>Edit</th>
				</tr>
			</thead>
			
			<!-- Here Table data comming from DB Dynamically using JQuery Code
				@see eshopping.js 
				var $adminProductsTable = $('#adminProductsTable');
				and so on.
			 --> 

			<%-- Demonstration On Using bootbox.js alert Script &
				 how to develop Toggle Checkbox to activate and deactivate a product

			<tbody>
				
				<tr>
					<td>4</td>
					<td>
						<img class="adminDataTableImg" src="${contextRoot}/resources/images/PRDMNO123PQRX.jpg" alt="Macbook Pro"/>
					</td>
					<td>Macbook Pro</td>
					<td>Apple</td>
					<td>3</td>
					<td>&#8377; 54000.00/-</td>
					<td>
						<!-- Toogle Switch -->
						<label class="switch">
							<input type="checkbox" checked="checked" value="4"/>
							<div class="slider"></div>
						</label>
					</td>
					<td>
						<a href="${contextRoot}/manage/4/product" class="btn btn-warning">
							<span class="fa fa-pencil"></span>
						</a>
					</td>
				</tr>
				
				<tr>
					<td>4</td>
					<td>
						<img class="adminDataTableImg" src="${contextRoot}/resources/images/PRDMNO123PQRX.jpg" alt="Macbook Pro"/>
					</td>
					<td>Macbook Pro</td>
					<td>Apple</td>
					<td>3</td>
					<td>&#8377; 54000.00/-</td>
					<td>
						<!-- Toogle Switch -->
						<label class="switch">
							<input type="checkbox" value="4"/>
							<div class="slider"></div>
						</label>
					</td>
					<td>
						<a href="${contextRoot}/manage/4/product" class="btn btn-warning">
							<span class="fa fa-pencil"></span>
						</a>
					</td>
				</tr>
			</tbody> 
		--%>

			<tfoot>
				<tr>
					<th>Id</th>
					<th>&#160;</th>
					<!-- Non-Breaking Space &nbsp; -->
					<th>Name</th>
					<th>Brand</th>
					<th>Quantity</th>
					<th>Unit Price</th>
					<th>Active</th>
					<th>Edit</th>
				</tr>
			</tfoot>
		</table>
	</div>
</div>

