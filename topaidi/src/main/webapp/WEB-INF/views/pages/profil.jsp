<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../template/header.jsp"></jsp:include>
<div class="row">
	<div class="col-sm text-center">
		<h1 class="spaceTitle">PROFIL</h1>
	</div>
</div>

<div class="row">
	<div class="col-sm text-center">
		<img src="images/imgProfilDefault.png" id="imgProfil"
			class="rounded-circle" alt="...">
	</div>
	<div class="col-sm">
		<ul class="deletePuceList sizeList">
			<li>
				<div class="form-group">
					<label for="forName">Name</label> <input type="text"
						class="form-control" id="forName" placeholder="${user.name}"
						readonly="readonly">
				</div>
			</li>
			<hr>
			<li>
				<div class="form-group">
					<label for="forMail">Email</label> <input type="email"
						class="form-control" id="forMail" placeholder="${user.email}"
						readonly="readonly">
				</div>
			</li>
			<hr>
			<li>
				<div class="form-group">
					<label for="forMail">Address</label> <input type="email"
						class="form-control" id="forMail" placeholder="${user.address.streetNumber} ${user.address.wording}, ${user.address.postalCode} ${user.address.city} ${user.address.country}"
						readonly="readonly">
				</div>
			</li>
			<hr>
			<li>
				<div class="form-group">
					<label for="forTel">Tel</label> <input type="number"
						class="form-control" id="forTel" placeholder="${user.phoneNumber}"
						readonly="readonly">
				</div>
			</li>
			<hr>
			<li>
				<div class="text-right">
					<a href="#">Edit</a>
				</div>
			</li>
		</ul>
	</div>
</div>
<jsp:include page="../template/footer.jsp"></jsp:include>