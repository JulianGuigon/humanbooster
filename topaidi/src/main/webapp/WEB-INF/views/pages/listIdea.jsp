<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<jsp:include page="../template/header.jsp"></jsp:include>
<div class="row">
	<div class="col-sm text-center">
		<h1 class="spaceTitle">List idea</h1>
	</div>
</div>

<div class="container">
	<div class="row">
		<c:forEach items="${listIdea}" var="i">
			<div class="col-4 moveCardBot">
				<div class="card shadow p-3 mb-5 bg-white rounded">
					<img src="<c:url value="/images/table.jpg"/>" class="card-img-top"
						alt="..." >
					<div class="card-body">
						<h5 class="card-title">${i.title}</h5>
						<p class="card-text">${i.description}</p>
						<div class="row">
							<c:choose>
								<c:when test="${user != null}">
									<div class="col-sm">
										<a href="#" class="btn btn-success sizeButtonCard"><i
											class="fas fa-thumbs-up"></i> Top</a>
									</div>
									<div class="col-sm">
										<a href="#" class="btn btn-danger sizeButtonCard"><i
											class="fas fa-thumbs-down"></i> Flop</a>
									</div>
								</c:when>
							</c:choose>
						</div>
					</div>
					<a class="text-right" href="idea/${i.id}">More information...</a>
				</div>
			</div>

		</c:forEach>
	</div>
</div>
<jsp:include page="../template/footer.jsp"></jsp:include>