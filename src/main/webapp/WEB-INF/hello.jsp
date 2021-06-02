<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ma JSP de demo</title>
</head>
<body>
	<h1>Ma page</h1>

	<p>${ msg }</p>

	${ pageContext.request.contextPath }

	<article class="card">
		<p>${ entity.id } - ${ entity.nom }</p>
	</article>
</body>
</html>