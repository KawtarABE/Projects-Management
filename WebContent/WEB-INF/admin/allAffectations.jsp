<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="dashboard_admin.jsp" %> 

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
	      Affectations of : ${ semestre } ${ annee }

	    </div>
	    
	<!-- boxs start -->
	    <form action="allAffectations_annee" method="post">
			<div style=" width: 90%; display: flex; margin-left: 40px;">
			<div class="select">
			  <select name="annee" required>
			    <option value="">Select a year</option>
			    <c:forEach items="${ annees }" var="annee" varStatus="boucle">
			    	<option value="${ annee }">${ annee }</option>
			    </c:forEach>
			  </select>
			</div>
			<div class="select" required>
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
		  	<a href="addAffectation.jsp" class="btn">Ajouter</a>
		  	</div>
	  	</form>
	 <% int i = 0; %> 	
	<!--   	table start -->
		<table id="customers">
			<!-- 	header -->
			<tr>
				<th>Num</th>
				<th>Student 1</th>
				<th>Student 2</th>
				<th>Supervisor</th>
				<th>action</th>
			</tr>
		  
			<!-- 	  body of table -->
			<c:forEach items="${ affectations }" var="affectation" varStatus="boucle">
			  <tr>
			   <td><% i = i + 1; %><%=i%></td>
			   <td>${ affectation.getEtudiant1() }</td>
			   <td>${ affectation.getEtudiant2() }</td>
			   <td>${ affectation.getEncadrant() }</td>
			   <td>
			      <a href="deleteAffectation?code=${ affectation.getId_affectation() }&annee=${ annee }&semestre=${ semestre }" ><i style="color:#B80F0A" class="material-icons">delete</i></a>
			   </td>
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
  padding: 0 2em;
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
  width: 20em;
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
    padding: 8px 30px;
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
var element = document.getElementById("projects");
element.classList.add("active");
</script>