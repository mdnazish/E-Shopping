
<div class="container">

	<c:if test="${not empty message}">
		<div class="alert alert-info">
			<h3 class="text-center">${message}</h3>
		</div>

	</c:if>
	<c:choose>
		<c:when test="${not empty cartLines}">
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
										<img id="cartImg" src="${images}/${cartLine.product.code}.jpg"
											alt="${cartLine.product.name}" class="img-responsive" />
									</div>
									<div class="col-sm-10">
										<h4 class="nomargin"><a href="${contextRoot}/show/${cartLine.product.id}/product">${cartLine.product.name}</a>
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
								<button type="button" name="refreshCart" value="${cartLine.id}"
									class="btn btn-info btn-sm">
									<i class="fa fa-refresh"></i>
								</button> <a href="${contextRoot}/cart/${cartLine.id}/delete"
								class="btn btn-danger btn-sm"> <i class="fa fa-trash-o"></i>
							</a>
							</td>
						</tr>
					</tbody>
				</c:forEach>
				<tfoot>
					<%-- <tr class="visible-xs">
						<td class="text-center"><strong>&#8377; ${userModel.cart.grandTotal}</strong></td>
					</tr> --%>
					<tr>
						<td><a href="${contextRoot}/show/all/products" class="btn btn-warning"><i
								class="fa fa-angle-left"></i> Continue Shopping</a></td>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong>Total
								&#8377; ${userModel.cart.grandTotal}</strong></td>
						<td><a href="#" class="btn btn-success btn-block">Checkout
								<i class="fa fa-angle-right"></i>
						</a></td>
					</tr>
				</tfoot>
			</table>
		</c:when>
		<c:otherwise>
			<div class="jumbotron">
				<div class="text-center">
					<h1>Your Cart is empty.!</h1>
				</div>
			</div>

		</c:otherwise>
	</c:choose>
</div>