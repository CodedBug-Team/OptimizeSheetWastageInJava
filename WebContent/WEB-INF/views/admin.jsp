<%-- <%@page session="true"%> --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix='security'
	uri='http://www.springframework.org/security/tags'%>

<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="resources/images/favicon.png" />
<title>Sheet Cutting</title>
<meta name="viewport" content="width=device-width, initial-scale=1">


<link href="<c:url value="resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="resources/css/styles1.css" />" rel="stylesheet">

<script src="<c:url value="/resources/js/jquery-2.1.3.min.js" />"></script>
<script src="<c:url value="/resources/js/custom.js" />"></script>

<c:url value="/j_spring_security_logout" var="logoutUrl" />

<body>
	<!--start-login-form-->
	<form action="${logoutUrl}" method="post" id="logoutForm"></form>
	<div class="main">

		<div class="login-head">
			<h1>Admin Panel</h1>
			<h3 style="text-align: center;">All the size should be entered
				in mm.</h3>

		</div>
		<div class="wrap">
			<div class="buttonclass">
				<!-- <input type="submit" id="sheetsizebutton" value="Sheet Size" onclick="getSheet()"/> -->
				<!-- <input type="submit" formmethod="get" id="sheetsizebutton"
					value="Sheet Size" onclick="location.href='getSheet'"
					value="getSheet" /> -->
				<input type="submit" formmethod="GET" id="sheetsizebutton"
					value="Sheet Size" /> <input type="submit" formmethod="GET"
					id="stripsizebutton" value="Strip Size" /> <input type="submit"
					formmethod="GET" id="Equationformula" value="Equation" />
				<div class="buttonclass">
					<input type="submit" value="Logout" onclick="formSubmit()" />
				</div>
			</div>
			<hr>
			<div id="sheetsize" style="display: none;">
				<div class="Regisration">
					<div class="Regisration-head">
						<h2>
							<span></span>Sheet Size
						</h2>
					</div>
					<form action="addSheet" id="AddSheet" method="post">
					<input type="text" name="name" id="name" required
							placeholder="Enter Sheet Name ">
						<input type="text" name="height" id="height" required
							placeholder="Enter Sheet length (mm)"> <input type="text"
							name="width" required id="width"
							placeholder="Enter Sheet width (mm)"> <input type="text"
							placeholder="Enter Sheet Thickness (mm)" id="thickness" required
							name="thikness"> <input type="text"
							placeholder="Enter Number of Sheet " id="nos" required name="nos">
						<div class="Remember-me">
							<div class="submit">
								<input id="submitSheet" type="submit" value="Add Now">
							</div>
							<div class="clear"></div>
						</div>
					</form>
				</div>
			</div>
			<!-- <div class="display-sheet" style="display: none;">
				<div class="">
					<div id="paging" style="display: none;">
						<span class="pagination1" id="data"> </span>
					</div>
				</div>
			</div> -->
			<!-- Sheet Size End -->

			<div id="stripsize" style="display: none;">
				<div class="Regisration">

					<div class="Regisration-head">
						<h2>
							<span></span>Strip Size
						</h2>
					</div>
					<form id="AddStrip" action="addStips" method="post">
						<select id="cd-dropdown" name="select" form="getSheet"
							style="height: 40px; width: 50%; font-size: 100%;"
							onchange="display();">
							<option value="none" selected>Select</option>
							<option value="Circle">Circle</option>
							<option value="both">Square/Rectangle</option>
						</select>
						<div id="Cirlcevalue"></div>
						<div id="Bothevalue"></div>

						<div class="Remember-me">
							<div class="submit" id="instrip" style="display: none;">
								<input type="submit" id="strip" value="Add Now">
							</div>
							<div class="clear"></div>
						</div>
					</form>
				</div>
			</div>

			<!-- <div class="display-strip" style="display: none;">
				<div class="">
					<div id="paging" style="display: none;">
						<span class="pagination1" id="data"> </span>
					</div>
				</div>
			</div> -->

			<div id="Equation" style="display: none;">
				<div class="Regisration">

					<div class="Regisration-head">
						<h2>
							<span></span>Sheet Size
						</h2>
					</div>
					<form id="getData" action="getData">
						<input type="text" placeholder="Enter Sheet Thickness (mm)"
							id="findthickness" required name="thikness">
						<div class="Remember-me">
							<div class="submit" id="getButton">
								<input type="submit" value="Find">
							</div>
							<div class="clear"></div>
						</div>
					</form>
				</div>
			</div>

			<div id="data" style="display: none;" align="center"></div>

			<div id="cuttingSheet" style="display: none;">
				<form id="CuttingSheetCall" action="cutting" method="post" target="_blank">
					<div id="Bothid"></div>
					<div class="buttonclass">
						<input type="submit" value="Optimize Now">
					</div>
				</form>
			</div>

			<div id="cuttt"></div>
			<div id="set"></div>
			<div id="set1"></div>
		</div>
	</div>

	<%-- <%@ include file="report.jsp" %> --%>
	<!-- <div class="report" id="report" style="display: none;">
		<div class="summary" id="summary">
		</div>
		<div class="sheet" id="sheet">
			<ul class="ruler" id="ruler" data-items="40"></ul>
			<ul class="rulery" id="rulery" data-items="10"></ul>
		</div>
		<div id="visual"></div>
	</div> -->
	
	
	
	<!--
ref:
http://jsfiddle.net/thirdender/kwcug/
http://www.translatorscafe.com/cafe/EN/units-converter/typography/4-8/millimeter-pixel_(Y)/
 
 -->

</body>
</html>