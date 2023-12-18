<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="WEB-INF/prof/dashboard_prof.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event form</title>
    
    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    
</head>
<body>
<form action="AddEvent" name="myform" method="POST">
<div class="wrapper">
    <div class="title">
      Planification
    </div>
    <div class="form">
       <div class="inputfield">
          <label>Title</label>
          <input type="text" name="title" class="input" placeholder="Give a short title to your event" required>
       </div>  
       <div class="inputfield">
          <label>Type</label>
          <div class="custom_select">
            <select name="type" required>
              <option value="">Select the type of event</option>
              <option value="reunion">Réunion</option>
              <option value="travail">Travail à rendre</option>
              <option value="soutenance">Soutenance</option>
            </select>
          </div>
       </div> 
        <div class="inputfield">
          <label>Date</label>
          <input type="date" class="input" name="date" id="date" onchange="updateSelect()" required>
       </div> 
      <div class="inputfield">
          <label>Time</label>
          <input type="time" class="input" name="time">
       </div> 
      <div class="inputfield">
          <label>Details</label>
          <textarea class="textarea" name="details" placeholder="Enter event's details"></textarea>
       </div>
       <div class="inputfield">
          <label>Semestre</label>
          <div class="custom_select">
            <select name="semestre" id="semestre" onchange="updateSelect()" required>
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
          <label>Binome</label>
          <div class="custom_select" name="binome">
            <select name="affectation" id="binomes" required>
              <option value="">Select a pair</option>
            </select>
          </div>
       </div> 
      <div class="inputfield">
        <button style="margin-right: 20px;"class="btn"><a href="events_prof" style="color: #fff; text-decoration: none;">Return</a></button>
        <input type="submit" value="Add" class="btn">
      </div>
    </div>
</div>
</form>
</body>
</html>

<script type="text/javascript">

function updateSelect() {
	var dateInput= document.getElementById("date");
	var dateValue = dateInput.value;
	var date = new Date(dateValue);
	var year = date.getFullYear();
	var e = document.getElementById("semestre");
	var semestre = e.value;
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "getBinomes?year="+year+"&semestre="+semestre, true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var options = xhr.responseText.split("\n");
            updateSelectOptions(options);
        }
    };
    xhr.send();
}
function updateSelectOptions(options) {
    var select = document.getElementById("binomes");
    select.innerHTML = "";
/*     var newOption1 = document.createElement("option");
    newOption1.value = "All";
    newOption1.text = "All";
    select.add(newOption1); */
    for (var i = 0; i <options.length-1; i++) {
        var option = options[i].split(",");
        var value = option[0];
        var text = option[1];
        var newOption = document.createElement("option");
        newOption.value = value;
        newOption.text = text;
        select.add(newOption);
    }
}
</script>

<style>
.wrapper{
  border-top: 4px solid #B80F0A;
  box-sizing: border-box;
  text-transform: capitalize;
  margin-left: 450px;
  max-width: 600px;
  width: 100%;
  background: #fff;
  margin-bottom: 30px;
  margin-top: 20px;
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
</style>
