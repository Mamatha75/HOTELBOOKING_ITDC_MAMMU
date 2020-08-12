<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
  background-image: url('http://dhanbadfootballacademy.com/Logo/banner_registrationA.JPG');
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
top:40%;
left:60%;
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
<div class="box">
<h2>
USER LOGIN PAGE!!
</h2>
<form action="user">
<div class="inputbox">
Enter User phnno<input type="text" name="userphnno"><br>
Enter User Pass<input type="text" name="userpass"><br>
<input type="submit" name="userlogin"><br>
</div>
</form>
</div>
</body>
</html>