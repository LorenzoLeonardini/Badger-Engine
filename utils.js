alert(navigator.userAgent);

document.body.innerHTML = "<header></header>" + document.body.innerHTML + "<footer class=\"gradient\"></footer>";

$(function()
{
	$('header').load("/Badger-Engine/header.html");
	$('footer').load("/Badger-Engine/footer.html");
});

var lastScrollTop = 0;
var delta = 5;
var navbarHeight = $('header').outerHeight();
var didScroll;
// on scroll, let the interval function know the user has scrolled
$(window).scroll(function(event)
{
	didScroll = true;
});
// run hasScrolled() and reset didScroll status
setInterval(function() 
{
	if (didScroll) 
	{
		hasScrolled();
		didScroll = false;
	}
}, 100);

function hasScrolled() 
{
	var st = $(this).scrollTop();
	if (Math.abs(lastScrollTop - st) <= delta)
		return;

	if ($('#cover').hasClass("visible"))
	{
		lastScrollTop = st;
		return;
	}

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

$('.disabled').click(function(e)
{
	e.preventDefault();
})

$(".headerMobile").load(function()
{
	if(navigator.userAgent.toLowerCase().indexOf('safari') > -1)
		$(".headerMobile").css("top", "-8px");
});
