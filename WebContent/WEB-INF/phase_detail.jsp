<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="dashboard_student.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>compose</title>
    
    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    
    <!-- custom css file link  -->
    <!-- <link rel="stylesheet" href="css/style6.css"> -->
</head>
<body>
<form action="update_phase" enctype="multipart/form-data" method="post">
	<div class="wrapper" style="margin-left: 480px; margin-top: 20px;">
	    <div class="title">
	      ${ phase.getPhase() } Phase
	      <p >${ phase.getDescription() }</p>
	    </div>
	    
	    <p style="margin-top: -10px; margin-left: 150px; color: red;">${ erreur }<span style="color: green;">${ success }</span></p>
	    <div style="margin-top: 40px;" class="form-style">
			    <div class="section"><span style="margin-top: -8px;">1</span>Phase's details and file</div>
			    <div class="inner-wrap">
			        <textarea name="description" placeholder="Enter details of the phase"/>${ phase.getDetail_etudiant() }</textarea>
			    </div>
			    
			    <div style="display: flex;">
				    <div style="margin-top: -10px;" class="inner-wrap">			    	       	  
					  <div class="upload">
				      	<button onclick="change()" style="color: var(--black);" type = "button" class = "btn-warning">
				        <i class = "fa fa-upload"></i> Upload New File
				        	<input type="file" size="50" name="file" id="file-input">		        	
			      		</button>	
			      		<p style="font-size: 12px;">(max size 30KB)</p>
			      		<p style="color: var(--blue); font-size: 14px; margin-left: 10px;" id="upload-button" ></p>
			    	  </div>
				    </div>
				    <c:if test="${ phase.getFile_name() != null}">	    		    		
				    <div  id="file_form" style="margin-left: 220px;"  class="attachment-bottom">
				    <a href="download_phase?phase_id=${ phase.getId() }&projet_id=${ phase.getId_projet() }" style="text-decoration: none; color: var(--black);">
			          <i class='bx bx-file-blank'></i>
			          <p style="margin-left: 60px; margin-top: 10px;">${ phase.getFile_name()}</p>
			        </a>
			        </div>
			        </c:if>
			    </div>	
			    <div class="section"><span style="margin-top: -8px;">2</span>Progression %</div>
			    <div  class="inner-wrap">
			        <input type="number"  name="progress" placeholder="Enter a percent of realisation" value="${ phase.getPourcentage() }"/>
			    </div>
			    
			    <div class="section"><span style="margin-top: -8px;">3</span>Supervisor's comment</div>
			    <div class="inner-wrap">
			        <textarea name="description" placeholder="No comment yet" Readonly/>${ phase.getDetail_prof() }</textarea>
			    </div>
			    </div>
			    <input type="text" name="id_projet" value="${ phase.getId_projet() }" hidden>
			    <input type="text" name="id_phase" value="${ phase.getId() }" hidden>
				<input type="text" name="id_affectation" value="${ id_affectation }" hidden>
			    <div style="margin-left: 140px;" class="inputfield">
			        <a href="allphases?id_affectation=${ id_affectation }" style="color: #fff; text-decoration: none;"><button style="margin-right: 20px;"class="btn">Return</a></button>
			        <input type="submit" value="Save" class="btn">
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
  text-transform: capitalize;
}

.wrapper{
  max-width: 580px;
  width: 100%;
  background: var(--light);
  margin: 50px auto;
  box-shadow: 2px 2px 4px rgba(0,0,0,0.9);
  border-radius: 8px;
  padding: 30px;
  border-top: 4px solid #B80F0A;
}

.wrapper .title{
  font-size: 24px;
  font-weight: 700;
  margin-bottom: 25px;
  color: #B80F0A;
  text-transform: Capitalize;
  text-align: center;
}

.wrapper .title p{
  font-size: 12px;
  font-weight: 200;
  margin-bottom: 25px;
  color: #000;
  text-transform: Capitalize;
  text-align: center;
}

.form-style {
    width: 100%;
}

.form-style .inner-wrap{
	padding : 10px;
	border-radius: 6px;
	margin-left: 30px;
	margin-right: -20px;
}

.form-style label{
	display: block;
	color: #000;
	margin-bottom: 15px;
	font-size: 13px;
}

.form-style input[type="text"],
.form-style input[type="email"],
.form-style input[type="password"],
.form-style input[type="file"],
.form-style input[type="number"],
.form-style textarea {
	width: 90%;
	box-sizing: border-box;
	padding: 10px;
	border-radius: 6px;
	border: 0.1px solid var(--dark-grey);
	font-size: 15px;
	font-family: 'Montserrat', sans-serif;
	text-transform: capitalize;

}

.form-style .section{
	color: #000;
	font-size: 16px;
	padding-bottom: 8px;
}

.form-style textarea{
   min-height: 110px;
}

.form-style .section span {
	background: var(--blue);
	padding: 5px 10px 5px 10px;
	position: absolute;
	border-radius: 50%;
	-webkit-border-radius: 50%;
	-moz-border-radius: 50%;
	border: 4px solid var(--blue);
	font-size: 14px;
	font-weight: bold;
	margin-left: -45px;
	color: #fff;
	margin-top: -3px;
}


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
}

.inputfield .btn:hover{
    transform: scale(1.1);
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


.attachment-bottom {
  position: absolute;
  background: var(--grey);
  border-radius: 100%;
  height: 50px;
  width: 50px;
  margin-top: -3px;
  margin-left: 15px;
  cursor: pointer;
  transition: background 0.3s ease;
  font-size: 15px;
  line-height: 1.5;
}

.attachment-bottom i {
  font-size: 25px;
  position: absolute;
  margin-top: 11px;
  margin-left: 12px;

}

.attachment-bottom p {
	min-width: 300px;
	margin-left: 20px;
}

.attachment-bottom:hover {
  background-color: var(--dark-grey);
}
</style>

<script>
var element = document.getElementById("projet");
element.classList.add("active");
	
function change() {
	var btn = document.getElementById("upload-button");
	btn.innerHTML = 'A file was uploaded';
} 
</script>