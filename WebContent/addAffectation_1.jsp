<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="WEB-INF/admin/dashboard_admin.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>compose</title>
    
    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    
    <!-- custom css file link  -->
    <!-- <link rel="stylesheet" href="css/style2.css"> -->
</head>
<body>
<form action="addAffectation" name="myform" method="post">
<div class="wrapper" style="margin-left: 470px; margin-top: 80px;">
    <div class="title">
      New Affectation
      <p id="erreur" style="margin-top: 20px; font-size: 15px; color: #B80F0A"><span style="color: green;">${ success }</span>${ erreur }</p>
    </div>
    <div class="form">
      <div class="inputfield">
      	  <label>Promotion</label>
          <input type="text" name="promo" class="input" placeholder="Enter a promotion" value="${ promo }" readonly>
       </div>  
       <div class="inputfield">
          <label>Student 1</label>
          <div onclick="show()" class="custom_select">
            <select name="student1">
              <option value="">Select First student</option>
              <c:forEach items="${ etudiants }" var="etudiant" varStatus="boucle">
              	<option value="${ etudiant.getCode() }">${ etudiant.getNom() } ${ etudiant.getPrenom() }</option> 
              </c:forEach>
             </select>
          </div>
       </div>  
       <div class="inputfield">
          <label>Student 2</label>
          <div onclick="show()" class="custom_select">
            <select  name="student2">
              <option value="">Select Second student</option>
              <c:forEach items="${ etudiants }" var="etudiant" varStatus="boucle">
              	<option value="${ etudiant.getCode() }">${ etudiant.getNom() } ${ etudiant.getPrenom() }</option> 
              </c:forEach>
             </select>
          </div>
       </div> 
       <div class="inputfield">
          <label>Supervisor</label>
          <div onclick="show()" class="custom_select">
            <select name="prof">
              <option value="">Select Supervisor</option>
              <c:forEach items="${ profs }" var="etudiant" varStatus="boucle">
              	<option value="${ etudiant.getCode() }">${ etudiant.getNom() } ${ etudiant.getPrenom() }</option> 
              </c:forEach>
             </select>
          </div>
       </div>   
	   <div class="inputfield">
          <label>Semestre</label>
          <div onclick="show()" class="custom_select">
            <select name="semestre">
              <option value="">Select Semestre</option>
              <option value="S1">S1</option>
              <option value="S2">S2</option>
              <option value="S3">S3</option>
              <option value="S4">S4</option>
              <option value="S5">S5</option>
              <option value="S6">S6</option>
             </select>
          </div>
       </div> 
      <div class="inputfield">
        <button style="margin-right: 20px;"class="btn"><a href="allAffectations" style="color: #fff; text-decoration: none;">Cancel</a></button>
        <input type="submit" value="Add" class="btn">
      </div>
    </div>
</div>
</form>
</body>
</html>

<style>
@import url('https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap');

body{
  font-family: 'Montserrat', sans-serif;
}

.wrapper{
  margin-left: 470px;
  max-width: 600px;
  width: 100%;
  background: #fff;
  margin: 50px auto;
  box-shadow: 2px 2px 4px rgba(0,0,0,0.9);
  border-radius: 8px;
  padding: 30px;
}

.wrapper .title{
  font-size: 24px;
  font-weight: 700;
  margin-bottom: 25px;
  color: #B80F0A;
  text-transform: Capitalize;
  text-align: center;
}

.wrapper .form{
  width: 100%;
}

.wrapper .form .inputfield{
  margin-bottom: 15px;
  display: flex;
  align-items: center;
}

.wrapper .form .inputfield label{
   width: 200px;
   color: #000;
   margin-right: 10px;
   font-size: 15px;
  
}

.wrapper .form .inputfield .input,
.wrapper .form .inputfield .textarea {
  width: 100%;
  outline: none;
  border: 1px solid #d5dbd9;
  font-size: 15px;
  padding: 8px 10px;
/*   border-radius: 3px; */
  transition: all 0.3s ease;
  font-family: 'Montserrat', sans-serif;
}

.wrapper .form .inputfield .textarea{
  width: 100%;
  height: 125px;
  resize: none;
 
}

.wrapper .form .inputfield .custom_select{
  position: relative;
  width: 100%;
  height: 37px;
}

.wrapper .form .inputfield .custom_select:before{
  content: "";
  position: absolute;
  top: 12px;
  right: 10px;
  border: 8px solid;
  border-color: #d5dbd9 transparent transparent transparent;
  pointer-events: none;
}

.wrapper .form .inputfield .custom_select select{
  -webkit-appearance: none;
  -moz-appearance:   none;
  appearance:        none;
  outline: none;
  width: 100%;
  height: 100%;
  border: 0px;
  padding: 8px 10px;
  font-size: 15px;
  border: 1px solid #d5dbd9;
}


.wrapper .form .inputfield .input:focus,
.wrapper .form .inputfield .textarea:focus,
.wrapper .form .inputfield .custom_select select:focus{
  border: 1px solid #B80F0A;
}

.wrapper .form .inputfield p{
   font-size: 14px;
   color: #757575;
}

.wrapper .form .inputfield .btn{
    display: inline-block;
    margin-top: 1rem;
    border-radius: 5rem;
    background:#B80F0A;
    color:#fff;
    cursor: pointer;
    box-shadow: 0 .5rem 1rem rgba(0,0,0,.1);
    transition: all .3s linear;
    padding: 8px 10px;
  	font-size: 15px; 
  	font-weight: bold;
  	border: 0px;
  	background:  #B80F0A;
    outline: none;
}

.wrapper .form .inputfield .btn:hover{
    transform: scale(1.1);
}

.wrapper .form .inputfield:last-child{
  margin-bottom: 0;
}

@media (max-width:420px) {
  .wrapper .form .inputfield{
    flex-direction: column;
    align-items: flex-start;
  }
  .wrapper .form .inputfield label{
    margin-bottom: 5px;
  }
  .wrapper .form .inputfield.terms{
    flex-direction: row;
  }
}
.wrapper .form .inputfield .btn{
    display: inline-block;
    margin-top: 1rem;
    border-radius: 5rem;
    background:#B80F0A;
    color:#fff;
    cursor: pointer;
    box-shadow: 0 .5rem 1rem rgba(0,0,0,.1);
    transition: all .3s linear;
    padding: 8px 10px;
  	font-size: 15px; 
  	font-weight: bold;
  	border: 0px;
    outline: none;
    width: 100%;
}

.wrapper .form .inputfield .btn:hover{
    transform: scale(1.1);
}

.wrapper {
  border-top: 4px solid #B80F0A;
}

.red-color span, .red-color i{
 color : var(--blue);
}

.btn-warning{
  position: relative;
  padding: 11px 16px;
  font-size: 15px;
  line-height: 1.5;
  border-radius: 3px;
  color: black;
  background-color: var(--grey);
  border: 0;
  transition: 0.2s;
  overflow: hidden; 
}

.btn-warning input[type = "file"]{
  cursor: pointer;
  position: absolute;
  left: 0%;
  top: 0%;
  transform: scale(3);
  opacity: 0;
}

.btn-warning:hover{
  background-color: var(--dark-grey);
}
</style>

<script>
var element = document.getElementById("message");
element.classList.add("active");
document.getElementById("span_compose").classList.add("red-color");
document.querySelector('#received').style.display="block";
document.querySelector('#compose').style.display="block";
document.querySelector('#arrow').style.transform="rotate(180deg)";
document.querySelector('#sent').style.display="block";


</script>
<script>
var element = document.getElementById("projects");
element.classList.add("active");
</script>