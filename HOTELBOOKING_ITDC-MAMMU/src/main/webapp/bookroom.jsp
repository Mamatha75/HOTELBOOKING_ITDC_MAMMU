<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{

}
</style>

</head>

<body onload="addDate();">
<center>
<table>
<tr>
   <td><center> <h2>BOOKING FORM</h2></center></td>
<form action="conformbooking">
<tr><td>ENTER USER ID        -<input type="text" name="userid"></td></tr>
<tr><td>ENTER FROMDATE       -<input type="text" name="fromdate" placeholder="dd-mm-yyyy"></td></tr>
<tr><td>ENTER TODATE         -<input type="text" name="todate" placeholder="dd-mm-yyyy"></td></tr>
<tr><td>NUMBER OF ROOMS      -<input type="text" name="userrroms"></td><br>
<tr> <td>Day You are Booking -<input type ="text"  id="date" name="bookeddate" readonly="readonly"></td> </tr>
    

 <tr><td><center><input type="submit" value="Book Now"> </center></td></tr>
 

</form>
</tr>
</table>
</center>

 <script>
        function addDate() {
            date = new Date();
            var month = date.getMonth() + 1;
            var day = date.getDate();
            var year = date.getFullYear();

 

            if (document.getElementById('date').value == '') {
                document.getElementById('date').value = day + '-' + month + '-'
                        + year;
            }
        }
    </script>



</body>
</html>