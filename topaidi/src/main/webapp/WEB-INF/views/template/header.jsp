<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">

<link href="https://fonts.googleapis.com/css?family=Oswald"
	rel="stylesheet">

<link href="css/pageProfil.css" rel="stylesheet">
<link href="css/general.css" rel="stylesheet">

<meta charset="UTF-8">
<title>TopAidi</title>
</head>
<body class="changeFont">

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="home"><i class="fas fa-lightbulb"></i>TopAidi</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<c:choose>
					<c:when test="${navbarIndexSelected.equals('idea')}">
						<li class="nav-item active"><a class="nav-link" href="idea">Idea</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="idea">Idea</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${navbarIndexSelected.equals('ranking')}">
						<li class="nav-item active"><a class="nav-link" href="#">Ranking</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="#">Ranking</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
			<div class="form-inline my-2 my-lg-0">
				<div class="dropdown dropleft">
					<img src="images/imgProfilDefault.png" id="imgProfilNav"
						class="rounded-circle dropdown-toggle" alt="..."
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<c:choose>
							<c:when test="${isConnected}">
								<a class="dropdown-item" href="profil">Profil</a> <a
								class="dropdown-item" href="#">Create idea <i class="fas fa-plus"></i></a> 
								<a class="dropdown-item" href="connect/disconnect">Sign out</a>
							</c:when>
							<c:otherwise>
								<a class="dropdown-item" href="register">Register</a>
								<a class="dropdown-item" href="connect">Connect</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</nav>