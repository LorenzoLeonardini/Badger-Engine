document.body.innerHTML = "<header></header>" + document.body.innerHTML + "<footer class=\"gradient\"></footer>";

$(function()
{
	$('header').load("header.html");
	$('footer').load("footer.html");
});

var lastScrollTop = 0;
var delta = 5;
var navbarHeight = $('header').outerHeight();
// on scroll, let the interval function know the user has scrolled
$(window).scroll(function(event)
{
	hasScrolled();
});

function hasScrolled() 
{
	var st = $(this).scrollTop();
	if (Math.abs(lastScrollTop - st) <= delta)
		return;

	// If current position > last position AND scrolled past navbar...
	if (st > lastScrollTop && st > navbarHeight)
	{
		// Scroll Down
		$('header').removeClass('nav-down').addClass('nav-up');
	}
	else
	{
		// Scroll Up
		// If did not scroll past the document (possible on mac)...
		if(st + $(window).height() < $(document).height())
			$('header').removeClass('nav-up').addClass('nav-down');
	}

	lastScrollTop = st;
}