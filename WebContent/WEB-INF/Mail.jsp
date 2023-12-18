<!-- Directives  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="dashboard_student.jsp" %>
<%@page import="com.JAVA.Beans.Message" %>

<!-- html start -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Messages</title>
    <!-- import css and icons -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  </head>
  <body>
  <!-- Email section -->
	<div class="wrapper">	
		<!-- inbox start -->
		<div class="inbox" style="flex: 1;">
			<!-- importing and showing all messages -->
			<ul>
			<c:forEach items="${ messages }" var="message" varStatus="boucle">
			<!-- single message start -->
			 <li>
			 <a href='message_details?message_id=${ message.getId() }' style="text-decoration:none; color: black;"> 
			 <div class="all">
				  <div class="li_left">
					    <div class='thumbnail'>
	                    ${ message.getSender().charAt(0) }
	                    </div>
				  </div>
				  <div class="li_right">
					<div class="message">
					   <div style="color: black;" class="title <c:if test="${!message.isIs_read()}">unread1</c:if>">${ message.getSender() }</div>
					      <div class="sub_title <c:if test="${!message.isIs_read()}">unread</c:if>">
					      <c:choose>
						  	<c:when test="${ message.getMessage().length()<50}">${ message.getMessage()}</c:when>
						  	<c:otherwise>${ message.getMessage().substring(0, 50)}...</c:otherwise>
						  </c:choose>
						  </div>
					   </div>
					   <div class="time_status" style="position: absolute; right: 100px;">
					     <div class="time">
						     ${ message.getDate_envoie() }
						     <c:choose>
	   							<c:when test="${!message.isIs_read()}"><i style="color: var(--blue);" class="fa fa-envelope" aria-hidden="true"></i></c:when>
	   							<c:otherwise><i class="fa fa-envelope-open" aria-hidden="true"></i></c:otherwise>
							 </c:choose>
					     </div>
					     <c:if test="${ message.getFile_name() != null }">
					     	<div class="time"><i class="fa fa-paperclip" aria-hidden="true"></i></div>
					     </c:if>
					     
					   </div>
					</div>
				</div>
				</a>
			</li>
			<!-- single message end -->
			</c:forEach>
	      </ul>		
	      <!-- importing messages end -->
	     </div>
	     <!-- inbox end -->
	   </div>
	</body>
</html>
<!-- html end -->

<!-- css start -->
<style>
/* importing fonts  */
@charset "UTF-8";
@import url('https://fonts.googleapis.com/css?family=Montserrat');

/* general css */
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  text-transform: capitalize;
  list-style: none;
}

body {
   font-family: 'Montserrat', sans-serif;
} 

/* container  */
.wrapper{
  display: flex;
  justify-content: flex-start;
  align-items: stretch;
  flex-direction: row;
  padding: 30px;
  margin-left: 300px;
}

/* side menu */
.container {
	position: relative;
	display : flex;
	justify-content: center;
	align-items: center;
	height: 100%;
}

.container .navigation {
  	position: relative;
	width: 100px;
	height: 100%;
	border-radius: 20px;
	background: #F7E4DB;
}

/* messages section */
.inbox{
	flex: 1;
	min-height: 500px ;
	padding: 10px;
}

.inbox li .all{
	display: flex;
	align-items: center;
	padding: 15px 20px;
	border-bottom: 1px solid #e4edf5;
	cursor: pointer;
	background: #fff;
}

.inbox li:last-child .all{
	border-bottom: 0;
}

.inbox li .all:hover{
	background: #fdf8f4;
}

/* styling message  */
/* firt name letter */
.inbox li .all .thumbnail{
    align-self: center;
    width: 50px;
	height: 50px;
	border-radius: 50%;
    background: #B80F0A;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 20px;
    font-weight: bold;
    color: #fff;
}

.inbox li .all .li_right{
	display: flex;
}

/* message content */
.inbox li .all .message{
	margin: 0 20px;
}

.inbox li .all .message .title{
	/* font-weight: bold; */
	margin-bottom: 5px;
	font-size: 15x;
}

.inbox li .all .message .sub_title{
	font-size: 13px;
	line-height: 18px;
}

.unread {
	font-size: 12px;
	line-height: 18px;
    font-weight: bold;
}

.unread1 {
	line-height: 18px;
    font-weight: bold;
}

/* message time */
.inbox li .all .time_status .time{
	color: #ccc;
	font-size: 12px;
	margin-right: 10px;
	font-weight: bold;
}

.red-color span, .red-color i{
 color : var(--blue);
}
</style>

<script>
var element = document.getElementById("message");
element.classList.add("active");
document.getElementById("span_received").classList.add("red-color");
document.querySelector('#received').style.display="block";
document.querySelector('#compose').style.display="block";
document.querySelector('#sent').style.display="block";
document.querySelector('#arrow').style.transform="rotate(180deg)";
</script>