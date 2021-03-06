<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../template/header.jsp"></jsp:include>
<div class="row">
	<div class="col-sm text-center">
		<h1 class="spaceTitle">ADMIN TOOLS</h1>
	</div>
</div>
<spring:url value="/admin" var="url"></spring:url>
<div id="accordion">
	<div class="card">
		<div class="card-header" id="headingOne">
			<h5 class="mb-0">
				<button class="btn btn-link collapsed" data-toggle="collapse"
					data-target="#collapseOne" aria-expanded="true"
					aria-controls="collapseOne">Create category</button>
			</h5>
		</div>

		<div id="collapseOne" class="collapse show"
			aria-labelledby="headingOne" data-parent="#accordion">
			<div class="card-body">
				<form:form method="post" action="${url}" modelAttribute="category">
					<spring:hasBindErrors name="category">
						<c:set var="errorClass" value="border:1px solid red"></c:set>
					</spring:hasBindErrors>
					<form:label path="name">
						<a style="color: red;">*</a>Name : </form:label>
					<form:input path="name" cssClass="form-control" type="text"
						style="${errorClass}" />
					<form:errors path="name" cssStyle="color:red;" />
					<br>
					<input type="submit" value="Create" />
				</form:form>
			</div>
		</div>
	</div>
	<div class="card">
		<div class="card-header" id="headingTwo">
			<h5 class="mb-0">
				<button class="btn btn-link collapsed" data-toggle="collapse"
					data-target="#collapseTwo" aria-expanded="false"
					aria-controls="collapseTwo">List category</button>
			</h5>
		</div>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordion">
			<div class="card-body">
				<ul class="list-group">
					<c:forEach items="${categories}" var="category">
						<li class="list-group-item">${category.name}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<div class="card">
		<div class="card-header" id="headingThree">
			<h5 class="mb-0">
				<button class="btn btn-link collapsed" data-toggle="collapse"
					data-target="#collapseThree" aria-expanded="false"
					aria-controls="collapseThree">Validating user</button>
			</h5>
		</div>
		<div id="collapseThree" class="collapse"
			aria-labelledby="headingThree" data-parent="#accordion">
			<div class="card-body">
				<ul style="margin: 0% 20%;" class="list-group">
					<c:forEach items="${invalidUsers}" var="currentUser">
						<li class="list-group-item"><c:choose>
								<c:when test="${currentUser.picture!=null}">
									<img style="height: 40px; width: 40px;"
										src="${currentUser.picture}" alt="..." class="rounded-circle">
								</c:when>
								<c:otherwise>
									<img style="height: 40px; width: 40px;"
										src="<c:url value="/images/imgProfilDefault.png"/>" alt="..."
										class="rounded-circle">
								</c:otherwise>
							</c:choose> &nbsp;&nbsp; ${currentUser.name} (live in :
							${currentUser.address.streetNumber}
							${currentUser.address.wording}, ${currentUser.address.city}
							${currentUser.address.country}) &nbsp;&nbsp; <a
							href="admin/validate/${currentUser.id}" class="btn btn-success"><i
								class="fas fa-plus-circle"></i></a> &nbsp;&nbsp; <a
							href="admin/ban/${currentUser.id}" class="btn btn-danger"><i
								class="fas fa-minus-circle"></i></a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<div class="card">
		<div class="card-header" id="headingFour">
			<h5 class="mb-0">
				<button class="btn btn-link collapsed" data-toggle="collapse"
					data-target="#collapseFour" aria-expanded="false"
					aria-controls="collapseFour">List alert</button>
			</h5>
		</div>
		<div id="collapseFour" class="collapse" aria-labelledby="headingFour"
			data-parent="#accordion">
			<div class="card-body">
				<div class="row">
					<!-- TABLEAU ALERT IDEA -->
					<div class="col-sm">
						<div class="text-center">
							<h4>Idea alerted</h4>
						</div>
						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th>id</th>
									<th>Created at</th>
									<th>Reason for reporting</th>
									<th>Idea alerted</th>
									<th>Created by</th>
									<th>Alerted by</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listIdeaAlerted}" var="alert">
									<tr>
										<th>${alert.id}</th>
										<td>${alert.createdAt}</td>
										<td>${alert.message}</td>
										<td>${alert.ideaAlerted.title}</td>
										<td>${alert.ideaAlerted.userSubmitting.name}</td>
										<td>${alert.userAlerting.name}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- TABLEAU ALERT MESSAGE -->
					<div class="col-sm">
						<div class="text-center">
							<h4>Comment alerted</h4>
						</div>
						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th>id</th>
									<th>Created at</th>
									<th>Reason for reporting</th>
									<th>Comment alerted</th>
									<th>Created by</th>
									<th>Alerted by</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listCommentAlerted}" var="alert">
									<tr>
										<th>${alert.id}</th>
										<td>${alert.createdAt}</td>
										<td>${alert.message}</td>
										<td>${alert.commentAlerted.value}</td>
										<td>${alert.commentAlerted.userCommenting.name}</td>
										<td>${alert.userAlerting.name}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../template/footer.jsp"></jsp:include>