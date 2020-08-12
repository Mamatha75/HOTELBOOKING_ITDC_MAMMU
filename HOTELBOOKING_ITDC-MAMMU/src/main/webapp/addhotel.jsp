<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
  background-image: url('https://c4.wallpaperflare.com/wallpaper/141/324/22/hotel-atlantis-dubai-the-palm-wallpaper-preview.jpg');
background-size:cover;
background-attachment:fixed;
}
body{
marigin:0;
padding:0;
font-family:sans-serif;
}
.box{
position:absolute;
top:50%;
left:20%;
transform:translate(-50%,-50%);
width:400px;
padding:40px;
background: rgba(0,0,0,.5);
box-sizing: border-box;
show-shadow:0 15px 25px rgba(0,0,0,.5);
border-radius: 10px;
}
.box h2{
margin:0 0 30px;
padding:0;
color: #fff;
text-align: center;
}
.box .inputbox{
position:relative;
}
.box .inputbox input{
width:100%;
padding:10px 0;
font-size: 15px;
color:#fff;
letter-spacing:1px
margin-bottom: 30px;
border:none;
border-bottom: 1px solid #fff;
outline: none;
background: transparent;
border-radius: 5px;

}
.box input[type="submit"]{
background: transparent;
border: none;
outline: none;
color: #fff;
height:40px;
width:80px;
background: #03a9f4;
padding: :50px 20px;
cursor: pointer;
border-radius: 5px;
}



</style>

</head>
<body>
<center>
<div class="box">
<h2>
ADD HOTEL!!
</h2>
<form action="addhotel">
<div class="inputbox">
<b style="color:white">Enter Hotelname-</b><input type="text" name="hotelname"><br>
<b style="color:white">Enter hoteladdress-</b><input type="text" name="hoteladdress"><br>
<b style="color:white">Enter hotelphnno-</b><input type="text" name="hotelphnno"><br>
<b style="color:white">Enter hotelrooms-</b><input type="text" name="hotelrooms"><br>
<b style="color:white">Enter hotelcost-</b><input type="text" name="hotelcost"><br>
</div>
<input type="submit" name="AddHotel">

</form>
</div>
</center>
</body>
</html>