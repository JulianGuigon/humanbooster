<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../template/header.jsp"></jsp:include>
<spring:url value="/post" var="url"></spring:url>
<div class="container">
	<div class="row">
		<div class="col-sm text-center">
			<h1 class="spaceTitle">POST IDEA</h1>
		</div>
	</div>
	<form:form method="post" action="${url}" modelAttribute="idea">
		<spring:hasBindErrors name="idea">
			<c:set var="errorClass" value="border:1px solid red"></c:set>
		</spring:hasBindErrors>
		<form:label path="title"><a style="color: red;">*</a>Title : </form:label>
		<form:input path="title" cssClass="form-control" type="text" style="${errorClass}"/>
		<form:errors path="title" cssStyle="color:red;"/><br>
		<form:label path="description"><a style="color: red;">*</a>Description : </form:label>
		<form:input path="description" cssClass="form-control" type="text" style="${errorClass}"/>
		<form:errors path="description" cssStyle="color:red;"/><br>
		<form:label path="picture">Image url : </form:label>
		<form:input path="picture" cssClass="form-control" type="url" style="${errorClass}"/>
		<form:errors path="picture" cssStyle="color:red;"/><br>
		<form:label path="category">Category : </form:label>
		<form:select path="category.id" items="${categories}" itemLabel="name" itemValue="id" class="form-control"/>
		<form:errors path="category" cssStyle="color:red;"/><br>
		<input type="submit" value="Submit"/>
	</form:form>
</div>
<jsp:include page="../template/footer.jsp"></jsp:include>