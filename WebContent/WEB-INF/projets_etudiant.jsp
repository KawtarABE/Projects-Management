<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="dashboard_student.jsp" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style7.css">
<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<div class="courses-container">
	<c:forEach items="${ projets }" var="projet" varStatus="boucle">
	<div class="course">
		<div class="course-preview">
			<h6 style="margin-left: -10px;">Année : ${ projet.getAnnee() } </h6>
			<h2 style="margin-left: 10px;">Projet ${ projet.getSemestre() }</h2>	
			<h6> ${ projet.getStatus() } </h6>
		</div>
		<div class="course-info">
			<h2 style="font-size: 20px;"><span>Intitulé : ${ projet.getIntitule() }</span></h2>
			<h6 style="font-size: 12px;">Encadrant : ${ projet.getEncadrant() }</h6>
			<h6 style="font-size: 12px;">Binôme : ${ projet.getEtu2() }</h6>
			<h6 style="font-size: 12px;">Description : ${ projet.getDescription() }</h6>
			<a href="allphases?id_affectation=${ projet.getId_affectation() }">View all phases <i class='bx bx-chevrons-right'></i></a>
		</div>
	</div>
	</c:forEach>
</div>
<script>
var element = document.getElementById("projet");
element.classList.add("active");
</script>
</body>
</html>