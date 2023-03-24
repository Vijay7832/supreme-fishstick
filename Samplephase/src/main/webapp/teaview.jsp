<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import ="SchoolTables.Teacher" %>  
  <%@ page import ="SchoolTables.Section" %>  
  <%@ page import ="SchoolTables.Subjects" %>  
  <%@ page import ="dao.TeacherDaoImpl" %>  
 <%@ page import ="java.util.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<h><b>teacher</b></h>
<form action ="teaview.jsp" method="post">
      empid :<input type="number" name="cn" required><br/>
      <input type ="submit" name="sub" value="view">
 </form>
</div>

<div>
 <table border ="1">
   <%
   try{
   TeacherDaoImpl j=new TeacherDaoImpl();
   List<Teacher> h=j.getAll();
 //  List<Teacher> h=(List<Teacher>)request.getAttribute("s1");%>
   <tr>
   <td>empid</td>
   <td>name</td>
   <td>experience</td>
   </tr>
   <% if(h.isEmpty()){%>
   <tr>no records found
   </tr>
  <%  }
   else{
    for(Teacher s:h){%>
   <tr>
   <td><%=s.getEmpid()%> </td>
   <td><%=s.getName()%></td>
   <td><%=s.getExperience()%> </td>
   </tr>
   <%   
   }
   }
   }
   catch(Exception e){
	   out.println(e);
   }%>
   </table>
   </div>
   <br>
   <br>
   
   
   <div>
   
   
   <%
   if(request.getParameter("sub")!=null){
   int a=Integer.parseInt(request.getParameter("cn"));
   TeacherDaoImpl k=new TeacherDaoImpl();
   Teacher hh=k.getOneClass(a);
   if(hh!=null){%>
 <h><b>Employee details:</b></h>
  <table border ="1">
  
   <tr>
    <td>empid</td>
   <td>name</td>
   <td>experience</td>
   </tr>
   <tr>
  <td><%=hh.getEmpid()%> </td>
   <td><%=hh.getName()%></td>
   <td><%=hh.getExperience()%> </td>
   </tr>
   </table >
   <h><b>subjects</b> </h>
   <table border ="1">
   <tr>
   <td>subcode</td>
   <td>subname</td>
   </tr>
   <% 
   List<Subjects> j=hh.getSub();
   for(Subjects g: j){%>
	   <tr>
	   <td><%= g.getSubjectno()%></td>
	   <td><%=g.getSubjectname()%></td>
	   </tr>
  <% }%>
   </table>
   <%   
   }
   else{%>
	   <h>no records found</h>
 <%  
   }
   }
   %>
   
   
  </div>
   <br>
   
   <div>
   <form action ="homepage.html" method="post">
      <input type ="submit" value="go to home">
 </form>
</div>
</body>
</html>