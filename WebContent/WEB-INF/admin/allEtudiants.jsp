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
	      All Students ${ promotion }
	    </div>
	    
	<!-- boxs start -->
	<div style="display: flex;">
	    <form action="allEtudiant_promo" method="post">
			<div style=" width: 90%; display: flex; margin-left: 100px;">
			<div class="select">
			  <select name="promo">
			    <option value="">Select a Promotion</option>
			    <c:forEach items="${ promos }" var="promo" varStatus="boucle">
			    	<option value="${ promo }">${ promo }</option>
			    </c:forEach>
			  </select>
			</div>
		  	<input type="submit" value="Search" class="btn">
		  	</div>
	  	</form>
	  	 <a href="addEtudiant.jsp" class="b">Ajouter</a>
	</div>
	<!--   	table start -->
		<table id="customers">
			<!-- 	header -->
			<tr>
				<th>code</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Email</th>
				<th>Numero</th>
				<th>Filiere</th>
				<th>action</th>
			</tr>
		  
			<!-- 	  body of table -->
			<c:forEach items="${ etudiants }" var="etudiant" varStatus="boucle">
			  <tr>
			   <td>${ etudiant.getCode() }</td>
			   <td>${ etudiant.getNom() }</td>
			   <td>${ etudiant.getPrenom() }</td>
			   <td>${ etudiant.getEmail() }</td>
			   <td>${ etudiant.getNumero() }</td>
			   <td>${ etudiant.getFiliere() }</td>
			   <td><a href="updateEtudiant.jsp?code=${ etudiant.getCode() }&nom=${ etudiant.getNom() }&prenom=${ etudiant.getPrenom() }&domaine=${ etudiant.getFiliere() }&email=${ etudiant.getEmail() }&numero=${ etudiant.getNumero() }&promo=${ promotion }" ><i class="material-icons" style="color:#B80F0A">edit</i></a>
			      <a href="deleteEtudiant?code=${ etudiant.getCode() }&promo=${ promotion }" ><i style="color:#B80F0A" class="material-icons">delete</i></a>
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
  padding: 0 1em;
  cursor: pointer;
  color: #342E37;
  background-color: var(--grey);
  opacity: 0.7;
  
}

/* Custom Select wrapper */
.select {
  margin-left: 30px;
  position: relative;
  display: flex;
  width: 18em;
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

.b{
    margin-left:20px;
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

.b:hover {
	transform : scale(1.1);
}
</style>

<script>
var element = document.getElementById("students");
element.classList.add("active");
</script>