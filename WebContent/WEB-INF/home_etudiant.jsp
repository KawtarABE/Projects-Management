<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="dashboard_student.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style9.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
   <main>
      <div class="cards">
         <div class="card-single">
            <div>
	            <h2>${ count_messages }</h2>
	            <p>New Messages</p>
	        </div>
	        <div>
	              <span class="fas fa-users"><i style="font-size: 35px; margin-left: -60px;" class='bx bx-envelope'></i></span>
	        </div>
         </div>
          	
        <div class="card-single">
        	<div>
	            <h2>${ count_events }</h2>
	            <p>Coming Events</p>
	        </div>
	        <div>
	              <span class="fas fa-users"><i style="font-size: 35px; margin-left: -60px;" class='bx bx-calendar-event'></i></span>
	        </div>
        </div>
         
        <div class="card-single">  	
          	<div>
	            <h2>${ count_projet }</h2>
	            <p>Projects</p>
	        </div>
	        <div>
	              <span class="fas fa-users"><i style="font-size: 35px; margin-left: -60px;" class='bx bx-laptop'></i></span>
	        </div>
        </div>
          	
         <div class="card-single"> 	
          	<div>
	            <h2>${ count_phases }</h2>
	            <p>Incomplete phases</p>
	        </div>
	        <div>
	              <span class="fas fa-users"><i style="font-size: 35px; margin-left: -60px;" class='bx bx-loader-alt'></i></span>
	        </div>
         </div>
	  </div>
    

        <div style="margin-left: 120px;" class="recent-grid">
          <div class="projects">
            <div class="card">
              <div class="card-header">
                <h2>Recent Work</h2>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table width="100%">
                  <thead>
                    <tr>
                      <td>Project Title</td>
                      <td>Phase</td>
                      <td>Progress</td>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${ list }" var="recent" varStatus="boucle">
                  	<tr>
                  	   <td>${ recent.getIntitule() }</td>
                  	   <td>${ recent.getPhase() }</td>
                  	   <td>${ recent.getPourcentage() }%</td>
                  	</tr>  
                  </c:forEach>
                  </tbody>
                </table>
                </div>
              </div>
            </div>
          </div>
         </div>
      </main>

</body>
</html>

<style>
@charset "UTF-8";
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500&display=swap');

:root{
  --main-color: #11101d;
  --color-dark: #1D2231;
  --text-grey:  #8390A2;
}

main{
  width: 70%;
  margin-left: 27%;
  margin-top: 30px;
  padding: 2rem 1.5rem;
  min-height: 400px;
  padding: 10px;
  box-sizing: border-box;
  list-style: none;
  text-decoration: none;
  font-family: 'Poppins' ,sans-serif;
}

.cards{
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-gap: 2rem;
  margin-top: 1rem; 
}

.card-single{
  border-top: 4px solid #B80F0A;
  display: flex;
  justify-content: space-between;
  background: #fff;
  padding: 2rem;
  border-radius: 12px;
  box-shadow: 0 5px 10px rgba(154,160,185,.05), 0 15px 40px rgba(166,173,201,.2);
}

.card-single i {
  color: #B80F0A;
}

.card-single p {
  white-space: nowrap;
  float: left;
  font-size: 15px;
  white-wrap:  nowrap;
  margin-top: 10px;
  font-family: 'robotto' ,sans-serif;
  letter-space: 3px;
}

.recent-grid{
  margin-top: 3.5rem;
  /* display: grid; */
  /* grid-gap: 2rem; */
 /*  grid-template-columns: 65% auto; */
  width: 900px;
}

.card{
  background: #fff;
  border-radius: 12px;
  box-shadow: 0 5px 10px rgba(154,160,185,.05), 0 15px 40px rgba(166,173,201,.2);
  padding: 1rem;
  /* border-top: 4px solid #B80F0A; */ 
}
.card-header
{
  padding: 1.1rem;
  text-align: center;
}

.card-header{
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid #f0f0f0;
}

table{
  border-collapse: collapse;
}

thead tr{
  border-top: 1px solid #f0f0f0;
  border-bottom:2px solid #f0f0f0;

}

thead td{
  font-weight: 550;
}

td{
  padding: .5rem 1rem ;
  font-size: .9rem ;
  color: #222; 
}

tr td:last-child{
  display: flex;
  align-items: center;
}
</style>

<script>
var element = document.getElementById("dashboard");
element.classList.add("active");
</script>