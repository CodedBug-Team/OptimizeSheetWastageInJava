/*
 * jQuery(document) .ready( function() { });
 */
function display() {

	var val = document.getElementById("cd-dropdown");
	val = val.options[val.selectedIndex].value;

	var formURL = "getStrip";
	var postData = 'type=' + encodeURIComponent(val);

	jQuery("#afterradio").hide(1000);
	jQuery("#sheetsize").hide(1000);
	jQuery("#Equation").hide(1000);
	jQuery("#stripsize").show(1000);
	jQuery(".display-strip").show(1000);
	jQuery(".display-sheet").hide(1000);
	jQuery("#paging").show(1000);
	jQuery("#data").show(1000);

	if (val == "both") {
		jQuery.ajax({
			url : formURL,
			type : "POST",
			data : postData,
			success : function(response) {
				displayBoth(response);
			}
		});
	}
	if (val == "Circle") {

		jQuery.ajax({
			url : formURL,
			type : "POST",
			data : postData,
			success : function(response) {
				displayCircle(response);
			}
		});
	}
	if (val == "none") {
		document.getElementById("Bothevalue").innerHTML = '';
		document.getElementById("Cirlcevalue").innerHTML = '';
		jQuery("#Bothevalue").hide(1000);
		jQuery("#Cirlcevalue").hide(1000);
		jQuery("#instrip").hide(1000);
		jQuery("#cuttingSheet").hide(1000);

	}
}

function formSubmit() {
	document.getElementById("logoutForm").submit();
}

function deleteSheet(id) {
	console.log("sheetid: " + id);
	// jQuery.ajax('deleteSheet?sheetId=sheetid', {
	jQuery.ajax('deleteSheet', {
		success : function(response) {
			displaySheets(response);
		},
		data : {
			"sheetId" : id
		}
	});
}

function updateSheet(id) {
	// var MyRows = $('table#sheet_table').find('tbody').find('tr');
	$('table#sheet_table').find('tr').click(function() {
		var arr = new Array();
		
		// alert('You clicked row '+ ($(this).index()+1) );
		// var row=$(this).index()+1;
		var self = $(this);
		arr.push(id);
		var tds = self.children('td');
		for ( var i = 0; i < tds.length; i++) {
			var MyIndexValue = tds[i].innerText;
			arr.push(MyIndexValue);
		}
		// alert(arr);
		
	jQuery.ajax({
		url : 'updateSheet',
		type : "POST",
		data : {updated_value: arr},
		dataType : 'json',
		success : function(response) {
			// if (response.status == "Updated") {
				displaySheets(response);
			// }
		},
		error : function(jqXHR, textStatus, errorThrown) {
		}
	});
	});
}

function updateCircle(id) {
	// var MyRows = $('table#sheet_table').find('tbody').find('tr');
	$('table#circle_table').find('tr').click(function() {
		var arr = new Array();
		
		// alert('You clicked row '+ ($(this).index()+1) );
		// var row=$(this).index()+1;
		var self = $(this);
		arr.push(id);
		var tds = self.children('td');
		for ( var i = 0; i < tds.length; i++) {
			var MyIndexValue = tds[i].innerText;
			arr.push(MyIndexValue);
		}
		//alert(arr);
		
	jQuery.ajax({
		url : 'updateCircle',
		type : "POST",
		data : {updated_value: arr},
		dataType : 'json',
		success : function(response) {
			// if (response.status == "Updated") {
				displayCircle(response);
			// }
		},
		error : function(jqXHR, textStatus, errorThrown) {
		}
	});
	});
}


function updateBoth(id) {
	// var MyRows = $('table#sheet_table').find('tbody').find('tr');
	$('table#both_table').find('tr').click(function() {
		var arr = new Array();
		
		// alert('You clicked row '+ ($(this).index()+1) );
		// var row=$(this).index()+1;
		var self = $(this);
		arr.push(id);
		var tds = self.children('td');
		for ( var i = 0; i < tds.length; i++) {
			var MyIndexValue = tds[i].innerText;
			arr.push(MyIndexValue);
		}
		//alert(arr);
		
	jQuery.ajax({
		url : 'updateBoth',
		type : "POST",
		data : {updated_value: arr},
		dataType : 'json',
		success : function(response) {
			// if (response.status == "Updated") {
				displayBoth(response);
			// }
		},
		error : function(jqXHR, textStatus, errorThrown) {
		}
	});
	});
}


function deleteCircle(id) {
	console.log("circleid: " + id);
	// jQuery.ajax('deleteSheet?sheetId=sheetid', {
	jQuery.ajax('deleteCircle', {
		success : function(response) {
			displayCircle(response);
		},
		data : {
			"circleId" : id
		}
	});
}

function deleteBoth(id) {
	console.log("bothid: " + id);
	jQuery.ajax('deleteBoth', {
		success : function(response) {
			displayBoth(response);
		},
		data : {
			"BothId" : id
		}
	});
}

// display strips when sheet is selected on equation page
function displayStrips(v, sheetid) {
	// jQuery("#cuttingSheet").hide(1000);
	var selectdata = "";
	var cv = v;
	selectdata = "<input type='hidden' value="
			+ sheetid
			+ " name='sheetid'>"
			+ "Enter Tolerance:  <input type='text' id ='tolerance' name='tolerance' value='' required placeholder='Enter Tolerance'/><hr>";
	// jQuery("#Equation").hide(1000);
	jQuery
			.ajax({
				url : 'displayDrop',
				type : "POST",
				data : {
					cdDrop : cv
				},
				success : function(response) {
					selectdata += "<h1>Circle Strip</h1><br/><table class='css-strips' style=width: 100%'><tr><th>Product Name</th><th>Thickness</th><th>Diameter</th><th>Number of Strips to be cut</th></tr>";
					if (response.status == "Got") {
						if (response.result == null) {
						} else {
							for ( var i = 0; i < response.result.length; i++) {
								selectdata += "<tr><td><input name='strip_id' type='checkbox' value='c-"
										+ response.result[i].id
										+ "'>"
										+ response.result[i].productName
										+ "</td><td>"
										+ response.result[i].thikness
										+ "</td><td>"
										+ response.result[i].dimeter
										+ "</td><td>"
										+ "<input type='text' id ='strip_num_circle'"
										+ " name='strip_value_c' value=''/> "
										+ "</td></tr>";
							}
						}
					}
					selectdata += "</table>";

					/* Second Call */
					jQuery
							.ajax({

								url : 'displayDrop2',
								type : "POST",
								data : {
									cdDrop : cv
								},
								success : function(response) {

									if (response.status == "Got") {
										if (response.result == null) {
										} else {
											selectdata += "<br/><h1>Rectangle/Square Strip</h1><br/><table class='css-strips'><tr><th>Product Name</th><th>Length</th><th>Width</th><th>Thickness</th><th>Number of Strips to be cut</th></tr>";
											for ( var j = 0; j < response.result.length; j++) {
												selectdata += "<tr><td><input type='checkbox' name='strip_id' value='r-"
														+ response.result[j].id
														+ "'>"
														+ response.result[j].productName
														+ "</td><td>"
														+ response.result[j].height
														+ "</td><td>"
														+ response.result[j].width
														+ "</td><td>"
														+ response.result[j].thikness
														+ "</td><td>"
														+ "<input type='text' id ='strip_num_rec'"
														+ " name='strip_value_r' value=''/>"
														+ "</td></tr>";
											}
										}
									}
									selectdata += "</table>";
									jQuery("#cuttingSheet").show(100);
									document.getElementById("Bothid").innerHTML = selectdata;
								},
								error : function(jqXHR, textStatus, errorThrown) {
								}
							});
				},
				error : function(jqXHR, textStatus, errorThrown) {
				}
			});
}

function displayBoth(response) {
	document.getElementById("Cirlcevalue").innerHTML = '';
	document.getElementById("Bothevalue").innerHTML = '<input type="text" required id="bheight" name="height" placeholder="Enter  length(mm)">'
			+ '<input type="text" required name="width" id="bwidht" placeholder="Enter  width (mm)">'
			+ '<input type="text" required placeholder="Enter  Thickness (mm)" id="bthickness" Thickness" name="thickness">'
			+ '<input type="text" required placeholder="Enter Product Name" id="bproductName" name="productName">';
	jQuery("#Cirlcevalue").hide(1000);
	jQuery("#Bothevalue").show(1000);
	jQuery("#instrip").show(1000);

	var userInfo = "<h1>Strip Square/Rectangle</h1><table id='both_table' border='3'><tr><th>S.no</th><th>Length (mm)</th><th>Width (mm)</th><th>Thickness (mm)</th><th>ProductName</th><th colspan='2'>Action</th></tr>";
	for ( var i = 0; i < response.result.length; i++) {
		userInfo += "<tr><td>"
				// +
				// response.result[i].id
				+ i
				+ "</td><td contenteditable='true'>"
				+ response.result[i].height
				+ " </td><td contenteditable='true'>"
				+ response.result[i].width
				+ " </td><td contenteditable='true'>"
				+ response.result[i].thikness
				+ " </td><td contenteditable='true'>"
				+ response.result[i].productName
				+ "</td><td><input type='button' id='delete' value='Delete' onclick='deleteBoth("
				+ response.result[i].id + ");' ></td>"
				+ "<td><input type='button' id='update' value='Update' onclick='updateBoth("
				+ response.result[i].id
				+ ");' ></td></tr>";
		/* + " </td></tr>"; */
	}
	document.getElementById("data").innerHTML = userInfo;
}

function displayCircle(response) {
	document.getElementById("Bothevalue").innerHTML = '';
	document.getElementById("Cirlcevalue").innerHTML = '<input type="text" required id="dimeter" name="dimeter" placeholder="Enter  Diameter (mm)">'
			+ '<input type="text" required id="cthickness" placeholder="Enter  Thickness (mm)" name="thickness">'
			+ '<input type="text" required id="cproductName" placeholder="Enter Product Name (mm)" name="productName">';
	jQuery("#Bothevalue").hide(1000);
	jQuery("#Cirlcevalue").show(1000);
	jQuery("#instrip").show(1000);

	var userInfo = "<h1>Strip Circle</h1><table id='circle_table' border='3'><tr><th>S.no</th><th>Dia (mm)</th><th>Thickness (mm)</th><th>ProductName</th><th colspan='2'>Action</th></tr>";
	for ( var i = 0; i < response.result.length; i++) {
		userInfo += "<tr><td>"
				// +
				// response.result[i].id
				+ i
				+ "</td><td contenteditable='true'>"
				+ response.result[i].dimeter
				+ "</td><td contenteditable='true'>"
				+ response.result[i].thikness
				+ "</td><td contenteditable='true'>"
				+ response.result[i].productName
				+ "</td><td><input type='button' id='delete' value='Delete' onclick='deleteCircle("
				+ response.result[i].id + ");' ></td>"
				+ "<td><input type='button' id='update' value='Update' onclick='updateCircle("
				+ response.result[i].id
				+ ");' ></td></tr>";

	}
	document.getElementById("data").innerHTML = userInfo;
}

function displaySheets(response) {
	// response=JSON.parse(response);
	// alert(response.result);
	jQuery("#name").val("");
	jQuery("#height").val("");
	jQuery("#width").val("");
	jQuery("#thickness").val("");
	jQuery("#nos").val("");
	var userInfo = "<h1>Sheet Details</h1><table id='sheet_table'><tr><th>S.no</th><th>Name</th><th>length (mm)</th><th>Width (mm)</th><th>Thickness (mm)</th><th>No Of Sheets</th><th colspan='2'>Action</th></tr>";
	for ( var i = 0; i < response.result.length; i++) {
		userInfo += "<tr><td>"
				// +
				// response.result[i].id
				+ i
				+ "</td><td contenteditable='true' width='300px'>"
				+ response.result[i].sheetName
				+ "</td><td contenteditable='true' width='100px'>"
				+ response.result[i].height
				+ "</td><td contenteditable='true' width='100px'>"
				+ response.result[i].width
				+ " </td><td contenteditable='true' width='100px'>"
				+ response.result[i].thikness
				+ "</td><td contenteditable='true' width='100px'>"
				+ response.result[i].noOfSheets
				+ "</td><td><input type='button' id='delete' value='Delete' onclick='deleteSheet("
				+ response.result[i].id
				+ ");' ></td>"
				+ "<td><input type='button' id='update' value='Update' onclick='updateSheet("
				+ response.result[i].id
				+ ");' ></td></tr>";
		/* + "</td></tr>"; */
	}
	userInfo += "</table>";
	// alert(userInfo);
	document.getElementById("data").innerHTML = userInfo;
	// jQuery("ul.pagination1").quickPagination();
	// jQuery("#paging").show(1000);
	jQuery("#data").show(100);
	// }
	if (response.status == "FAIL") {
		document.getElementById("submitSheet").value = "FAIL";
	}
}

/*
 * This method is uses to display all the sheets with a radio button which on
 * click will display all the strips that can be cut from this sheet
 */

jQuery(document)
		.ready(
				function() {

					jQuery("#stripsizebutton").click(function() {
						jQuery("#data").hide(1000);
						jQuery("#afterradio").hide(1000);
						jQuery("#sheetsize").hide(1000);
						jQuery("#Equation").hide(1000);
						jQuery("#stripsize").show(1000);
						jQuery("#cuttingSheet").hide(1000);
						jQuery("#paging").hide(1000);
						jQuery("#report").hide(1000);
					});

					jQuery("#Equationformula").click(function() {
						jQuery("#data").hide(1000);
						jQuery("#afterradio").hide(1000);
						jQuery("#sheetsize").hide(1000);
						jQuery("#stripsize").hide(1000);
						jQuery("#Equation").show(1000);
						jQuery("#cuttingSheet").hide(1000);
					});

					jQuery("#sheetsizebutton").click(function(e) {
						jQuery("#stripsize").hide(1000);
						jQuery("#afterradio").hide(1000);
						jQuery("#paging").hide(1000);
						jQuery("#Equation").hide(1000);
						jQuery("#sheetsize").show(1000);
						jQuery("#report").hide(1000);
						jQuery("#data").hide(1000);
						jQuery("#cuttingSheet").hide(1000);
						var postData = jQuery(this).serializeArray();
						var formURL = "getSheet";
						jQuery.ajax({
							url : formURL,
							type : "POST",
							data : postData,
							dataType : 'json',
							success : function(response) {
								displaySheets(response);
							},
							error : function(jqXHR, textStatus, errorThrown) {
								console.log(textStatus, errorThrown);
								console.log(jqXHR.error);
							}
						});
						 e.preventDefault();
						 e.unbind();
					});

					jQuery("#AddSheet").submit(function(e) {
						var postData = jQuery(this).serializeArray();
						var formURL = jQuery(this).attr("action");
						jQuery.ajax({
							url : formURL,
							type : "POST",
							data : postData,
							dataType : 'json',
							success : function(response) {
								if (response.status == "Updated") {
									displaySheets(response);
								}
							},
							error : function(jqXHR, textStatus, errorThrown) {

							}
						});
						e.preventDefault();
						e.unbind();
					});

					jQuery("#AddStrip")
							.submit(
									function(e) {
										var postData = jQuery(this)
												.serializeArray();
										var formURL = jQuery(this).attr(
												"action");
										jQuery
												.ajax({
													url : formURL,
													type : "POST",
													data : postData,
													dataType : 'json',
													success : function(response) {
														if (response.status == "BUpdated") {
															displayBoth(response);
															jQuery("#data")
																	.show(1000);
														}

														if (response.status == "CUpdated") {
															displayCircle(response);
															jQuery("#data")
																	.show(1000);
														}
														if (response.status == "FAIL") {
															document
																	.getElementById("strip").value = "FAIL";
														}

													},
													error : function(jqXHR,
															textStatus,
															errorThrown) {

													}
												});
										e.preventDefault();
										e.unbind();
									});
					jQuery("#getData")
							.submit(
									function(e) {
										var postData = jQuery(this)
												.serializeArray();
										var formURL = jQuery(this).attr(
												"action");
										jQuery
												.ajax({
													url : formURL,
													type : "POST",
													data : postData,
													success : function(response) {
														if (response.status == "Got") {
															// jQuery("#findthickness").val("");
															var userInfo = "";
															if (response.result == null) {

																userInfo = "<h1>Not Result Found<h1>";
																document
																		.getElementById("data").innerHTML = userInfo;

																jQuery("#data")
																		.show(
																				100);
															}
															userInfo = "<h1>Sheet Details</h1><table border='3'><tr><th>Click</th><th>Name</th><th>Thickness (mm)</th><th>Width (mm)</th><th>Length (mm)</th><th>No. Of Sheets</th></tr>";
															for ( var i = 0; i < response.result.length; i++) {

																userInfo += "<tr><td><input type='radio' id='radioid"
																		+ i
																		+ "' name='findvalue' value='"
																		+ response.result[i].thikness
																		+ "' onclick='displayStrips(this.value,"
																		+ response.result[i].id
																		+ ");'></td><td>"
																		/*
																		 * +
																		 * ");globalfunction(" +
																		 * response.result[i].height +
																		 * "," +
																		 * response.result[i].width +
																		 * ");'></td><td>"
																		 */

																		+ response.result[i].sheetName
																		+ " </td><td>"
																		+ response.result[i].thikness
																		+ " </td><td>"
																		+ response.result[i].width
																		+ " </td><td>"
																		+ response.result[i].height
																		+ "</td><td>"
																		+ response.result[i].noOfSheets
																		+ " </td></tr>";
															}
															userInfo += "</table>";
															document
																	.getElementById("data").innerHTML = userInfo;

															jQuery("#data")
																	.show(1000);

														}

													},
													error : function(jqXHR,
															textStatus,
															errorThrown) {

													}
												});
										e.preventDefault();
										e.unbind();
									});
				});