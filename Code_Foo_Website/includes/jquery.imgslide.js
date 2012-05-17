/* =========================================================
// jQuery Imageslide Plugin
// Date: November, 2009
// Updated: October, 19th 2010
// Version: 1.2
// Copyright (c) 2009 Blaine Robison
// Website: http://dagrander.com
// Author: Blaine Robison
/* ========================================================= */
(function($){
	$.fn.imgslide = function(options){
		// Declare default values
		var defaults = {
				top : '0px',
				right : '0px',
				bottom : '0px',
				left : '0px',
				duration : 200,
				easeIn : false,
				easeOut : false
			},
			// Override default values if options are passed in
			options = $.extend(defaults, options);
		// Loop through all images being called
		this.each(function(){
			// Declare variables
			var $this		= $(this),
				top 		= options.top,
				right		= options.right,
				bottom		= options.bottom,
				left		= options.left,
				duration	= options.duration,
				easeIn		= options.easeIn,
				easeOut		= options.easeOut;
			// If original value is 'auto' change to 0px. Needed for browsers other than Firefox	
			(($this).css('top') == 'auto')? defTop = '0px' : defTop = ($this).css('top');
			(($this).css('right') == 'auto')? defRight = '0px' : defRight = ($this).css('right');
			(($this).css('bottom') == 'auto')? defBottom = '0px' : defBottom = ($this).css('bottom');
			(($this).css('left') == 'auto')? defLeft = '0px' : defLeft = ($this).css('left');
			// Run animation when hovered
			$this.hover(function(){
				$($this).stop().animate({top:top,right:right,bottom:bottom,left:left},{queue:false,duration:duration,easing:easeIn});					 
			}, function(){
				$($this).stop().animate({top:defTop,right:defRight,bottom:defBottom,left:defLeft},{queue:false,duration:duration,easing:easeOut});					 
			});
		});
	// Ensure chainability	
	return this;
	}
})(jQuery);
