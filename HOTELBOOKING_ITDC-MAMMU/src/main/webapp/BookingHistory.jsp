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

 

    <table border="1" style="padding: 0px;">
    <caption><h2>USER BOOKING HISTORY</h2></caption>
        <thead>
            <tr>
                <th>userid</th>
                <th>userphnno</th>
                <th>hotelname</th>
                <th>hoteladdress</th>
                <th>hotelphnno</th>
                <th>userrroms</th>
                <th>hotelcost</th>
                <th>fromdate</th>
                <th>todate</th>
                <th>bookeddate</th>
                <th>Status</th>
                <th>Request For Cancel</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="s" items="${list}">
            <form action="userGaveCancelRequest">
            <tr>
                    <td><input type="hidden" name="userid" value="${s.userid}">${s.userid}</td>
                    <td><input type="hidden" name="userphnno" value="${s.userphnno}">${s.userphnno}</td>
                    <td><input type="hidden" name="hotelname" value="${s.hotelname}">${s.hotelname}</td>
                    <td><input type="hidden" name="hoteladdress" value="${s.hoteladdress}">${s.hoteladdress}</td>
                    <td><input type="hidden" name="hotelphnno" value="${s.hotelphnno}">${s.hotelphnno}</td>
                    <td><input type="hidden" name="userrroms" value="${s.userrroms}">${s.userrroms}</td>
                    <td><input type="hidden" name="hotelcost" value="${s.hotelcost}">${s.hotelcost}</td>
                    <td><input type="hidden" name="fromdate" value="${s.fromdate}">${s.fromdate}</td>
                    <td><input type="hidden" name="todate" value="${s.todate}">${s.todate}</td>
                    <td><input type="hidden" name="bookeddate" value="${s.bookeddate}">${s.bookeddate}</td>
                    <td><input type="hidden" name="status" value="${s.status}">${s.status}</td>
                    <td><button id="firstbutton" onclick="disablefirstbutton()">Cancel</button></td>
                </tr>
            </form>
                
                
            </c:forEach>
        </tbody>
    </table>
    
    <hr>
   
</body>
</html>