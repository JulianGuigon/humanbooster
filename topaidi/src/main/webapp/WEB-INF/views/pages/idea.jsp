<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../template/header.jsp"></jsp:include>

<spring:url value="/postComment" var="postComment"></spring:url>
<spring:url value="/alertIdea" var="reportIdea"></spring:url>
<spring:url value="/alertComment" var="reportComment"></spring:url>

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
		<div class="text-center">
			<button class="btn btn-danger" data-toggle="modal"
				data-target="#modalReportIdea">
				<i class="fas fa-exclamation-triangle"></i>Report idea
			</button>
		</div>
		<br>
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
				<c:when test="${idea.isNotable()}">
					<c:choose>
						<c:when test="${idea.userSubmitting.id != user.id}">
							<c:choose>
								<c:when test="${!user.existInListNote(idea.id)}">
									<c:choose>
										<c:when test="${user != null}">
											<div class="col-sm text-center">
												<div class="text-success">${idea.getNbTop()}</div>
												<a href="note/${user.id}/${idea.id}/top"
													class="btn btn-success sizeButtonCard"><i
													class="fas fa-thumbs-up"></i> Top</a>
											</div>
											<div class="col-sm text-center">
												<div class="text-danger">${idea.getNbFlop()}</div>
												<a href="note/${user.id}/${idea.id}/flop"
													class="btn btn-danger sizeButtonCard"><i
													class="fas fa-thumbs-down"></i> Flop</a>
											</div>
										</c:when>
										<c:otherwise>
											<div class="col-sm text-center">
												Top:
												<div class="text-success">${idea.getNbTop()}</div>
											</div>
											<div class="col-sm text-center">
												Flop:
												<div class="text-danger">${idea.getNbFlop()}</div>
											</div>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<div class="text-danger">You have already voted</div>
									<div class="col-sm text-center">
										Top:
										<div class="text-success">${idea.getNbTop()}</div>
									</div>
									<div class="col-sm text-center">
										Flop:
										<div class="text-danger">${idea.getNbFlop()}</div>
									</div>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<div class="text-success">This your idea</div>
							<div class="col-sm text-center">
								Top:
								<div class="text-success">${idea.getNbTop()}</div>
							</div>
							<div class="col-sm text-center">
								Flop:
								<div class="text-danger">${idea.getNbFlop()}</div>
							</div>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<div class="text-warning">End of the votes</div>
					<div class="col-sm text-center">
						Top:
						<div class="text-success">${idea.getNbTop()}</div>
					</div>
					<div class="col-sm text-center">
						Flop:
						<div class="text-danger">${idea.getNbFlop()}</div>
					</div>
				</c:otherwise>
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
		<form:form method="POST" action="${postComment}"
			modelAttribute="Comment">
			<div class="sizeInputComment">
				<div class="form-group">
					<c:choose>
						<c:when test="${user != null}">
							<form:input type="hidden" path="userCommenting.id"
								value="${user.id}" />
							<form:input type="hidden" path="ideaCommented.id"
								value="${idea.id}" />
							<label class="underline">${user.name}:</label>
							<form:textarea class="form-control" maxlength="200" rows="2"
								placeholder="Add comment..." path="value" />
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
		</form:form>
	</div>
	<div class="col-sm"></div>
</div>
<br>
<br>
<!-- LIGNE POUR AFFICHER COMMENTAIRE -->
<div class="container">

	<c:forEach items="${idea.listComment}" var="c">
		<c:choose>
			<c:when test="${c.isActive()}">
				<div class="row">
					<div class="col-sm">
						<div class="card" style="width: 100%">
							<div class="text-right">
								<button class="btn btn-danger rounded" data-toggle="modal"
									data-target="#modalReportComment">
									<i class="fas fa-exclamation-triangle"></i>Report comment
								</button>
							</div>
							<div class="card-body" style="padding-top: 0">
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
			</c:when>
		</c:choose>



		<!-- Modal report comment -->
		<div class="modal fade" id="modalReportComment" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header" style="background-color: #d32f2f;">
						<h5 class="modal-title" id="exampleModalLabel">Report
							${idea.title}</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form:form method="POST" action="${reportComment}"
						modelAttribute="Alert">
						<div class="modal-body">

							<div class="form-group">
								<form:input type="hidden" path="userAlerting.id"
									value="${user.id}" />
								<form:input type="hidden" path="commentAlerted.id" value="${c.id}" />
								<label for="messageReport"> Reason for your report: </label>
								<form:textarea id="messageReport" class="form-control"
									maxlength="254" rows="3" placeholder="Messages..."
									path="message" />
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-danger">Send report</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<jsp:include page="../template/footer.jsp"></jsp:include>









<!-- Modal report idea -->
<div class="modal fade" id="modalReportIdea" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header" style="background-color: #d32f2f;">
				<h5 class="modal-title" id="exampleModalLabel">Report
					${idea.title}</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form:form method="POST" action="${reportIdea}"
				modelAttribute="Alert">
				<div class="modal-body">

					<div class="form-group">
						<form:input type="hidden" path="userAlerting.id"
							value="${user.id}" />
						<form:input type="hidden" path="ideaAlerted.id" value="${idea.id}" />
						<label for="messageReport"> Reason for your report: </label>
						<form:textarea id="messageReport" class="form-control"
							maxlength="254" rows="3" placeholder="Messages..." path="message" />
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-danger">Send report</button>
				</div>
			</form:form>
		</div>
	</div>
</div>