<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../template/header.jsp"></jsp:include>
<div class="row">
	<div class="col-sm text-center">
		<h1 class="spaceTitle">SEARCH</h1>
		<form:form method="post" modelAttribute="formUser">
			<table style="margin: auto;">
				<tr>
					<th>
						<form:input path="name" type="text" cssClass="form-control" placeholder="Search.."/>
					</th>
					<th>
						<button type="submit"><i class="fa fa-search"></i></button>
					</th>
				</tr>
			</table>
		</form:form>
		<br>
		<ul style="margin: 0% 20%;" class="list-group">
	       	<c:forEach items="${users}" var="currentUser">
	       		<spring:url value="/user/${currentUser.id}" var="pageUserWithId"></spring:url>
	       		<li class="list-group-item">
	       			<c:choose>
						<c:when test="${currentUser.picture!=null}">
							<img style="height: 40px;width: 40px;" src="${currentUser.picture}" alt="..." class="rounded-circle">
						</c:when>
						<c:otherwise>
							<img style="height: 40px;width: 40px;" src="<c:url value="/images/imgProfilDefault.png"/>" alt="..." class="rounded-circle">
						</c:otherwise>
					</c:choose>
		       		&nbsp;&nbsp;
		       		${currentUser.name} (live in : ${currentUser.address.streetNumber} ${currentUser.address.wording}, ${currentUser.address.city} ${currentUser.address.country})
		       		&nbsp;&nbsp;
		       		<a href="${pageUserWithId}" class="btn btn-info"><i class="fas fa-arrow-right"></i></a>
	       		</li>
	       	</c:forEach>
		</ul>
	</div>
</div>
<jsp:include page="../template/footer.jsp"></jsp:include>