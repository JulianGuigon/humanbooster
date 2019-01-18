<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../template/header.jsp"></jsp:include>
<spring:url value="/register" var="url"></spring:url>
<div class="container">
	<div class="row">
		<div class="col-sm text-center">
			<h1 class="spaceTitle">REGISTER</h1>
		</div>
	</div>
	<p style="color: red;">WARNING : Your account needs to be validate by an Administrator before you can connect to the website. Please beware that you will not be connected right after your registration.</p>
	<form:form method="post" action="${url}" modelAttribute="user">
		<spring:hasBindErrors name="user">
			<c:set var="errorClass" value="border:1px solid red"></c:set>
		</spring:hasBindErrors>
		<form:label path="email"><a style="color: red;">*</a>Email : </form:label>
		<form:input path="email" cssClass="form-control" type="email" style="${errorClass}"/>
		<form:errors path="email" cssStyle="color:red;"/><br>
		<form:label path="password"><a style="color: red;">*</a>Password : </form:label>
		<form:input path="password" cssClass="form-control" type="password" style="${errorClass}"/>
		<form:errors path="password" cssStyle="color:red;"/><br>
		<label><a style="color: red;">*</a>Repeat password : </label>
		<input id="repeatPassword" class="form-control" type="password" style="${errorClass}"><br>
		<form:label path="name">Name : </form:label>
		<form:input path="name" cssClass="form-control" type="text" style="${errorClass}"/>
		<form:errors path="name" cssStyle="color:red;"/><br>
		<form:label path="address.wording">Wording : </form:label>
		<form:input path="address.wording" cssClass="form-control" type="text" style="${errorClass}"/>
		<form:errors path="address.wording" cssStyle="color:red;"/><br>
		<form:label path="address.streetNumber">Street number : </form:label>
		<form:input path="address.streetNumber" cssClass="form-control" type="number" style="${errorClass}"/>
		<form:errors path="address.streetNumber" cssStyle="color:red;"/><br>
		<form:label path="address.country">Country : </form:label>
		<form:input path="address.country" cssClass="form-control" type="text" style="${errorClass}"/>
		<form:errors path="address.country" cssStyle="color:red;"/><br>
		<form:label path="address.city">City : </form:label>
		<form:input path="address.city" cssClass="form-control" type="text" style="${errorClass}"/>
		<form:errors path="address.city" cssStyle="color:red;"/><br>
		<form:label path="address.postalCode">Postal Code : </form:label>
		<form:input path="address.postalCode" cssClass="form-control" type="number" style="${errorClass}"/>
		<form:errors path="address.postalCode" cssStyle="color:red;"/><br>
		<form:label path="phoneNumber">Phone : </form:label>
		<form:input path="phoneNumber" cssClass="form-control" type="tel" style="${errorClass}"/>
		<form:errors path="phoneNumber" cssStyle="color:red;"/><br>
		<form:label path="picture">Picture : </form:label>
		<form:input path="picture" cssClass="form-control" type="url" style="${errorClass}"/>
		<form:errors path="picture" cssStyle="color:red;"/><br>
		<br>
		<input type="submit" value="Submit"/>
	</form:form>
</div>
<jsp:include page="../template/footer.jsp"></jsp:include>