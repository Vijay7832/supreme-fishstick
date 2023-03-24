<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="SchoolTables.Teacher" %>   
 <%@ page import ="java.util.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action ="teupServ" method="post">

      Empid :<input type="number" name="rno" required><br/>
      Name : <input type="text" name="name" required><br/>
      Experience: <input type="number" name="exp" required><br/>
      <input type ="submit" value="UPDATE">
       </form>
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
 <form action ="homepage.html">
      <input type ="submit" value="go to home">
 </form>


</body>
</html>