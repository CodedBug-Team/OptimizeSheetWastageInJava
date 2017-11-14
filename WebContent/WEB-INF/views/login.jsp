<!DOCTYPE html>
<html>
<head>
<title>Sheet Cutting</title>

<link rel="shortcut icon" href="resources/images/favicon.png">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="<c:url value="resources/css/login.css" />" rel="stylesheet">
<link href="<c:url value="resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="resources/css/styles1.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-2.1.3.min.js" />"></script>


</head>
<body>
	<!--start-login-form-->
	<div class="main">
		<div class="login-head"></div>
		<div class="wrap">

			<div class="Login" id="login">
				<div class="Login-head">
					<h3>LOGIN</h3>
				</div>

				<form name='loginForm'
					action="<c:url value='j_spring_security_check' />" method='POST'>
					<div class="ticker">
						<h4>Username</h4>
						<input type="email" name="username" placeholder="Enter Your Email"
							required /><span> </span>
						<div class="clear"></div>
					</div>
					<div>
						<h4>Password</h4>
						<input type="password" name="password"
							placeholder="Enter Password" required />
						<div class="clear"></div>
					</div>


					<div class="submit-button">
						<input type="submit" value="Login"> <input type="button"
							value="Forgot" id="forgot">
					</div>



					<div class="clear"></div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

			</form>
		</div>
		<div class="Login" id="frogotform" style="display: none;">
			<div class="Login-head">
				<h3>Forgot Password</h3>
			</div>

		</div>
	</div>

	<!--//End-login-form-->
	<div class="copy-right">
		<p>
			Developed by <a href="http://p3lang.com">P3lang</a>
		</p>
	</div>
</body>
</html>
