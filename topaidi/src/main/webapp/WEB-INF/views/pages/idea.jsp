<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../template/header.jsp"></jsp:include>
<!-- LIGNE AVEC TITRE -->
<div class="row">
	<div class="col-sm text-center">
		<h1 class="spaceTitle">${idea.title}</h1>
	</div>
</div>

<!-- LIGNE AVEC CAROUSEL + IMAGE PROFIL + CATEGORY -->
<div class="row">
	<!-- COL AVEC CAROUSEL -->
	<div class="col-sm text-center">
		<div id="carouselExampleIndicators" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="<c:url value="/images/imageIdeaDefault.jpg"/>"
						id="imgIdea" class="rounded" alt="...">
				</div>
				<div class="carousel-item">
					<img src="<c:url value="/images/imgProfilDefault.png" />"
						id="imgProfil" class="rounded" alt="...">
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleIndicators"
				role="button" data-slide="prev"> <i
				class="fas fa-chevron-left text-danger"></i> <span class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
				role="button" data-slide="next"><i
				class="fas fa-chevron-right text-danger"></i> <span class="sr-only">Next</span>
			</a>
		</div>


	</div>
	<!-- COL AVEC IMAGE PROFIL ET CATEGORY -->
	<div class="col-sm">
		<div class="card sizeCardProfil">
			<div class="card-body">
				<img src="<c:url value="/images/imgProfilDefault.png" />"
					id="imgProfilIdea" class="rounded-circle" alt="..."> <span>${idea.userSubmitting.name}</span>
			</div>
		</div>
		<br>
		<hr class="hrIdea">
		<br>
		<div>
			<h5 class="underline">Category:</h5>
			-${idea.category.name}
		</div>
		<br> <br> <br>
		<div class="row">
			<c:choose>
				<c:when test="${user != null}">
					<a href="#" class="btn btn-success" style="margin-right: 1em"><i
						class="fas fa-thumbs-up"></i> Top</a>
					<a href="#" class="btn btn-danger"><i
						class="fas fa-thumbs-down"></i> Flop</a>
				</c:when>
			</c:choose>
		</div>
	</div>
</div>
<br>
<!-- LIGNE AVEC CONTENU DESCRIPTION -->
<div class="row">
	<div class="col-sm">
		<p class="sizeParagraph text-center">${idea.description}</p>
	</div>
</div>
<hr class="hrIdea">
<!-- LIGNE AVEC TITRE COMMENTAIRE -->
<div class="row">
	<div class="col-sm text-center underline">
		<h3>Commentary</h3>
	</div>
</div>

<!-- LIGNE POUR POST UN COMMENTAIRE -->
<div class="row">
	<div class="col-sm"></div>
	<div class="col-sm">
		<form method="POST">
			<div class="sizeInputComment">
				<div class="form-group">
					<c:choose>
						<c:when test="${user != null}">
							<label class="underline">${idea.userSubmitting.name}:</label>
							<textarea class="form-control" maxlength="200" rows="2"
								placeholder="Add comment..."></textarea>
							<br>
							<button type="submit" class="btn btn-primary">Post</button>
						</c:when>
						<c:otherwise>
							<textarea class="form-control" maxlength="200" rows="2"
								placeholder="You need to connect for post a commentary"
								disabled="disabled"></textarea>
						</c:otherwise>
					</c:choose>
				</div>

			</div>
		</form>
	</div>
	<div class="col-sm"></div>
</div>
<br>
<br>
<!-- LIGNE POUR AFFICHER COMMENTAIRE -->
<div class="container">

	<c:forEach items="${idea.listComment}" var="c">
		<div class="row">
			<div>
				<div class="card" style="width: 100%">
					<div class="card-body">
						<div class="row">
							<div class="col-1">
								<img src="<c:url value="/images/imgProfilDefault.png" />"
									id="imgProfilIdea" class="rounded-circle" alt="...">
							</div>
							<div class="col-11">
								<h5 class="underline">${c.userCommenting.name}</h5>
								<p>${c.value}</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br>
	</c:forEach>

	<div class="row">
		<div class="card">
			<div class="card-body">
				<div class="row">
					<div class="col-1">
						<img src="<c:url value="/images/imgProfilDefault.png" />"
							id="imgProfilIdea" class="rounded-circle" alt="...">
					</div>
					<div class="col-11">
						<h5 class="underline">Philipe Ducroc</h5>
						<p>Integer pulvinar enim vitae orci finibus lobortis.
							Vestibulum eget consequat tellus. Nullam volutpat odio vel sem
							consequat, et viverra magna accumsan. Aliquam erat volutpat. Ut
							sed massa ex. Ut et ipsum ut libero tincidunt varius a eu nulla.
							Praesent at purus fringilla, feugiat mi sit amet, pharetra diam.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="card">
			<div class="card-body">
				<div class="row">
					<div class="col-1">
						<img src="<c:url value="/images/imgProfilDefault.png" />"
							id="imgProfilIdea" class="rounded-circle" alt="...">
					</div>
					<div class="col-11">
						<h5 class="underline">Jean Jean</h5>
						<p>Integer pulvinar enim vitae orci finibus lobortis.
							Vestibulum eget consequat tellus. Nullam volutpat odio vel sem
							consequat, et viverra magna accumsan. Aliquam erat volutpat. Ut
							sed massa ex. Ut et ipsum ut libero tincidunt varius a eu nulla.
							Praesent at purus fringilla, feugiat mi sit amet, pharetra diam.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../template/footer.jsp"></jsp:include>