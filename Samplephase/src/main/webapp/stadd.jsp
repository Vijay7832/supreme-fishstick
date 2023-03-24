<!DOCTYPE html>
     <%@ page import ="SchoolTables.Students" %>  
  <%@ page import ="SchoolTables.Section" %>  
 <%@ page import ="java.util.*" %>  
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h><b>student</b></h>
 <form action ="studadd" method="post">

      rollno :<input type="number" name="rno" required><br/>
      fathername : <input type="text" name="fname" required><br/>
      name: <input type="text" name="name" required><br/>
      class  : <input type="number" name="cla" required><br/>
      <input type ="submit" value="Add">
 </form>
 <%
   try{
   Students h=(Students)request.getAttribute("s1");
   if(h!=null){%>
 <h1>Added details:</h1>
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