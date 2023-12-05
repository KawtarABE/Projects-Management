<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="dashboard_prof.jsp" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<title>All Professeurs</title>
</head>
<body>
	<div class="container" style="margin-left: 330px;">
	<!-- 	title -->
		<div class="title">
	      My Affectations of : ${ semestre } ${ annee }
	    </div>
	    
	<!-- boxs start -->
	    <form action="affectations_annee" method="post">
			<div style=" width: 90%; display: flex; margin-left: 40px;">
			<div class="select">
			  <select name="annee">
			    <option value="">Select a year</option>
			    <c:forEach items="${ annees }" var="annee" varStatus="boucle">
			    	<option value="${ annee }">${ annee }</option>
			    </c:forEach>
			  </select>
			</div>
			<div class="select">
			  <select name="semestre">
			    <option value="">Select a semester</option>
			    <option value="S1">S1</option>
			    <option value="S2">S2</option>
			    <option value="S3">S3</option>
			    <option value="S4">S4</option>
			    <option value="S5">S5</option>
			    <option value="S6">S6</option>
			  </select>
		  	</div>
		  	<input type="submit" value="Search" class="btn">
		  	</div>
	  	</form>
	  	
	<!--   	table start -->
		<table id="customers">
			<!-- 	header -->
			  <tr>			
				<th style="width: 15%;">Student 1</th>
				<th style="width: 15%;">student 2</th>
				<th style="width: 20%;">Project</th>
				<th style="width: 30%;">description</th>
				<th style="width: 10%;">Status</th>
				<th style="width: 10%;">Phases</th>
			  </tr>
			  
			<!-- 	  body of table -->
			  <c:forEach items="${ projets }" var="projet" varStatus="boucle">
				  <tr>
					   <td style="width: 15%;">${ projet.getEtu2() }</td>
					   <td style="width: 15%;">${ projet.getEncadrant() }</td>
					   <td style="width: 20%;">${ projet.getIntitule() }</td>
					   <td style="width: 30%;">${ projet.getDescription() }</td>
					   <td style="width: 10%;">${ projet.getStatus() }</td>
					   <td style="width: 10%;"><a  href="allphases_prof?id_affectation=${ projet.getId_affectation() }&annee=${ annee }&semestre=${ semestre }" ><i class='bx bx-list-ol' style="font-size: 30px; color: #B80F0A;"></i></a></td>
				  </tr>
			  </c:forEach>
		 </table>	
		 <p style="margin-top: 50px; text-align: center; color: #B80F0A">${ no_affectation }</p> 
	</div>
</body>
</html>

<style>
body {
width: 100%;
font-family: Roboto, sans-serif;
text-transform: capitalize;
}

.container {
  width: 70%;
  margin-top: 60px;
  background: var(--light);
  min-height: 450px;
  box-shadow: 2px 2px 4px rgba(0,0,0,0.9);
  border-radius: 8px;
  padding: 30px;
  border-top: 4px solid #B80F0A;
}


.container .title{
  font-size: 24px;
  font-weight: 700;
  margin-bottom: 35px;
  color: #B80F0A;
  text-transform: Capitalize;
  text-align: center;
}

#customers {
  border-collapse: collapse;
  width: 100%;
  margin-left:0px;
  margin-top:2rem; 
}

#customers td, #customers th {
  border: 1px solid #ddd; 
  padding: 8px;
  text-align: center;
}

#customers td {
	font-size: 15px;
}

#customers tr:nth-child(even){
  background-color: #f2f2f2;
}

#customers tr:hover {
  background-color: #ddd;
}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #B80F0A;
  color: white;
}

select {
  /* Reset Select */
  appearance: none;
  outline: 0;
  border: 1px;
  /* Personalize */
  flex: 1;
  padding: 0 1em;
  cursor: pointer;
  color: #342E37;
  background-color: var(--grey);
  opacity: 0.7;
  
}

/* Custom Select wrapper */
.select {
  margin-left: 30px;
  /* border: 1px solid #ddd; */

  position: relative;
  display: flex;
  width: 15em;
  height: 2.3em;
  border-radius: 20em;
  overflow: hidden;
  
}
/* Arrow */
.select::after {
  content: '\25BC';
  position: absolute;
  top: 0;
  right: 0;
  padding: 1em;
  background-color: #B80F0A;
  transition: .25s all ease;
  pointer-events: none;
  color: #fff;
  font-size: 12px;
}

.btn {	
 	margin-left: 35px;
    border-radius: 5rem;
    background:#B80F0A;
    color:#fff;
    cursor: pointer;
    box-shadow: 0 .5rem 1rem rgba(0,0,0,.1);
    transition: all .3s linear;
    padding: 8px 40px;
  	font-size: 15px; 
  	font-weight: bold;
  	border: 0px;
  	background:  #B80F0A;
    outline: none;
}

.btn:hover{
    transform: scale(1.1);
}

i:hover{
	transform: scale(1.3);
}
</style>

<script>
var element = document.getElementById("projet");
element.classList.add("active");
</script>