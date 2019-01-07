<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>New idea</title>
</head>
<body style="background-color: #9E9E9E">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">TopAidi</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="?action=menu">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="?action=list">List idea</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="?action=new" tabindex="-1" aria-disabled="true">Add idea<span class="sr-only">(current)</span></a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>

	<div class="container">
		<div class="row">
			<div class="col-sm">
				<h1>New idea</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm">
				<form method="POST" action="IdeaController">
				<input type="hidden" name="idForm" value="${ideaObject.id}"/>
					<div class="form-group">
						<label for="nameIdea">Name idea</label> <input type="text"
							class="form-control" id="nameIdea" placeholder="Name idea" name="nameIdeaForm" value="${ideaObject.title}">
					</div>
					<div class="form-group">
						<label for="descriptionIdea">Description</label>
						<textarea class="form-control" id="descriptionIdea" rows="3" name="descIdeaForm">${ideaObject.description}</textarea>
					</div>
					<select class="form-control" name="selectedCategoryForm">
						<option>${ideaObject.category.name}</option>
						<option>Fruit</option>
						<option>Techno</option>
						<option>Sport</option>
					</select>
					<div class="form-group">
						<label for="imageIdea">Image</label> <input type="text"
							class="form-control" id="imageIdea" placeholder="Choose image...." name="imageIdeaForm" value="${ideaObject.picture}">
					</div>
					<br>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
		integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
		crossorigin="anonymous"></script>
</body>
</html>