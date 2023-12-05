<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="dashboard_prof.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Events</title>
    <link rel="stylesheet" href="././css/style1.css" />
  </head>
  <body>
	<a href="././EventForm.jsp" class="btn">+ Event</a>
	<c:forEach items="${ events }" var="event" varStatus="boucle">
    <div class="event-container" style="margin-left: 420px; max-width: 700px; background: var(--grey);">
      <h3 class="year" style="color: var(--black);">Projet ${ event.getProjet() } : ${ event.getType() } <c:if test="${ event.getStatus() != null }"><span style="font-size: 14px; color: #B80F0A">( ${ event.getStatus() } )</span></c:if></h3>
      <div class="event">
        <div class="event-left">
          <div class="event-date">
            <div class="date">${ event.getDate() }</div>
          </div>
        </div>
        <div class="event-right" style="padding: 20px 29px;" >
          <h3 class="event-title">${ event.getTitle() }</h3>
          <div style="margin-top: 10px;"  class="event-description">
           ${ event.getDetail() }<br>
           <p style="margin-top: 10px; color: #515151;"> Pair : ${ event.getAvec() }</p>
          </div>
          <div style="display: flex;">
	          <div class="event-timing">
	            <img src="image/time.png" alt="" /> ${ event.getTime() }
	          </div>
	          <div style="margin-left: 20px;" class="event-timing">
	        	<a style="color: var(--black);" href="annuler_event?date=${ event.getDate() }&heure=${ event.getTime() }&title=${ event.getTitle() }">annuler</a>
	          </div>
        </div>
      </div>
    </div>
    </div>
    </c:forEach>
  </body>
</html>

<style>
.btn{
   font-family: Robboto, sans-serif;
   display: inline-block;
   margin-top: 1.5rem;
   padding:.6rem 2.6rem;
   border-radius: 5rem;
   background:#B80F0A;
   font-size: 1.1rem;
   font-weight: bold; 
   color:#fff;
   cursor: pointer;
   box-shadow: 0 .5rem 1rem rgba(0,0,0,.1);
   transition: all .3s linear;
   text-decoration: none;
   margin-left: 950px;
}
	
.btn:hover{
   transform: scale(1.1);
}

.event-timing a:hover{
   transform: scale(1.3);
}
	   
.event {
   background: #fff;
}
</style>

<script>
var element = document.getElementById("plan");
element.classList.add("active");
</script>