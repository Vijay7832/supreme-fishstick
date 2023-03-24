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
<h><b>Students list</b></h>
    <table border ="1">
   <%
   try{
   List<Students> h=(List<Students>)request.getAttribute("s1");%>
   <tr>
   <td>rollno</td>
   <td>fathername</td>
   <td>name</td>
   <td>class</td>
   </tr>
   <% if(h.isEmpty()){%>
   <tr>no records found
   </tr>
  <%  }
   else{
    for(Students s:h){%>
   <tr>
   <td><%=s.getRollno()%> </td>
   <td><%=s.getFathername()%></td>
   <td><%=s.getName()%> </td>
   <td><%=s.getS().getClassno()%></td>
   </tr>
   <%   
   }
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