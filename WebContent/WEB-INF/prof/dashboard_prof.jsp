<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- Boxicons -->
	<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
	<!-- My CSS -->
	<link rel="stylesheet" href="././css/dashboard.css">

	<title>Prof</title>
</head>
<body>

	<!-- SIDEBAR -->
	<section id="sidebar">
		<a href="#" class="brand">
			<span class="text" style="color: var(--black); margin-left: 59px;">Smart</span>Projects
		</a>
		<ul class="side-menu top">
			<li id="dashboard">
				<a href="home_prof">
					<i class='bx bxs-dashboard' ></i>
					<span class="text">Dashboard</span>
				</a>
			</li>
			<li id="profil">
				<a href="profil_prof">
					<i class='bx bx-user-pin'></i>
					<span class="text">Profil</span>
				</a>
			</li>
			<li id="projet">
				<a href="affectations_prof">
					<i class='bx bx-list-ul' ></i>
					<span class="text">Affectations & Projects</span>
				</a>
			</li>
			<li id="plan">
				<a href="events_prof">
					<i class='bx bxs-calendar-event'></i>
					<span class="text">Plannification</span>
				</a>
			</li>
			<li id="message">
				<a href="#">
				<i class='bx bx-envelope' ></i>
				<span class="text">Messages</span>
				<i id="arrow" style="font-size: 10px; margin-left: 90px; margin-top: 3px;" class='bx bxs-down-arrow'></i>
				</a>
		   </li>
		   <li id="compose" style="display: none; margin-left: 30px;">
				<a id="span_compose" href="compose_prof">
				<i  class='bx bxs-pencil'></i>
				<span  class="text">Compose</span>
				</a>
		  </li>
		  <li id="received" style="display: none; margin-left: 30px;">
				<a id="span_received" href="mail_prof">
				<i class='bx bxs-inbox' ></i>
				<span class="text">Received</span>
				</a>
		  </li>
		  <li id="sent" style="display: none; margin-left: 30px;">
				<a id="span_sent" href="sent_mail_prof">
				<i  class='bx bxs-send'></i>
				<span class="text">Sent</span>
				</a>
				
			</li>	
		    <li id="password">
				<a href="./password_prof.jsp">
					<i class='bx bx-lock-alt' ></i>
					<span class="text">Password</span>
				</a>
			</li>
			<li>
				<a href="index.html" class="logout">
					<i class='bx bxs-log-out-circle' ></i>
					<span class="text">Logout</span>
				</a>
			</li>
		</ul>
	</section>
	<!-- SIDEBAR -->



	<!-- CONTENT -->
	<section id="content">
	
		<!-- NAVBAR -->
		<nav>
			<i class='bx bx-menu' ></i>
			<!--<a href="#" class="nav-link">Categories</a>-->
			<form action="#">
				<div class="form-input">
					<input type="search" placeholder="Search...">
					<button type="submit" class="search-btn"><i class='bx bx-search' ></i></button>
				</div>
			</form>
			<input type="checkbox" id="switch-mode" hidden>
			<label for="switch-mode" class="switch-mode"></label>
<!-- 			<a href="home.jsp" class="notification">
				<i class='bx bxs-bell' ></i>
				<span class="num">8</span>
			</a> -->
		</nav>
		<!-- NAVBAR -->

		
	</section>
	<!-- CONTENT -->
</body>
</html>

<script type="text/javascript">
let message = document.querySelector('#message');
let compose = document.querySelector('#compose');
let received = document.querySelector('#received');
let sent = document.querySelector('#sent');
let arrow = document.querySelector('#arrow');


message.addEventListener('click',()=>{
	if(compose.style.display == "block" || received.style.display == "block" || sent.style.display == "block") {
		compose.style.display = "none";
		received.style.display = "none";
		sent.style.display = "none";
		arrow.style.transform = "rotate(0deg)"
	} else {
		compose.style.display = "block";
		received.style.display = "block";
		sent.style.display = "block";
		arrow.style.transform = "rotate(180deg)"
	}
});
// TOGGLE SIDEBAR
const menuBar = document.querySelector('#content nav .bx.bx-menu');
const sidebar = document.getElementById('sidebar');

menuBar.addEventListener('click', function () {
	sidebar.classList.toggle('hide');
})

const searchButton = document.querySelector('#content nav form .form-input button');
const searchButtonIcon = document.querySelector('#content nav form .form-input button .bx');
const searchForm = document.querySelector('#content nav form');

searchButton.addEventListener('click', function (e) {
	if(window.innerWidth < 576) {
		e.preventDefault();
		searchForm.classList.toggle('show');
		if(searchForm.classList.contains('show')) {
			searchButtonIcon.classList.replace('bx-search', 'bx-x');
		} else {
			searchButtonIcon.classList.replace('bx-x', 'bx-search');
		}
	}
})


if(window.innerWidth < 768) {
	sidebar.classList.add('hide');
} else if(window.innerWidth > 576) {
	searchButtonIcon.classList.replace('bx-x', 'bx-search');
	searchForm.classList.remove('show');
}


window.addEventListener('resize', function () {
	if(this.innerWidth > 576) {
		searchButtonIcon.classList.replace('bx-x', 'bx-search');
		searchForm.classList.remove('show');
	}
})

const switchMode = document.getElementById('switch-mode');

switchMode.addEventListener('change', function () {
	if(this.checked) {
		document.body.classList.add('dark');
	} else {
		document.body.classList.remove('dark');
	}
})
</script>
