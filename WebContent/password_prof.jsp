<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="WEB-INF/prof/dashboard_prof.jsp" %>

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
<form action="change_password" method="post">
	<div class="wrapper" style="margin-left: 550px; margin-top: 80px;">
	    <div class="title">
	      Password
	    </div>
	    <p style="margin-top: -10px; margin-left: 120px; color: red;">${ erreur }<span style="color: green; margin-left: -70px;">${ success }</span></p>
	    <div class="form-style">
			    <div class="section"><span>1</span>Enter your password</div>
			    <div class="inner-wrap">
			        <label>Old password <input type="password" name="old_password" required/></label>
			    </div>
			
			    <div class="section"><span>2</span>Change your password</div>
			    <div class="inner-wrap">
			        <label>New password <input type="password" name="new_password" required/></label>
			    </div>
			    
			    <div class="section"><span>3</span>Confirm your password</div>
			    <div class="inner-wrap">
			        <label>Confirmed password <input type="password" name="confirm_password" required/></label>
			    </div>
			    <input type="text" name="prof" value="prof" hidden>
                <input type="submit" value="Change" class="btn">
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
  margin-left: 500px;
  max-width: 500px;
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
.form-style input[type="email"],
.form-style input[type="password"] {
	width: 90%;
	box-sizing: border-box;
	padding: 10px;
	border-radius: 6px;
	border: 0.1px solid var(--dark-grey);
	font-size: 14px;

}

.form-style .section{
	color: #000;
	font-size: 16px;
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


.btn {	
	margin-left: 320px;
    margin-top: 1rem;
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

</style>

<script>
var element = document.getElementById("password");
element.classList.add("active");
</script>