<!-- directive start -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="dashboard_prof.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- html start -->
<!DOCTYPE html>
<html>
<!-- title/css section  -->
<head>
<meta charset="UTF-8">
<title> Message </title>
<link rel="stylesheet" href="./css/style5.css" />
<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
</head>
<!-- body section -->
<body>
<!-- email container -->
  <div class="email-content" id="inbox-screen">
    <div class="email-text">
    
     <!--  sender section -->
     <div class="top-section">
        <h2 style="color: black;">Subject : ${ message.getSubject() }</h2>
        <p style="color: black;"> to : ${ message.getReceiver() } <span class="date"> at ${ message.getDate_envoie() } </span></p>
        <!-- icon section -->
        <div class="attachment">
          <a style="text-decoration: none; color: var(--black);" href="delete_message_prof?message_id=${ message.getId() }&action=send">
          <i style="font-size: 20px; left: 9.5px; top: 9.5px; " class='bx bxs-trash'></i>
          </a>
        </div>
        <div style="right: 45px;" class="attachment reply">
        <a style="text-decoration: none; color: var(--black);" href="sent_mail_prof">
          <i class='bx bx-arrow-back' ></i>
        </a>
        </div>
	 </div>
    <!-- sender section end -->
    
    <!-- content section -->
     <div class="bottom-section">
	  <p style="color: black;">${ message.getMessage() }</p>
	  	<c:if test="${ message.getIsresponse_to() != 0}">
		  	<div style="margin-top: 70px; margin-left: 10px;">
		  	  <p style="font-weight: bold; color:black;">answring : <p>
	          <p style="margin-left: 20px; color:black;">At ${ message_responseto.getDate_envoie() }, ${ message_responseto.getSender() } writes </p>
	          <p style="margin-left: 20px; color:black;">${ message_responseto.getMessage() }</p>
	        </div>
		</c:if>
	 </div>
	 
	<!--  attachement section -->
	<div>
		<c:if test="${ message.getFile_name() != null}">
		<div class="top">
		    <div  class="attachment-bottom">
		    <a href="download?message_id=${ message.getId() }" style="text-decoration: none; color: var(--black);">
	          <i class='bx bx-file-blank'></i>
	          <p style="margin-left: 50px; margin-top: 10px;">${ message.getFile_name()}</p>
	        </a>
	        </div>
	    </div>
		</c:if>
 	</div>
  </div>
</div>
 </body>
<!-- css start -->
<style>
.red-color span, .red-color i{
 color : var(--blue);
}

.email-content .email-text .top-section .attachment :hover, .attachment-bottom :hover i {
color: #fff;
}
</style>

<!-- js start -->
<script>
var element = document.getElementById("message");
element.classList.add("active");
document.getElementById("span_sent").classList.add("red-color");
document.querySelector('#received').style.display="block";
document.querySelector('#compose').style.display="block";
document.querySelector('#arrow').style.transform="rotate(180deg)";
document.querySelector('#sent').style.display="block";
</script>