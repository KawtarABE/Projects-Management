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
</head>
<body>
<form action="addprojet" method="post">
	<div class="wrapper" style="margin-left: 480px; margin-top: 50px;">
	    <div class="title">
	      Phase de : Validation
	    </div>
	    <p style="margin-top: -10px; margin-left: 170px; color: red;">${ erreur }<span style="color: green;">${ success }</span></p>
	    <div class="form-style">
			    <div class="section"><span style="margin-top: -8px;">1</span>Project title</div>
			    <div class="inner-wrap">
			        <input type="text"  name="title" placeholder="Enter the Title of your project" value="${ intitule }"/>
			    </div>
			
			    <div class="section"><span style="margin-top: -8px;">2</span>Project's details</div>
			    <div class="inner-wrap">
			        <textarea name="description" placeholder="Enter the details of your project"/>${ description }</textarea>
			    </div>
			    
			    <div class="section"><span style="margin-top: -8px;">3</span>Supervisor's Comment</div>
			    <div class="inner-wrap">
			        <textarea name="description_prof" placeholder="No comment yet" Readonly/>${ prof_description }</textarea>
			    </div>
			    
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

</style>

<script>
var element = document.getElementById("projet");
element.classList.add("active");
</script>