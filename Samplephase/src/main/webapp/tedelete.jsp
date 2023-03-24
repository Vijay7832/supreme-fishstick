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
<form action ="tedelServ" method="post">

      Empid :<input type="number" name="empno" required><br/>
      <input type ="submit" value="Delete">
 </form>
  <%
   try{
  Teacher h=(Teacher)request.getAttribute("s1");
   if(h!=null){%>
 <h1>deleted details:</h1>
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
   <form action ="homepage.html" method="post">
      <input type ="submit" value="go to home">
 </form>
</body>
</html>