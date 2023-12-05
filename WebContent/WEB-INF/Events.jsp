<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="dashboard_student.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Events</title>
    <link rel="stylesheet" href="./css/style1.css" />
  </head>
  <body>
	<c:forEach items="${ events }" var="event" varStatus="boucle">
    <div class="event-container" style="max-width: 700px; background: var(--grey);">
      <h3 class="year" style="color: var(--black);">Projet ${ event.getProjet() } : ${ event.getType() } <c:if test="${ event.getStatus() != null }"><span style="font-size: 14px; color: #B80F0A">( ${ event.getStatus() } )</span></c:if></h3>
      <div class="event">
        <div class="event-left">
          <div class="event-date">
            <div class="date">${ event.getDate() }</div>
          </div>
        </div>
        <div class="event-right" style="padding: 20px 29px;">
          <h3 class="event-title">${ event.getTitle() }</h3>
          <div style="margin-top: 10px;" class="event-description">
           ${ event.getDetail() }<br>
          <p style="margin-top: 10px; color: #515151;"> Supervisor : ${ event.getAvec() }</p>
          </div>
          <div class="event-timing">
            <img src="image/time.png" alt="" /> ${ event.getTime() }
          </div>
      </div>
    </div>
    </div>
    </c:forEach>
  </body>
</html>


<style>
.event {
background: #fff;
}
</style>

<script>
var element = document.getElementById("plan");
element.classList.add("active");
</script>