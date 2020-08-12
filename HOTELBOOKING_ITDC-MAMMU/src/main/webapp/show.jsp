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
background-color:skyblue;
background-color:cover;
}
</style>
</head>
<body>
<h2>ALL HOTEL DETAILS</h2>
<table border="1" style="padding: 0px;">

 

<!-- <tr>
<h3>
<th>hotelname</th>
<th>hoteladdress</th>
<th>hotelphnno</th>
<th>non_ac_rooms</th>
<th>non_ac_cost</th>
<th>ac_rooms</th>
<th>ac_cost</th>
</h3>
</tr> -->
<tr>
<th>hotelname</th>
<th>hoteladdress</th>
<th>hotelphnno</th>
<th>hotelrooms</th>
<th>hotelcost</th>

<th>
</tr>
 <c:forEach var="s" items="${list}">
         <tr> 
                <td><h4> <c:out value="${s.hotelname}"></c:out></h4> </td>
              
                <td><h4> <c:out value="${s.hoteladdress}"></c:out> </h4></td>
                    
             
                <td><h4>   <c:out value="${s.hotelphnno}"></c:out></h4></td> 
                    
                <td><h4> <c:out value="${s.hotelrooms}"></c:out> </h4></td>
                  <td><h4>  <c:out value="${s.hotelcost}"></c:out></h4> </td>
                  
                 
                  
                    
                   
               </tr>
        
        
    </c:forEach>
   </table>
</body>



</html>
