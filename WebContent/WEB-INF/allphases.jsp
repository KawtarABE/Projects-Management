<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="dashboard_student.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="./css/style8.css">
</head>
<body>
	<div class="container">
	  <h2>All Project's Phases</h2>
	  <ul class="responsive-table">
	    <li class="table-header">
	      <div class="col col-1">Numéro</div>
	      <div style="text-align: center;" class="col col-2">Intitulé</div>
	      <div class="col col-3">Progression</div>
	      <div class="col col-4">Details</div>
	    </li>
	    <li class="table-row">
	      <div style="margin-top: 10.5px;" class="col col-1">1</div>
	      <div style="margin-top: 10.5px;  margin-left: 80px;" class="col col-2">Validation du choix</div>
	      <div style="display: block; "class="col col-3"> 
	      	<c:choose>
	      	<c:when test="${ id_projet == 0 }">
		      	<span class="percentage" style="margin-left: 200px;" >0%</span>
		      	<div style="margin-left: -30px;" class="bar"> 
		      		<div style="width: 0%; " class="progress"></div> 
	            </div> 
	        </c:when>
	        <c:otherwise>
	        	<span class="percentage" style="margin-left: 200px;" >100%</span>
		      	<div style="margin-left: -30px;" class="bar"> 
		      	    <div style="width: 100%; " class="progress"></div> 
	            </div>
	        </c:otherwise> 
            </c:choose> 
          </div>
	      <div style="margin-top: 5.5px;" class="col col-4" data-label="Payment Status"><a href="intitule_projet?id_affectation=${ id_affectation }" class="detail" style="text-decoration: none; color: #B80F0A;"><i style="font-size: 30px;" class='bx bx-spreadsheet'></i></a></div>
	    </li>
	    <% int i = 1;  %> 
	    <c:forEach items="${ phases }" var="phase" varStatus="boucle">
		    <li class="table-row">
		      <div style="margin-top: 10.5px;" class="col col-1"><% i = i+1 ;%><%= i %></div>
		      <div style="margin-top: 10.5px; margin-left: 80px;" class="col col-2">${ phase.getPhase() }</div>
		      <div style="display: block; "class="col col-3"> 
		      	<span class="percentage" style="margin-left: 200px;" >${ phase.getPourcentage() }%</span>
		      	<div style="margin-left: -30px;" class="bar"> 
		      		<div style="width: ${ phase.getPourcentage() }%;" class="progress"></div> 
	            </div>   
	          </div>
		      <div style="margin-top: 10.5px;" class="col col-4" data-label="Payment Status"><a class="detail" style="text-decoration: none; color: #B80F0A;" href="phase_detail?id_phase=${ phase.getId() }&id_projet=${ phase.getId_projet() }&id_affectation=${ id_affectation }"><i style="font-size: 30px;" class='bx bx-spreadsheet'></i></a></div>
		    </li>
		</c:forEach>
	  </ul>
	  		<div style="margin-left: 300px; margin-bottom: 50px;" class="inputfield">
			<a href="projet_etudiant" style="color: #fff; text-decoration: none;"><button style="margin-right: 20px;"class="btn">Return</a></button>
        	</div>
	  </div>

</body>
</html>
<script>
var element = document.getElementById("projet");
element.classList.add("active");
</script>
<style>
.inputfield .btn{
    display: inline-block;
    margin-top: 1rem;
    border-radius: 5rem;
    background:#B80F0A;
    color:#fff;
    cursor: pointer;
    box-shadow: 0 .5rem 1rem rgba(0,0,0,.1);
    transition: all .3s linear;
    padding: 8px 12px;
  	font-size: 15px; 
  	font-weight: bold;
  	border: 0px;
    outline: none;
    width: 30%;
    overflow: hidden;
}

.inputfield .btn:hover{
    transform: scale(1.1);
}
</style>