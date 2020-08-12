<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
marigin:0;
padding:0;
font-family:sans-serif;

background-color:cover;
}
</style>
</head>

<body>
<h2>VIEW HOTEL LIST & DETAILS</h2>
 <c:forEach var="hotel" items="${list}">
    <fieldset style="width: 300px; height: 300px; border-radius: 10px; border: solid 2px black;">
        <form action = "userbookroom">
            <h2><input type="hidden" name="hotelname" value="${hotel.hotelname}">HOTEL NAME : ${hotel.hotelname}</h2>
            <h4><input type="hidden" name="hoteladdress" value="${hotel.hoteladdress}">HOTEL ADDRESS : ${hotel.hoteladdress}</h4>
            <h4><input type="hidden" name="hotelphnno" value="${hotel.hotelphnno}">HOTEL PHNNO : ${hotel.hotelphnno}</h4>
            <h4><input type="hidden" name="hotelrooms" value="${hotel.hotelrooms}">HOTEL ROOMS : ${hotel.hotelrooms}</h4>
            <h4><input type="hidden" name="hotelcost" value="${hotel.hotelcost}">HOTEL COST : ${hotel.hotelcost}</h4>
            
            <input type ="submit" value="Book Now">
        </form>
      </fieldset> <br>
    </c:forEach>
    <input type="hidden">
</body>
</html>
<!-- "hotelname":"h1",
"hoteladdress":"a1",
"hotelphnno":9876543210,
"non_ac_rooms":200,
"non_ac_cost":10,
"ac_rooms":100,
"ac_cost":20 -->
