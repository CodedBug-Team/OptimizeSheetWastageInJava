function displayReport(elements) {
	jQuery("#report").show();
	jQuery("#sheet").removeData();
	jQuery("#summary").empty();
	jQuery("#ruler").empty();
	jQuery("#rulery").empty();
	jQuery("#visual").empty();

	// jQuery.removeData( div, "test1" );

	console.log("Tolerance: " + elements.result.Tolerance);
	console.log("Total Sheet Area: " + elements.result.TotalSheetArea);
	console.log("Total Wastage: " + elements.result.TotalWastage);
	console.log("Waste Percent: " + elements.result.WastePercent);
	console.log("Sheet Name: " + elements.result.SheetName);
	console.log("Sheet Dimension: " + elements.result.SheetDimension);

	console.log(elements.result.CircleStripDescription.name);
	console.log(elements.result.BothStripDescription.name);
	
	var scale=elements.result.Scaling;

	var summary = " <h1>SUMMARY</h1>"
		+ "<br>*******SHEET DESCRIPTION*******<br> "
		+ "<br> Sheet Name- "
		+ elements.result.SheetName
		+ "<br> Sheet Dimension- "
		+ elements.result.SheetDimension
		+ "<br> Sheet Area- "
		+ elements.result.TotalSheetArea
		+ "mm&sup2;"
		+ "<br> "
			+ "<br> Waste Area - "
			+ elements.result.TotalWastage
			+ "mm&sup2;"
			+ "<br> Waste Percentage - "
			+ elements.result.WastePercent
			+ "<br> Tolerance- "
			+ elements.result.Tolerance
			
			+ "<br><br>*******STRIPS DESCRIPTION*******<br><br> ";
			
	 if(typeof elements.result.CircleStripDescription.name != 'undefined'){
		 summary+="CIRCLE STRIPS<br><br> ";
	 
			for ( var i = 0; i < elements.result.CircleStripDescription.name.length; i++) {
			summary+="Name - "
			+ elements.result.CircleStripDescription.name[i]
			
			+ ",&nbsp   Diameter - "
			+ elements.result.CircleStripDescription.diameter[i]
			
			+ ", &nbsp  Thickness - "
			+ elements.result.CircleStripDescription.thickness[i]
			
			+ ", &nbsp  Number of Circle Strips - "
			+ elements.result.CircleStripDescription.numberofCircleStrips[i]
			+"<br> ";
			}
	 }
	 if(typeof elements.result.BothStripDescription.name != 'undefined'){
		 summary+="<br>BOTH STRIPS<br><br> ";	
			for ( var i = 0; i < elements.result.BothStripDescription.name.length; i++) {
		    summary+="Name - "
			+ elements.result.BothStripDescription.name[i]
			
			+ ", &nbsp  Width - "
			+ elements.result.BothStripDescription.width[i]
			
			+ ", &nbsp  Height - "
			+ elements.result.BothStripDescription.height[i]
			
			+ ", &nbsp  Thickness - "
			+ elements.result.BothStripDescription.thickness[i]
			
			+ ", &nbsp  Number of Rectangle/Square Strips - "
			+ elements.result.BothStripDescription.numberofBothStrips[i]
			+"<br> ";
			}
	 }
		    summary+= "<div class=\"buttonclass\">"
			+ "<input type=\"submit\" onclick=\"print()\" value=\"Print this page\""
			+ "onclick=\"formSubmit()\" />";

	document.getElementById("summary").innerHTML = summary;

	//$("#sheet").css({"height": elements.result.SheetLength, "width": elements.result.SheetWidth});
	jQuery("#sheet").height(elements.result.SheetLength);
	jQuery("#sheet").width(elements.result.SheetWidth);
	
	// Build "dynamic" rulers by adding items
	jQuery(".ruler[data-items]").each(function() {
		var ruler = jQuery(this).empty();
		//var len = Number(ruler.attr("data-items")) || 0;
		var len= elements.result.SheetLength || 0;
		len=len/scale;
		var item = jQuery(document.createElement("li"));
		var i;
		for (i = 0; i < len; i++) {
			ruler.append(item.clone().text(i + 1));
		}
	});
	jQuery(".rulery[data-items]").each(function() {
		var rulery = jQuery(this).empty();
		//var len = Number(rulery.attr("data-items")) || 0;
		var len=elements.result.SheetWidth || 0;
		len=len/scale;
		var item = jQuery(document.createElement("li"));
		var i;
		for (i = 0; i < len; i++) {
			rulery.append(item.clone().text(i + 1));

		}
	});
	
	var tolerance = elements.result.Tolerance;
	var cnv = document.getElementById("visual");
	var jg = new jsGraphics(cnv);
	
	var top = 718;
	/*var top = 355;*/
	var left = 38;

	var y = top; // top
	var x = left; // left

	/*console.log("elements.result.StripDimension: "
			+ elements.result.StripDimension.type[0]);*/
	

	var display = elements.result.StripDimension;
	
	console.log("Display all elements: " + display);
	
	/*console.log("type: " + display.type[0] + "\tdisplay.type.length: "
			+ display.type.length);*/
	/*console.log("type: " + circleDisplay.type[0] + "\tdisplay.type.length: "
			+ circleDisplay.type.length);
	console.log("type: " + bothDisplay.type[0] + "\tdisplay.type.length: "
			+ bothDisplay.type.length);*/

	for ( var i = 0; i < display.type.length; i++) {
		console.log("Type: " + display.type[i] + " height: "
				+ display.height[i] + " Width: " + display.width[i]
				+ "Number: " + display.number[i]);

		if (display.type[i] == "R") {
			//var color=getRandomColor();
			for ( var circle_loop = 0; circle_loop < display.number[i]; circle_loop++) {
				jg.setColor("blue"); // blue
				jg.fillRect(x, y, display.height[i], display.width[i]);

				// x = x + elements[i].width;
				y = y + display.width[i] + tolerance;
				console.log(("x: " + x + " y: " + y));
			}
			x = x + display.height[i] + tolerance;
			y = top;
			// alert("x: " + x + " y: " + y);
			console.log(("x: " + x + " y: " + y));
		}
	else if (display.type[i] == "C") {
		//var color=getRandomColor();
	for ( var rectanlge_loop = 0; rectanlge_loop < display.number[i]; rectanlge_loop++) {
		jg.setColor("yellow"); // red
		jg.fillEllipse(x, y, display.height[i], display.width[i]);
		// x = x + elements[i].width;
		y = y + display.height[i] + tolerance;
	}
	x = x + display.width[i] + tolerance;
	y = top;
	console.log(("x: " + x + " y: " + y));

}
	}
	jg.setColor("#fff");
	jg.paint();
	//jg.clear();
	//elements = "";
}

// Change the spacing programatically
function changeRulerSpacing(spacing) {
	jQuery(".ruler").css("padding-right", spacing).find("li").css("padding-left",
			spacing);
	jQuery(".ruler").css("padding-top", spacing).find("li").css("padding-bottom",
			spacing);
}
jQuery("#spacing").change(function() {
	changeRulerSpacing(jQuery(this).val());
});

	function getRandomColor() {
    var letters = '0123456789ABCDEF'.split('');
    var color = '#';
    for (var i = 0; i < 6; i++ ) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

/*
 * ref: http://jsfiddle.net/j8DBw/
 * http://stackoverflow.com/questions/6386438/how-to-foreach-into-a-multidimensional-array-with-jquery-strange-behaviour
 * http://www.walterzorn.de/en/jsgraphics/jsgraphics_e.htm
 * http://api.jquery.com/position/ http://jsfiddle.net/AMsK9/
 * http://api.jquery.com/category/manipulation/
 * http://www.sanwebe.com/2011/01/jquery-ajax-methods-to-display-json-data
 */
