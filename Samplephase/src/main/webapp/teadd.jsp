<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <%@ page import ="SchoolTables.Teacher" %>  
 <%@ page import ="java.util.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<h><b>Teacher</b></h>
<form action ="teaddSer" method="post">

      Empid :<input type="number" name="rno" required><br/>
      Name : <input type="text" name="name" required><br/>
      Experience: <input type="number" name="exp" required><br/>
      <input type ="submit" value="Add">
 </form>
 </div>
 <br>
 <br>
 
 <div>
 <%
   try{
   Teacher h=(Teacher)request.getAttribute("s1");
   if(h!=null){%>
 <h1>Added details:</h1>
  <table border ="1">
   <tr>
   <td>empid</td>
   <td>name</td>
   <td>experience</td>
   </tr>
   <tr>
   <td><%=h.getEmpid()%> </td>
   <td><%=h.getName()%></td>
   <td><%=h.getExperience()%> </td>
   </tr>
   <%   
   }
   }
   catch(Exception e){
	   out.println(e);
   }%>
   </table>
   </div>
   <br>
   
   <div>
   <form action ="homepage.html" method="post">
      <input type ="submit" value="go to home">
 </form>
 </div>
 
</body>
</html>