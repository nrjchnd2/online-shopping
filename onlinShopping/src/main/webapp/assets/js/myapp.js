$(function() {
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All products':
		$('#listProducts').addClass('active');
		break;

	default:
	case 'Home':
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
});