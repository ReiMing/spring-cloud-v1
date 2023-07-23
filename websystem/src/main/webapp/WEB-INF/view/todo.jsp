<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<title>Todo page</title>
	
	
	<link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css"
        rel="stylesheet">
    <%@include file="common/header.jsp" %>
	<body>
		<div class="container">
			<h1>Your TODOs</h1><p>
			<table class="table table-striped">
				<tbody>
				<tr><th>Description</th><th>Date</th><th>Done</th><th></th><th></th></tr>
				<c:forEach items="${todos}" var="todo">
				<tr>
					<td><c:out value="${todo.description}"></c:out></td>
					<td><c:out value="${todo.date}"></c:out></td>
					<td><c:out value="${todo.done}"></c:out></td>
					<td><a class="btn btn-warning" href="/delete-todo?id=${todo.id}">delete</a></td>
					<td><a class="btn btn-success" href="/update-todo?id=${todo.id}">update</a></td>
				</tr>
				</c:forEach>
				</tbody>
			</table>
			<a href="add-todo" class="btn btn-success">ADD TODO</a>
		</div>
		<script src="webjars/jquery/3.6.4/jquery.min.js"></script>
		<script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
	</body>
</html>