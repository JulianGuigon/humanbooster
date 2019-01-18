<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../template/header.jsp"></jsp:include>
<spring:url value="/user/promote/${userDisplayed.id}" var="promote"></spring:url>
<spring:url value="/user/ban/${userDisplayed.id}" var="ban"></spring:url>
<spring:url value="/user/validate/${userDisplayed.id}" var="validate"></spring:url>
<spring:url value="/user/desactivate/${userDisplayed.id}" var="desactivate"></spring:url>
<spring:url value="/user/activate/${userDisplayed.id}" var="activate"></spring:url>
<div class="row"><br></div>
<div class="row"><br></div>
<div class="row"><br></div>
<div class="row">
	<c:choose>
		<c:when test="${userDisplayed.picture}==null">
			<div class="col-sm text-center">
				<img src="images/imgProfilDefault.png" id="imgProfil"
					class="rounded-circle" alt="...">
			</div>
		</c:when>
		<c:otherwise>
			<div class="col-sm text-center">
				<img src="${userDisplayed.picture}" id="imgProfil"
					class="rounded-circle" alt="...">
			</div>
		</c:otherwise>
	</c:choose>
	
	<div class="col-sm">
		<ul class="deletePuceList sizeList">
			<c:choose>
					<c:when test="${isAdmin}">
						<li>
							<div class="form-group">
								<label for="forName">Admin</label>
							</div>
						</li>
						<hr>
					</c:when>
			</c:choose>
			<li>
				<div class="form-group">
					<label for="forName">Name</label> <input type="text"
						class="form-control" id="forName" placeholder="${userDisplayed.name}"
						readonly="readonly">
				</div>
			</li>
			<hr>
			<li>
				<div class="form-group">
					<label for="forMail">Address</label> <input type="email"
						class="form-control" id="forMail" placeholder="${userDisplayed.address.streetNumber} ${userDisplayed.address.wording}, ${userDisplayed.address.postalCode} ${userDisplayed.address.city} ${userDisplayed.address.country}"
						readonly="readonly">
				</div>
			</li>
			<hr>
			<li>
				<div class="form-group">
					<label for="forTel">Tel</label> <input type="number"
						class="form-control" id="forTel" placeholder="${userDisplayed.phoneNumber}"
						readonly="readonly">
				</div>
			</li>
			<c:choose>
				<c:when test="${isAdmin}">
					<c:choose>
						<c:when test="${isUserDisplayedNotAdmin}">
							<div>
								<hr>
								<a href="${promote}" class="btn btn-info">Promote to Admin</a>
								<c:choose>
									<c:when test="${isUserDisplayedActivated}">
										<a href="${desactivate}" class="btn btn-danger">Desactivate</a>
									</c:when>
									<c:otherwise>
										<a href="${activate}" class="btn btn-info">Reactivate</a>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${!isUserDisplayedValidated}">
										<a href="${validate}" class="btn btn-success">Validate</a>
									</c:when>
								</c:choose>
								<a href="${ban}" class="btn btn-danger">Ban</a>
							</div>
						</c:when>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${isUserDisplayedNotAdmin&&userDisplayed.id!=user.id}">
							<div>
								<hr>
								<a href="#" class="btn btn-danger">Alert</a>
							</div>
						</c:when>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>
<jsp:include page="../template/footer.jsp"></jsp:include>