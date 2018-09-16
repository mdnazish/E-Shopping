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

	default:
		$('.products').addClass('active');
		$('#active_'+menu).addClass('active');
		break;
	}
});