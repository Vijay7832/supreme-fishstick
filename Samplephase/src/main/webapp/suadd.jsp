<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <%@ page import ="SchoolTables.Subjects" %>  
 <%@ page import ="dao.SubjectDaoImpl" %>
 <%@ page import ="java.util.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action ="clsub.jsp" method="post">
      <input type ="submit" value="ADD">
 </form>
 <br>
 <br>
 <%
   try{
   SubjectDaoImpl v=new SubjectDaoImpl();
   List<Subjects> h=v.getAll();
		   
   if(h!=null){%>
 <h><b>All Subject code details:</b></h>
  <table border ="1">
   <tr>
   <td>subcode</td>
   <td>subname</td>
   </tr>
   <% for(Subjects d:h){%>
   <tr>
   <td><%=d.getSubjectno()%> </td>
   <td><%=d.getSubjectname()%></td>
   </tr>
   <%   
   }
   }
   }
   catch(Exception e){
	   out.println(e);
   }%>
   </table>
   <br>
   <br>
   <form action ="homepage.html" method="post">
      <input type ="submit" value="go to home">
 </form>
</body>
</html>