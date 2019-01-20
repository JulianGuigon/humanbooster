<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../template/header.jsp"></jsp:include>
<div class="row">
	<div class="container">
		<div class="row">
			<div class="col-sm-12 text-center">
				<h1 class="spaceTitle">HOME</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4 moveCardBot text-center">
				<div class="card shadow p-3 mb-5 bg-white rounded">
					<div class="card-body">
						<h5 class="card-title">TOP</h5>
						<br>
						<img src="<c:url value="${top.picture}"/>" class="card-img-top"
						alt="...">
						<br><br>
						${top.title}
					</div>
				</div>
			</div>
			<div class="col-sm-4 moveCardBot text-center">
				<div class="card shadow p-3 mb-5 bg-white rounded">
					<div class="card-body">
						<h5 class="card-title">BUZZ</h5>
						<br>
						<img src="<c:url value="${buzz.picture}"/>" class="card-img-top"
						alt="...">
						<br><br>
						${buzz.title}
					</div>
				</div>
			</div>
			<div class="col-sm-4 moveCardBot text-center">
				<div class="card shadow p-3 mb-5 bg-white rounded">
					<div class="card-body">
						<h5 class="card-title">BRAINS</h5>
						<br>
						<img src="<c:url value="${brains.picture}"/>" class="card-img-top"
						alt="...">
						<br><br>
						${brains.name}
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<h1 class="spaceTitle">Latest 6 ideas : </h1>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${lastIdeas}" var="i">
				<div class="col-4 moveCardBot">
					<div class="card shadow p-3 mb-5 bg-white rounded">
						<img src="<c:url value="${i.picture}"/>" class="card-img-top"
							alt="...">
						<div class="card-body">
							<h5 class="card-title">${i.title}</h5>
							<p class="card-text">${i.description}</p>
							<div class="row">
								<c:choose>
									<c:when test="${i.isNotable()}">
										<c:choose>
											<c:when test="${i.userSubmitting.id != user.id}">
												<c:choose>
													<c:when test="${!user.existInListNote(i.id)}">
														<c:choose>
															<c:when test="${user != null}">
																<div class="col-sm text-center">
																	<div class="text-success">${i.getNbTop()}</div>
																	<a href="idea/note/${user.id}/${i.id}/top"
																		class="btn btn-success sizeButtonCard"><i
																		class="fas fa-thumbs-up"></i> Top</a>
																</div>
																<div class="col-sm text-center">
																	<div class="text-danger">${i.getNbFlop()}</div>
																	<a href="idea/note/${user.id}/${i.id}/flop"
																		class="btn btn-danger sizeButtonCard"><i
																		class="fas fa-thumbs-down"></i> Flop</a>
																</div>
															</c:when>
															<c:otherwise>
																<div class="col-sm text-center">
																	Top:
																	<div class="text-success">${i.getNbTop()}</div>
																</div>
																<div class="col-sm text-center">
																	Flop:
																	<div class="text-danger">${i.getNbFlop()}</div>
																</div>
															</c:otherwise>
														</c:choose>
													</c:when>
													<c:otherwise>
														<div class="text-danger">You have already voted</div>
														<div class="col-sm text-center">
															Top:
															<div class="text-success">${i.getNbTop()}</div>
														</div>
														<div class="col-sm text-center">
															Flop:
															<div class="text-danger">${i.getNbFlop()}</div>
														</div>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:otherwise>
												<div class="text-success">This your idea</div>
												<div class="col-sm text-center">
													Top:
													<div class="text-success">${i.getNbTop()}</div>
												</div>
												<div class="col-sm text-center">
													Flop:
													<div class="text-danger">${i.getNbFlop()}</div>
												</div>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<div class="text-warning">End of the votes</div>
										<div class="col-sm text-center">
											Top:
											<div class="text-success">${i.getNbTop()}</div>
										</div>
										<div class="col-sm text-center">
											Flop:
											<div class="text-danger">${i.getNbFlop()}</div>
										</div>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<!-- Obligé de faire 2 if sinon il me met une erreur -->
						<c:if test="${!containsFake}">
							<a class="text-right" href="idea/${i.id}">More information...</a>
						</c:if>
						<c:if test="${containsFake&&!i.title.equals('Not enough informations.')}">
							<a class="text-right" href="idea/${i.id}">More information...</a>
						</c:if>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<jsp:include page="../template/footer.jsp"></jsp:include>