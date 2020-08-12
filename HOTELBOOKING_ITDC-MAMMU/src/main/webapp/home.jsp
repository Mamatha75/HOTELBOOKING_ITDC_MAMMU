<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
var nav=document.getElementById('nav');

window.onscroll=function(){
	if(window.pageYOffset>100){
nav.style.position="fixed";
nav.style.top=0;
		}
	else
		{
		nav.style.position="absolute";
		nav.style.top=0;
		}
}

</script>
<style>
*{
padding:0px;
margin:0px;
box-sizing:border-box;
}
body {
  background-image: url('https://c4.wallpaperflare.com/wallpaper/141/324/22/hotel-atlantis-dubai-the-palm-wallpaper-preview.jpg');
background-size:cover;
background-attachment:fixed;
}
h1{
top:5px;
text-align:center;
}
.navbar{
width:100;
padding:50px;
position:fixed;
top:0px;
text-align:center;
transition:.5s;
}
.navbar ul li{
list-style-type:none;
display:inline-block;
padding:5px 10px;
margin:0px ;
color:white;
font-size:24px;
font-family:sans-serif;
cursor:pointer;
border-radius:1px;
}
.navbar ul li:hover{
background:#ffff00;
}
</style>
</head>

<body>
<div class="box">
<h1>
INDIAN TOURISM DEVELOPMENT CORPORATION!!
</h1>
<div class="header">
<div class="navbar" id='nav'>
<ul>
<li><a href="home.jsp"><h6>HOME</h6></a></li>
<li><a href="adminlogin.jsp"><h6>ADMINLOGIN</h6></a></li>
<li><a href="userlogin.jsp"><h6>USER LOGIN</h6></a></li>
<li><a href="newuserlogin.jsp"><h6>NEW USER LOGIN</h6></a></li>
</ul>
</div>
</div>

</body>
</html>