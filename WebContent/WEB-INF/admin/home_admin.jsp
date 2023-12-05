<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="dashboard_admin.jsp" %>
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
	            <h2>${ students }</h2>
	            <p>Students</p>
	        </div>
	        <div>
	              <span class="fas fa-users"><i style="font-size: 35px; margin-left: -60px;" class='bx bxs-graduation'></i></span>
	        </div>
         </div>
          	
        <div class="card-single">
        	<div>
	            <h2>${ profs }</h2>
	            <p>Professors</p>
	        </div>
	        <div>
	              <span class="fas fa-users"><i style="font-size: 35px; margin-left: -60px;" class='bx bxs-user'></i></span>
	        </div>
        </div>
         
        <div class="card-single">  	
          	<div>
	            <h2>${ year_projets }</h2>
	            <p>Year's Projects</p>
	        </div>
	        <div>
	              <span class="fas fa-users"><i style="font-size: 35px; margin-left: -60px;" class='bx bx-laptop'></i></span>
	        </div>
        </div>
          	
         <div class="card-single"> 	
          	<div>
	            <h2>${ projets }</h2>
	            <p>Total projects</p>
	        </div>
	        <div>
	              <span class="fas fa-users"><i style="font-size: 35px; margin-left: -60px;" class='bx bx-laptop'></i></span>
	        </div>
         </div>
	  </div>
    
	<div class="chart">
		<div class="chart-wrap vertical">
		  <h2 class="title">Projects per Year</h2> 
		  <div class="grid">
			  <c:forEach items="${ list }" var="chart" varStatus="boucle">
			      <div class="bar" style="--bar-value:${ chart.getCount() * 10 }%;" data-name="${ chart.getAnnee() }, ${ chart.getCount() }"></div>
			  </c:forEach>  
		  </div>
		</div>
	</div>
</main>

</body>
</html>

<style>
@charset "UTF-8";
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500&display=swap');

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

.chart {
	background-color: #fff;
	height: 400px;
	width: 680px;
	margin-left: 80px;
	border-radius: 12px;
}

.chart-wrap {
  margin-left: -20px;
  font-family: sans-serif;
  height: 600px;
  width: 300px;
}

.chart-wrap .title {
  /* font-weight: bold; */
  font-size: 1.2em;
  padding: 0.5em 0 0.1em 0;
  text-align: center;
  white-space: nowrap; 
  margin-left: 300px;
  margin-top: 40px;
  margin-left: 285px;
}

.chart-wrap.vertical .grid {
  transform: translateY(-100px) translateX(220px) rotate(-90deg);
}

.chart-wrap.vertical .grid .bar::after {
  transform: translateY(-50%) rotate(45deg);
  display: block;
}

.chart-wrap .grid {
  position: relative;
  padding: 5px 0 5px 0;
  height: 100%;
  width: 100%;
  border-left: 2px solid #aaa;
  background: repeating-linear-gradient(90deg, transparent, transparent 19.5%, rgba(170, 170, 170, 0.7) 20%);
}

.chart-wrap .bar {
  width: var(--bar-value);
  height: 50px;
  margin: 80px 0px;
  background-color: #B80F0A;
  border-radius: 0 3px 3px 0;
}

.chart-wrap .bar::after {
  content: attr(data-name);
  margin-left: 100%;
  padding: 10px;
  display: inline-block;
  white-space: nowrap;
}
</style>

<script>
var element = document.getElementById("dashboard");
element.classList.add("active");
</script>