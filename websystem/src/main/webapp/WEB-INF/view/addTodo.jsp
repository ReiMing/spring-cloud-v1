<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<html>
	<title>Add todo page</title>
	<link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css"
        rel="stylesheet">
     <%@include file="common/header.jsp" %>   
	<body>
		<div class="container">
			<h1>Add TODO</h1><p>
			<form:form action="/add-todo" method="post" modelAttribute="todo">
				Desctiption:<form:input path="description"/>
				<form:errors path="description" cssClass="text-warning"/>
				<form:input type="hidden" path="id"/>
				<input type="submit" value="submit" class="btn btn-success"/>
				
			</form:form>
		</div>
		<script src="webjars/jquery/3.6.4/jquery.min.js"></script>
		<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
	</body>
</html>