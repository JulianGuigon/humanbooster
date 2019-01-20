<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../template/header.jsp"></jsp:include>
<div class="row">
	<div class="col-sm text-center">
		<h1 class="spaceTitle">RANKING</h1>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-sm">
			<h1 class="spaceTitle">TOP 3 FOR THE CATEGORY TOP: </h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3 text-center"><h3>FIRST PLACE</h3></div>
		<div class="col-sm-1">
			<img src="<c:url value="https://openclipart.org/download/272611/Gold-medal_Juhele_final.svg"/>" class="card-img-top" alt="...">
		</div>
		<div class="col-sm-3 text-center"><h3>SECOND PLACE</h3></div>
		<div class="col-sm-1">
			<img src="<c:url value="https://openclipart.org/image/2400px/svg_to_png/272612/Silver-medal_Juhele_final.png"/>" class="card-img-top" alt="...">
		</div>
		<div class="col-sm-3 text-center"><h3>THIRD PLACE</h3></div>
		<div class="col-sm-1">
			<img src="<c:url value="https://openclipart.org/image/2400px/svg_to_png/272613/Bronze-medal_Juhele_final.png"/>" class="card-img-top" alt="...">
		</div>
	</div>
	<div class="row">
		<c:forEach items = "${listTop}" var="currentTop">
			<div class="col-sm-4 moveCardBot text-center">
				<div class="card shadow p-3 mb-5 bg-white rounded">
					<div class="card-body">
						<img src="<c:url value="${currentTop.picture}"/>" class="card-img-top"
						alt="...">
						<br><br>
						${currentTop.title}
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="row">
		<div class="col-sm">
			<h1 class="spaceTitle">TOP 3 FOR THE CATEGORY BUZZ: </h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3 text-center"><h3>FIRST PLACE</h3></div>
		<div class="col-sm-1">
			<img src="<c:url value="https://openclipart.org/download/272611/Gold-medal_Juhele_final.svg"/>" class="card-img-top" alt="...">
		</div>
		<div class="col-sm-3 text-center"><h3>SECOND PLACE</h3></div>
		<div class="col-sm-1">
			<img src="<c:url value="https://openclipart.org/image/2400px/svg_to_png/272612/Silver-medal_Juhele_final.png"/>" class="card-img-top" alt="...">
		</div>
		<div class="col-sm-3 text-center"><h3>THIRD PLACE</h3></div>
		<div class="col-sm-1">
			<img src="<c:url value="https://openclipart.org/image/2400px/svg_to_png/272613/Bronze-medal_Juhele_final.png"/>" class="card-img-top" alt="...">
		</div>
	</div>
	<div class="row">
		<c:forEach items = "${listBuzz}" var="currentBuzz">
			<div class="col-sm-4 moveCardBot text-center">
				<div class="card shadow p-3 mb-5 bg-white rounded">
					<div class="card-body">
						<img src="<c:url value="${currentBuzz.picture}"/>" class="card-img-top"
						alt="...">
						<br><br>
						${currentBuzz.title}
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="row">
		<div class="col-sm">
			<h1 class="spaceTitle">TOP 3 FOR THE CATEGORY BRAINS: </h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3 text-center"><h3>FIRST PLACE</h3></div>
		<div class="col-sm-1">
			<img src="<c:url value="https://openclipart.org/download/272611/Gold-medal_Juhele_final.svg"/>" class="card-img-top" alt="...">
		</div>
		<div class="col-sm-3 text-center"><h3>SECOND PLACE</h3></div>
		<div class="col-sm-1">
			<img src="<c:url value="https://openclipart.org/image/2400px/svg_to_png/272612/Silver-medal_Juhele_final.png"/>" class="card-img-top" alt="...">
		</div>
		<div class="col-sm-3 text-center"><h3>THIRD PLACE</h3></div>
		<div class="col-sm-1">
			<img src="<c:url value="https://openclipart.org/image/2400px/svg_to_png/272613/Bronze-medal_Juhele_final.png"/>" class="card-img-top" alt="...">
		</div>
	</div>
	<div class="row">
		<c:forEach items = "${listBrains}" var="currentBrains">
			<div class="col-sm-4 moveCardBot text-center">
				<div class="card shadow p-3 mb-5 bg-white rounded">
					<div class="card-body">
						<img src="<c:url value="${currentBrains.picture}"/>" class="card-img-top"
						alt="...">
						<br><br>
						${currentBrains.name}
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<jsp:include page="../template/footer.jsp"></jsp:include>