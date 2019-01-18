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

	// Demo Purpose
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
								bSorted : false,
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

		}, 3000);
	}

	/*----------------------------------+-----------------------------------------------------------
	To Show all Products dataTable for Admin to activate or deactivate products using Toggle button
	------------------------------------------------------------------------------------------------*/

	var $adminProductsTable = $('#adminProductsTable');

	// execute the below code only where we have this table
	if ($adminProductsTable.length) {

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminProductsTable
				.DataTable({

					// data:products

					lengthMenu : [ [ 10, 30, 50, -1 ],
							[ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 30,

					ajax : {
						url : jsonUrl,
						dataSrc : ''

					},
					columns : [
							{
								data : 'id'
							},
							{
								data : 'code',
								bSorted : false,
								mRender : function(data, type, row) {
									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg"  class="adminDataTableImg"/>';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
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
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data;
								}
							},

							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';

									str += '<label class="switch">'
									if (data) {
										str += '<input type="checkbox" checked="checked" value="'
												+ row.id + '"/>';
									} else {
										str += '<input type="checkbox" value="'
												+ row.id + '"/>'

									}
									str += '<div class="slider"></div></label>'
									return str;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';

									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning">';
									str += '<span class="fa fa-pencil"></span></a>';

									return str;
								}

							} ],

					initComplete : function() {

						// Bootbox Alert Plugin for toggle switch
						// @add "bootbox.min.js" file

						var toggle = this.api(); // api() function of
						// dataTable
						toggle
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {
											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var dialogMsg = (checked) ? 'You want to activate this Product?'
													: 'You want to de-activate this Product';
											var value = checkbox.prop('value');

											bootbox
													.confirm({
														size : 'medium',
														title : 'Product Activation & De-activation',
														message : dialogMsg,
														callback : function(
																confirmed) {

															if (confirmed) {
																console
																		.log(value);

																var toggleActivationUrl = window.contextRoot
																		+ '/manage/product/'
																		+ value
																		+ '/activation';

																$
																		.post(
																				toggleActivationUrl,
																				function(
																						data) {
																					bootbox
																							.alert({
																								size : 'medium',
																								title : 'Information',
																								message : data

																							});

																				});

															} else {
																checkbox
																		.prop(
																				'checked',
																				!checked);
															}
														}
													});
										});
					}

				});
	}

	// --------------------------------------------------------------------------------

	// jQuery Validation Code
	// Code for Client-side Form Validation [For- Add New Category]

	var $addcategoryForm = $('#categoryForm');

	if ($addcategoryForm.length) {

		$addcategoryForm.validate({
			rules : {
				name : {
					required : true,
					minlength : 3
				},
				description : {
					required : true,
				}
			},
			messages : {
				name : {
					required : 'Please Enter Category name!',
					minlength : 'Please enter atleast 3 characters'
				},
				description : {
					required : 'Please Enter Category Description!',
				}
			},
			errorElement : "em",
			errorPlacement : function(error, element) {
				errorPlacement(error, element);
			}
		});
	}

	// methods required for validation
	function errorPlacement(error, element) {

		// Add the 'help-block' class to the error element
		error.addClass("help-block");

		// add the error label after the input element
		error.insertAfter(element);

		// add the has-feedback class to the parent div.validate in order to add
		// icons to inputs
		element.parents(".validate").addClass("has-feedback");
	}
	// --------------------------

});
