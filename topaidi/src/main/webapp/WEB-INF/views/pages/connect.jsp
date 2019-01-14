<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../template/header.jsp"></jsp:include>
<spring:url value="/connect" var="url"></spring:url>
<div class="container">
	<div class="row">
		<div class="col-sm text-center">
			<h1 class="spaceTitle">CONNECT</h1>
		</div>
	</div>
	<form:form method="post" action="${url}" modelAttribute="user">
		<form:errors path="email" cssStyle="color:red;"/><br>
		<form:label path="email">Email : </form:label>
		<form:input path="email" cssClass="form-control" type="email" style="${errorClass}"/>
		<form:errors path="password" cssStyle="color:red;"/><br>
		<form:label path="password">Password : </form:label>
		<form:input path="password" cssClass="form-control" type="password" style="${errorClass}"/>
		<br>
		<input type="submit" value="Connect"/>
		<br>
		<br>
		<a href="#">Forgot password ?</a> or <a href="register">Not registered yet ?</a>
	</form:form>
</div>
<jsp:include page="../template/footer.jsp"></jsp:include>