<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/static/css"></spring:url>
<spring:url var="js" value="/static/js"></spring:url>
<spring:url var="images" value="/static/images"></spring:url>
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
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
</head>

<body>
<div class="wrapper">
<div class="content">
	<!-- Navigation -->
	<%@ include file="./shared/navbar.jsp"%>

	<c:if test="${userHomeClick==true}">
		<!-- Page Content -->
		<%@ include file="main.jsp"%>
		<!-- /.container -->
	</c:if>
	
	<c:if test="${userAboutClick==true}">
		<!-- Page Content -->
		<%@ include file="about.jsp"%>
		<!-- /.container -->
	</c:if>
	<c:if test="${userContactClick==true}">
		<!-- Page Content -->
		<%@ include file="contact.jsp"%>
		<!-- /.container -->
	</c:if>
	
	<c:if test="${userAllProductsClick==true or userCategoryProductsClick==true}">
		<!-- Page Content -->
		<%@ include file="listProducts.jsp"%>
		<!-- /.container -->
	</c:if>
	
	</div>
	<!-- Footer -->
	<%@ include file="./shared/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.js"></script>
	<script src="${js}/popper.js"></script>
	<script src="${js}/bootstrap.js"></script>
	<script src="${js}/myapp.js"></script>

</div>
</body>

</html>