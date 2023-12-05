<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="dashboard_prof.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event form</title>
    
    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    
    <!-- custom css file link  -->
    <!-- <link rel="stylesheet" href="css/style2.css"> -->

</head>
<body>
<form action="addPhase" name="myform" method="POST">
	<div class="wrapper">
	    <div class="title">
	      Add Phase
	      <p style="margin-top: 10px; text-align: center; font-size: 13px; color: green;"><span style="color: #B80F0A">${ erreur }</span>${ success }</p>
	    </div>
	    
	    <div class="form">
	       <div class="inputfield">
	          <label>Title</label>
	          <input type="text" name="title" class="input" placeholder="Give a title to the phase" required>
	       </div>   
	       
	       <div class="inputfield">
	          <label>Description</label>
	          <textarea name="description" class="input" placeholder="Describe the phase" required></textarea>
	       </div>
	          
	        <input type="text" name="id_affectation" value="${ id_affectation }" hidden>
	        <input type="text" name="id_projet" value="${ id_projet }" hidden>
	        <input type="text" name="annee" value="${ annee }" hidden>
	        <input type="text" name="semestre" value="${ semestre }" hidden>
		 <div class="inputfield">
	        <button style="margin-right: 20px;"class="btn"><a href="allphases_prof?id_affectation=${ id_affectation }&annee=${ annee }&semestre=${ semestre }" style="color: #fff; text-decoration: none;">Return</a></button>
	        <input type="submit" value="Add" class="btn">
	      </div>
	    </div>
	</div>
</form>
</body>
</html>

<style>
.wrapper {
  border-top: 4px solid #B80F0A;
  box-sizing: border-box;
  text-transform: capitalize;
  margin-left: 480px;
  max-width: 600px;
  width: 100%;
  background: #fff;
  margin-bottom: 30px;
  margin-top: 80px;
  box-shadow: 2px 2px 4px rgba(0,0,0,0.9);
  border-radius: 8px;
  padding: 30px;
  font-family: 'Montserrat', sans-serif;
}

.wrapper .title{
  font-size: 24px;
  font-weight: 700;
  margin-bottom: 25px;
  color: #B80F0A;
  text-transform: capitalize;
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
.wrapper .form .inputfield .textarea{
  width: 100%;
  outline: none;
  border: 1px solid #d5dbd9;
  font-size: 15px;
  padding: 8px 10px;
  border-radius: 3px;
  transition: all 0.3s ease;
  font-family: 'Montserrat', sans-serif;
}

.wrapper .form .inputfield textarea{
  width: 100%;
  height: 150px;
  resize: none;
}


.wrapper .form .inputfield .input:focus{
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
    outline: none;
    width: 100%;
}

.wrapper .form .inputfield .btn:hover{
    transform: scale(1.1);
}

</style>
