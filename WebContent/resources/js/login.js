	$(window).load(function() {
		$("#forgot").click(function() {
			$("#login").hide(1000);
			// Animation complete.

			$("#frogotform").show(1000);
		});

		$("#back").click(function() {
			$("#frogotform").hide(1000);
			$("#login").show(1000);

		});
	});