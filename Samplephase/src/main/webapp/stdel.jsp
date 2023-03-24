<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import ="SchoolTables.Students" %>  
  <%@ page import ="SchoolTables.Section" %>  
 <%@ page import ="java.util.*" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action ="stud3" method="post">

      rollno :<input type="number" name="rno" required><br/>
      <input type ="submit" value="Delete">
 </form>
  <%
   try{
   Students h=(Students)request.getAttribute("s1");
   if(h!=null){%>
 <h1>deleted details:</h1>
  <table border ="1">
  
   <tr>
   <td>rollno</td>
   <td>fathername</td>
   <td>name</td>
   <td>class</td>
   </tr>
   <tr>
   <td><%=h.getRollno()%> </td>
   <td><%=h.getFathername()%></td>
   <td><%=h.getName()%> </td>
   <td><%=h.getS().getClassno()%></td>
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