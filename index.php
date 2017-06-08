<!DOCTYPE html>
<html>
<head>
	<link rel="shortcut icon" type="image/png" href="https://lorenzoleonardini.altervista.org/github/Badger-Engine/logo128.png">
	<title>Badger-Engine</title>
	<link href='https://fonts.googleapis.com/css?family=Roboto|Open+Sans:100,200,300,400' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="graphics.css">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript">
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
	</script>
</head>
<body>
<header>
	THIS-IS-TEMPORARY--THIS-IS-TEMPORARY--THIS-IS-TEMPORARY--THIS-IS-TEMPORARY--THIS-IS-TEMPORARY--THIS-IS-TEMPORARY
</header>
<center>
<div class="content">
	<div id="title">
		<img src="https://lorenzoleonardini.altervista.org/github/Badger-Engine/logo64.png">Badger-Engine
	</div>
	<p>
		Badger-Engine wants to be a 2D & 3D Game Engine written in Java. Right now the only part in development is the 2D one. The Physics Engine is made from scratch and so the Graphics one, which uses <a href="https://www.opengl.org/" target="_blank">OpenGL</a> with the help of <a href="https://lwjgl.org" target="_blank">LWJGL 3</a>. <a href="https://openal.org" target="_blank">OpenAL</a> is used from this library, too.
	</p>
	<p>
		Right now the Engine is under development and this means that all the features described could be not implemented yet. Please check the <a href="#todo">TODO</a> list in the bottom of the page and don't hesitate to contact me if you want to know something.
	</p>
	<p>
		<em>
		NOTE: This website graphics is clearly taken from <a href="https://lwjgl.org" target="_blank">LWJGL 3</a>, simply because it's wonderfully clean and lovely.
		</em>
	</p>

	<h3 id="version">Current Version</h3>
	<p>
		The current version is <a href="https://github.com/LorenzoLeonardini/Badger-Engine/releases/tag/v0.3Beta" target="_blank">0.3Beta</a>. It mainly adds collision between moving circles. Still need to fix a bug that causes not moving circles to not really collide well. You can see the exact changelog <a href="https://github.com/LorenzoLeonardini/Badger-Engine/releases/tag/v0.3Beta" target="_blank">here</a>. Remember to follow the development on the <a href="https://github.com/LorenzoLeonardini/Badger-Engine/" target="_blank">GitHub page</a>.
	</p>
	<p class="centered">
		<video loop autoplay="autoplay" muted>
			<source src="bounce.mp4" type="video/mp4">
			Your browser does not support the video tag.
		</video>
	</p>

	<h3 id="requirements">Requirements</h3>
	<p>
		This Engine uses <a href="https://www.opengl.org/" target="_blank">OpenGL 3</a>. Make sure your graphics card (and all your target cards) supports it.
	</p>
</div>

<div class="gradient">
	<h3 id="badger">Why "Badger"?</h3>
	<p>
		Some of you are probably wondering why I've chosen "Badger" for naming this Engine. As many other projects in the world, this one is dedicated to a very special person, who's represented by this name. Only a few will know exactly who I'm referring to and that's the actual point: only the bests know the <i>private</i> story behind it.
	</p>
</div>

<div class="content">
	<h3 id="todo">TODO List</h3>
	<p>
		Here you can find the complete list of features/bug fixes I'm currently working on for the new version:
		<ul>
			<li>Switching to OpenGL</li>
			<li>Bug fixes:</li>
			<ul>
				<li>Circle bouncing bug</li>
			</ul>
			<li class="checked">Just a test</li>
		</ul>
	</p>

	<h3 id="licence">Licence</h3>
	<p>
		You are free to:
		<ul>
			<li>modify this Engine and use it for a personal, private project</li>
			<li>use this Engine without any modification for a public non-commercial project</li>
			<li>study the code for a learn scope</li>
		</ul>
	</p>
	<p>
		<strong>If you want to use this Engine for a commercial project you must ask me for a permission.</strong><br />
		<strong><i>Any other used that is not specified here is ABSOLUTELY NOT ALLOWED and you MUST NOT do it.</i></strong><br />
		<i>If you need to discuss this very strict licence you can contact me at <strong>dev.lorenzoleonardini [ @ ] gmail . com</strong></i>
	</p>
</div>
</center>
<footer class="gradient">
BANANA
</footer>
</body>
</html>
