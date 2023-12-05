<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="dashboard_admin.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<title>All Professors</title>
</head>

<body>

	<div class="container" style="margin-left: 330px;">
	<!-- 	title -->
		<div class="title">
	      All professeurs
	      <a href="addProf.jsp" class="b"><span>Ajouter</span></a> 
	    </div>
	    
	    
	  	
	<!--   	table start -->
		<table id="customers">
			<!-- 	header -->
			<tr>
				<th >code</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Email</th>
				<th>Numero</th>
				<th>domaine</th>
				<th>action</th>
			</tr>
		  
			<!-- 	  body of table -->
			<c:forEach items="${ professeurs }" var="professeurs" varStatus="boucle">
			  <tr>
			   <td>${ professeurs.getCode() }</td>
			   <td>${ professeurs.getNom() }</td>
			   <td>${ professeurs.getPrenom() }</td>
			   <td>${ professeurs.getEmail() }</td>
			   <td>${ professeurs.getNumero() }</td>
			   <td>${ professeurs.getDomaine() }</td>
			   <td><a  href="updateProf.jsp?code=${ professeurs.getCode() }&nom=${ professeurs.getNom() }&prenom=${ professeurs.getPrenom() }&domaine=${ professeurs.getDomaine() }&email=${ professeurs.getEmail() }&numero=${ professeurs.getNumero() }" ><i class="material-icons" style="color:#B80F0A">edit</i></a>
			      <a href="deleteProf?code=${ professeurs.getCode() }" ><i style="color:#B80F0A" class="material-icons">delete</i></a>
			   </td>
			 </tr>
		   </c:forEach>
		 </table>	
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
  margin-bottom: 20px;
  color: #B80F0A;
  text-transform: Capitalize;
  text-align: center;
  display: flex;
  margin-left: 300px;
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
    margin-top: -5px;
    margin-left:100px;
    border-radius: 5rem;
    background:#B80F0A;
    color:#fff;
    cursor: pointer;
    box-shadow: 0 .5rem 1rem rgba(0,0,0,.1);
    transition: all .3s linear;
    padding: 12px 50px;
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
var element = document.getElementById("profs");
element.classList.add("active");
</script>