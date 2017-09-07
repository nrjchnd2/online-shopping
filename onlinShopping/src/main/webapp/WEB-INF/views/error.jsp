<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/static/css"></spring:url>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - ${title}</title>
<script>
window.menu='${title}';
window.contextRoot='${contextRoot}';

</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->

<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<link href="${css}/myapp.css" rel="stylesheet">
</head>

<body>
<div class="wrapper">
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
<div class="container">
<div class="navbar=header">
<a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
</div>
</div>


<div class="content">
	<div class="container">
	<div class="row">
	<div class="col-xs-12">
	<div class="jumbotron">
	<h1>${errorTitle}</h1>
	<hr>
	<blockquote>
	${errorDescription}
	</blockquote>
	</div>
	</div>
	</div>
	</div>
	
	</div>
	<!-- Footer -->
	<%@ include file="./shared/footer.jsp"%>

</div>
</body>

</html>1