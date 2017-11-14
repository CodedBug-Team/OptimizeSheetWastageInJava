<%-- <%@page session="true"%> --%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix='security'
	uri='http://www.springframework.org/security/tags'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="resources/images/favicon.png" />
<title>Sheet Cutting - Results</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<c:url value="resources/css/report.css" />" rel="stylesheet">
<link href="<c:url value="resources/css/jquery.ui.ruler.css" />"
	rel="stylesheet">

<script src="<c:url value="/resources/js/jquery-2.1.3.min.js" />"></script>

<%-- <script src="<c:url value="/resources/js/modernizr-latest.js" />"></script>
<script src="<c:url value="/resources/js/ruler.js" />"></script> --%>

<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.ui.ruler.js" />"></script>

<script src="<c:url value="/resources/js/wz_jsgraphics.js" />"></script>



<%-- <script src="<c:url value="/resources/js/report.js" />"></script> --%>

<%@ page isELIgnored="false"%>
<c:url value="/j_spring_security_logout" var="logoutUrl" />
<body>
	<span class="report" id="report">
		<!-- <span class="note">NOTE: The drawing is scale down to 50%. This
			means if original length is 2500 mm then it will be displayed as 1250
			mm and if height is 1600 mm then it will be displayed as 800 mm. </span> -->
		<span class="summary">
			<h5>SUMMARY</h5>
			<u>SHEET DESCRIPTION</u> <br> Sheet Name -
			<c:out value="${SheetName}"></c:out>
			<br> Sheet Dimension-
			<c:out value="${SheetDimension}"></c:out>
			<br> Sheet Area-
			<c:out value="${TotalSheetArea}"></c:out>
			mm&sup2; <br> Waste Area-
			<c:out value="${TotalWastage}"></c:out>
			mm&sup2; <br> Waste Percentage-
			<c:out value="${WastePercent}"></c:out>
			<br> Tolerance-
			<c:out value="${Tolerance/2}"></c:out>
		</span>

		<span class="summary">
		<br><br>
			<u>Circle Description </u>
			<c:if test="${CircleStripDescription.name != 'null'}">
				<br> Circle Strips: <br>
				<c:forEach var="CircleStripDescription"
					items="${CircleStripDescription}">
			&nbsp;&nbsp; ${CircleStripDescription.key} - 
			<c:forEach items="${CircleStripDescription.value}" var="item"
						varStatus="loop">
        		${item} ${!loop.last ? ', ' : ''}
    		</c:forEach>
					<br>
				</c:forEach>
			</c:if>
		</span>

		<span class="summary">
		<br><br>
		<u>Rectangular or Square Description</u>
			<c:if test="${BothStripDescription.name != 'null'}">
				<br> Rectangular or Square Strips: <br>
				<c:forEach var="BothStripDescription"
					items="${BothStripDescription}">
			&nbsp;&nbsp; ${BothStripDescription.key} - 
			<c:forEach items="${BothStripDescription.value}" var="item"
						varStatus="loop">
        		${item} ${!loop.last ? ', ' : ''}
    		</c:forEach>
					<br>
				</c:forEach>
			</c:if>
			<br>
		</span>
		<%-- <div class="sheet" id="sheet">
			<ul class="ruler" id="ruler"
				data-items="<c:out value="${fn:trim(SheetLength)}"></c:out>"></ul>
			<ul class="rulery" id="rulery"
				data-items="<c:out value="${fn:trim(SheetWidth)}"></c:out>"></ul>
		</div> --%>

		<!-- <input type="submit" value="save" name="save" onclick="keypress(save)" /> -->

	</span>
	

	<div id="visual"
		style="position: absolute;  top: 240px; left: auto; width: ${fn:trim(SheetLength)+25}px; height: ${fn:trim(SheetWidth)+25}px;"></div>


	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var scaling = 1;
							/* jQuery('body').ruler(
									{unit: 'px',
									    tickMajor: 10,
									    tickMinor: 5,
									    tickMicro: 1,
									    showLabel: true,
									    arrowStyle:'arrow'
									}); */
							jQuery('#visual').ruler({
								showLabel : true,
								arrowStyle : 'arrow'
							});

							//$("#visual").ruler();
							//alert("${StripDimension.type}");
							// Build "dynamic" rulers by adding items
							/* jQuery(".ruler[data-items]").each(
									function() {
										var ruler = jQuery(this).empty();
										//var len = Number(ruler.attr("data-items")) || 0;
										var len = "${SheetLength}" || 0;
										//len = len / scale;
										var item = jQuery(document
												.createElement("li"));
										var i;
										for (i = 0; i < len; i++) {
											//ruler.append(item.clone().text(i + 1));
											ruler.append(item.clone());
										}
									});
							jQuery(".rulery[data-items]").each(
									function() {
										var rulery = jQuery(this).empty();
										//var len = Number(rulery.attr("data-items")) || 0;
										var len = "${SheetWidth}" || 0;
										//len = len / scale;
										var item = jQuery(document
												.createElement("li"));
										var i;
										for (i = 0; i < len; i++) {
											//rulery.append(item.clone().text(i + 1));
											rulery.append(item.clone());
										}
									}); */

							var tolerance = parseInt("${fn:trim(Tolerance)}");
							var cnv = document.getElementById("visual");
							var jg = new jsGraphics(cnv);
							//var jg = new top.jsGraphics(cnv);

							var top = 19;
							var left = 19;

							left = left + tolerance / 2;
							top = top + tolerance / 2;

							var y = top; // top
							var x = left; // left

							//var display = "${StripDimension}";
							var type = "${StripDimension.type}";
							type = type.split("[");
							type = type[1];
							type = type.split("]");
							type = type[0];
							type = type.split(",");

							var height = "${StripDimension.height}";
							height = height.split("[");
							height = height[1];
							height = height.split("]");
							height = height[0];
							height = height.split(",");

							var width = "${StripDimension.width}";
							width = width.split("[");
							width = width[1];
							width = width.split("]");
							width = width[0];
							width = width.split(",");

							var number = "${StripDimension.number}";
							number = number.split("[");
							number = number[1];
							number = number.split("]");
							number = number[0];
							number = number.split(",");

							for ( var i = 0; i < type.length; i++) {
								if (type[i].trim() == "R") {
									//var color=getRandomColor();
									for ( var circle_loop = 0; circle_loop < number[i]; circle_loop++) {
										jg.setColor("blue"); // blue
										jg.fillRect(x, y, parseInt(height[i]
												.trim())
												/ scaling, parseInt(width[i]
												.trim())
												/ scaling);

										jg.setColor("black"); // blue
										jg.drawRect(x, y, parseInt(height[i]
												.trim())
												/ scaling, parseInt(width[i]
												.trim())
												/ scaling);

										// x = x + elements[i].width;
										y = y + parseInt(width[i].trim())
												/ scaling + tolerance / scaling;

										console.log(("x: " + x + " y: " + y));
									}
									x = x + parseInt(height[i].trim())
											/ scaling + tolerance / scaling;
									y = top;
									console.log(("x: " + x + " y: " + y));
								} else if (type[i].trim() == "C") {
									//var color=getRandomColor();
									for ( var rectanlge_loop = 0; rectanlge_loop < number[i]; rectanlge_loop++) {

										jg.setColor("yellow"); // red
										jg.fillEllipse(x, y, parseInt(height[i]
												.trim())
												/ scaling, parseInt(width[i]
												.trim())
												/ scaling);

										jg.setColor("black"); // red
										jg.drawEllipse(x, y, parseInt(height[i]
												.trim())
												/ scaling, parseInt(width[i]
												.trim())
												/ scaling);

										// x = x + elements[i].width;
										y = y + parseInt(height[i].trim())
												/ scaling + tolerance / scaling;

										console.log(("x: " + x + " y: " + y));
									}
									x = x + parseInt(width[i].trim()) / scaling
											+ tolerance / scaling;
									y = top;
								}
							}
							//jg.setColor("#fff");
							jg.paint();
							//jg.clear();

						});
	</script>

</body>
</html>

<!--
ref:
http://jsfiddle.net/thirdender/kwcug/
http://www.translatorscafe.com/cafe/EN/units-converter/typography/4-8/millimeter-pixel_(Y)/
 
 -->