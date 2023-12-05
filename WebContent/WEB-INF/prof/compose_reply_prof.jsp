<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="dashboard_prof.jsp" %>
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
<form action="send_reply_prof" enctype="multipart/form-data" name="myform" method="post">
<div class="wrapper" style="margin-left: 470px; margin-top: 80px;">
    <div class="title">
      New Message
    </div>
    <div class="form">
       <div class="inputfield">
          <label>To :</label>
          <div class="custom_select">
            <select name="receiver" required>
              <option value="${ id_receiver }">${ receiver }</option>
             </select>
          </div>
       </div>  
       <div class="inputfield">
          <label>Subject :</label>
          <input type="text" name="title" class="input" placeholder="Give the message subject" required>
       </div>   
      <div class="inputfield">
          <label>Message :</label>
          <textarea class="textarea" name="details" placeholder="Enter your message"></textarea>
       </div>
       <div class="inputfield">
       	  <label>Import File :</label>
		  <div style="margin-left: -60px;" class="upload">
	      	<button style="color: var(--black);" type = "button" class = "btn-warning">
	        <i class = "fa fa-upload"></i> Upload File
	        	<input type="file" size="50" name="file">
      		</button>	
    	  </div>
       </div> 
       <input type="text" name="isresponse_to" value="${ isresponse_to }" hidden>
      <div class="inputfield">
        <button style="margin-right: 20px;"class="btn"><a href="message_details?message_id=${ isresponse_to }" style="color: #fff; text-decoration: none;">Cancel</a></button>
        <input type="submit" value="Send" class="btn">
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
.wrapper .form .inputfield .textarea{
  width: 100%;
  outline: none;
  border: 1px solid #d5dbd9;
  font-size: 15px;
  padding: 8px 10px;
  border-radius: 3px;
  transition: all 0.3s ease;
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
.wrapper .form .inputfield .check{
  width: 15px;
  height: 15px;
  position: relative;
  display: block;
  cursor: pointer;
}
.wrapper .form .inputfield .check input[type="checkbox"]{
  position: absolute;
  top: 0;
  left: 0;
  opacity: 0;
}
.wrapper .form .inputfield .check .checkmark{
  width: 15px;
  height: 15px;
  border: 1px solid #fec107;
  display: block;
  position: relative;
}
.wrapper .form .inputfield .check .checkmark:before{
  content: "";
  position: absolute;
  top: 1px;
  left: 2px;
  width: 5px;
  height: 2px;
  border: 2px solid;
  border-color: transparent transparent #fff #fff;
  transform: rotate(-45deg);
  display: none;
}
.wrapper .form .inputfield .check input[type="checkbox"]:checked ~ .checkmark{
  background: #fec107;
}

.wrapper .form .inputfield .check input[type="checkbox"]:checked ~ .checkmark:before{
  display: block;
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
