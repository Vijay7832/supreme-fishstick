<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="SchoolTables.Teacher" %>  
    <%@ page import ="SchoolTables.Subjects" %>  
 <%@ page import ="java.util.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action ="teset" method="post">

      Empid :<input type="number" name="emno" required><br/>
      Subjectno : <input type="number" name="sub" required><br/>
      <input type ="submit" value="set">
 </form>
 <%
   try{
  Teacher h=(Teacher)request.getAttribute("s1");
   if(h!=null){%>
 <h>Employee details:</h>
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
   </table border ="1">
   <h1>subjects </h1>
   <table>
   <tr>
   <td>subno</td>
   <td>subname</td>
   </tr>
   <% 
   List<Subjects> j=h.getSub();
   for(Subjects g: j){%>
	   <tr>
	   <td><%= g.getSubjectno()%></td>
	   <td><%=g.getSubjectname()%></td>
	   </tr>
  <% }%>
   </table>
   <%   
   }
   }
   catch(Exception e){
	   out.println(e);
   }%>
  
   
</body>
</html>