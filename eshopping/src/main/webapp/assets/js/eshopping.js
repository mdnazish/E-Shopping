$(function() {
	// solving the active menu problem
	switch (menu) {

	case 'Home':
		$('.home').addClass('active');
		break;

	case 'About Us':
		$('.aboutUs').addClass('active');
		break;

	case 'Contact Us':
		$('.contactUs').addClass('active');
		break;

	case 'Products':
		$('.products').addClass('active');
		break;

	case 'Product Management':
		$('.manageProducts').addClass('active');
		break;

	default:
		$('.products').addClass('active');
		$('#active_' + menu).addClass('active');
		break;
	}
	

	// code for jquery dataTable
	// create a dataset
	/*
	 * var products = [
	 * 
	 * ['1', 'AAA'], ['2', 'BBB'], ['3', 'CCC'], ['4', 'DFF'], ['5', 'RRR'],
	 * ['6', 'VVV'], ['7', 'ZZZ'], ['8', 'AAA'], ];
	 */

	var $table = $('#productsTable');

	// execute the below code only where we have this table
	if ($table.length) {

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';

		}
		// console.log('Inside the Table!')

		$table
				.DataTable({

					// data:products

					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
					pageLength : 5,

					ajax : {
						url : jsonUrl,
						dataSrc : ''

					},
					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg"  class="dataTableImg"/>';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data;
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out Of Stock. </span>'
									}
									return data;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="fa fa-eye"></span></a> &#160;';

									if (row.quantity < 1) {
										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="fa fa-shopping-cart"></span></a> &#160;';
									} else {
										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add'
												+ data
												+ '/product" class="btn btn-success"><span class="fa fa-shopping-cart"></span></a> &#160;';
									}
									return str;
								}
							} ]
					
				});
	}

	// dismissing the alert after 3 seconds of form submission 
	var $alert = $('.alert');

	if ($alert.length) {
		setTimeout(function() {

			$alert.fadeOut('slow');

		}, 3000)
	}
});
