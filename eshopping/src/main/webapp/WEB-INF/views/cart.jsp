<div class="container">
	<c:if test="${not empty message}">
		<div class="alert alert-info">
			<h3 class="text-center">${message}</h3>
		</div>
	</c:if>
	<div class="card shopping-cart" style="margin-top: 20px;">
		<div class="card-header bg-dark text-light">
			<i class="fa fa-shopping-cart" aria-hidden="true"></i> Cart <a
				href="${contextRoot}/show/all/products"
				class="btn btn-outline-info btn-sm pull-right">Continue Shopping</a>
			<div class="clearfix"></div>
		</div>
		<c:choose>
			<c:when test="${not empty cartLines}">
				<div class="card-body">
					<!-- PRODUCT -->
					<div class="row">
						<table id="cart" class="table table-hover table-condensed">
							<thead>
								<tr>
									<th style="width: 50%">Product</th>
									<th style="width: 10%">Price</th>
									<th style="width: 8%">Quantity</th>
									<th style="width: 22%" class="text-center">Subtotal</th>
									<th style="width: 10%"></th>
								</tr>
							</thead>
							<c:forEach items="${cartLines}" var="cartLine">
								<tbody>
									<tr>
										<td data-th="Product">
											<div class="row">
												<div class="col-sm-2 hidden-xs">
													<img id="cartImg"
														src="${images}/${cartLine.product.code}.jpg"
														alt="${cartLine.product.name}" class="img-responsive" />
												</div>
												<div class="col-sm-10">
													<h4 class="nomargin">
														<a
															href="${contextRoot}/show/${cartLine.product.id}/product">${cartLine.product.name}</a>
														<c:if test="${cartLine.available == false}">
															<strong id="unavailable">(Not Available)</strong>
														</c:if>
													</h4>
													<p>
														<b>Brand:</b> ${cartLine.product.brand} <br /> <b>Description:</b>
														${cartLine.product.description}
													</p>
												</div>
											</div>
										</td>
										<td data-th="Price">&#8377; ${cartLine.buyingPrice}</td>
										<td data-th="Quantity"><input type="number"
											id="count_${cartLine.id}" class="form-control text-center"
											min="1" max="5" value="${cartLine.productCount}"></td>
										<td data-th="Subtotal" class="text-center">&#8377;
											${cartLine.total}</td>
										<td class="actions" data-th="">
											<button type="button" data-toggle="tooltip" title="Refresh | Update"
											name="refreshCart" value="${cartLine.id}" class="btn btn-info btn-sm">
												<i class="fa fa-refresh"></i>
											</button> <a href="${contextRoot}/cart/${cartLine.id}/delete"
											class="btn btn-danger btn-sm" data-toggle="tooltip" title="Delete"> <i class="fa fa-trash-o"></i>
										</a>
										</td>
									</tr>
								</tbody>
							</c:forEach>
						</table>
						<!-- END PRODUCT -->
					</div>
				</div>
				<div class="card-footer">
					<div class="coupon col-md-5 col-sm-5 no-padding-left pull-left">
						<div class="row">
							<div class="col-6">
								<input type="text" class="form-control"
									placeholder="coupon code">
							</div>
							<div class="col-6">
								<input type="submit" class="btn btn-default" value="Apply Coupon">
							</div>
						</div>
					</div>
					<div class="pull-right" style="margin: 10px">
						<a href="" class="btn btn-success pull-right">Checkout</a>
						<div class="pull-right" style="margin: 5px">
							<strong><a href="#">Grand Total </a>:  &#8377; ${userModel.cart.grandTotal}</strong>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
			<div class="card-body">
				<div class="jumbotron">
					<div class="text-center">
						<h1>Your Cart is empty.!</h1>
					</div>
				</div>
			</div>
			<div class="card-footer">
				<div class="text-left">
						<h6 class="text-info" bgcolor="black">Please add some products in your cart.!</h6>
				</div>
			</div>
			</c:otherwise>
		</c:choose>
	</div>
</div>
