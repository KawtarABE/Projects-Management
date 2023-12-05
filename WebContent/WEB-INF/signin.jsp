<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <title>Events</title>
    <link rel="stylesheet" href="./css/style4.css" />
  </head>
<body>
<!-- header section starts  -->
<header>
	<a href="#" class="logo"><span>Smart</span>Projects</a>
	<nav class="navbar">
	<a href="./index.html">home</a>
	<a href="./index.html#about">about</a>
	<a href="./index.html#footer">contact</a>
	</nav>
</header>
<!-- header section ends -->
<div id="content">
        <h1>Welcome !</h1>
        <p>Get to manage your projects<p>
        <p style="color: red; margin-top: 10px;">${ erreur }<p>
        <form action="Validation_signin" method="post">
            <div class="input-bar">
                <label for="name">User Code</label>
                <input type="text"  name="code" id="name" class="input">
                <i class='bx bxs-user'></i>
            </div>
            <div class="input-bar">
                <label for="password">password</label>
                <input type="password" name="password" class="input">
                <i class='bx bxs-lock-alt'></i>
            </div>
        <button type="submit" class="btn">Sign in</button>
        </form>
    </div>
</body>
</html>
<script>
const input = document.querySelectorAll('.input');

function inputFocus() {
    this.parentNode.classList.add('focus');
}

function inputBlur() {
    if(this.value == '' || this.value === null){
        this.parentNode.classList.remove('focus');
    }
}

input.forEach((e) => {
    e.addEventListener('focus', inputFocus);
    e.addEventListener('blur', inputBlur);
})
</script>