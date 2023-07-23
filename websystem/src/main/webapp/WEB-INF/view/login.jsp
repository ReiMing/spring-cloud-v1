<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<title>Login page</title>
	
	
	<link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css"
        rel="stylesheet">
    
	<body>
		<div class="container">
			<h1>sign in</h1><p>
			<c:if test="${not empty errorMessage}">
				<div class="alert alert-danger alert-dismissible fade show">${errorMessage}</div>
			</c:if>
			<form action="/welcome">
				<div class="form-group">name:<input name="name" class="form-control"></div><p>
				<div class="form-group">password:<input name="password" class="form-control"></div><p><p>
				<input type="submit" value="Submit" class="btn btn-success">
			</form>
		</div>
		<script src="webjars/jquery/3.6.4/jquery.min.js"></script>
		<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
	</body>
</html>