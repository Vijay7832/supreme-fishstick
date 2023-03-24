<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import= "dao.SectionDaoImpl" %> 
<%@ page import= "dao.TeacherDaoImpl" %> 
 <%@ page import= "SchoolTables.Section" %> 
 <%@ page import= "SchoolTables.Subjects" %> 
 <%@ page import= "SchoolTables.Teacher" %> 
 <%@ page import ="java.util.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h><b>view class details</b></h>
<div>
<form action ="clteach.jsp" method="post">
      classno :<input type="number" name="cn" required><br/>
      <input type ="submit"  name="sub" value="view">
 </form>
 </div>
 <br>
 <br>

<div>
<h><b>set class subjects</b></h>
<form action ="clteachset" method="post">

      classno :<input type="number" name="cno" required><br/>
      tempid : <input type="number" name="empid" required><br/>
      Subjno:<input type="number" name="sno" required><br/>
      <input type ="submit" value="Add">
 </form>
 </div>
 <br>
 
 <% Section hf=(Section)request.getAttribute("s1");
 if(hf!=null) {%>
 <h>records added<h>
<% }%> 
 
 
 <%
 TeacherDaoImpl j=new TeacherDaoImpl();
 List<Teacher> h=j.getAll();
 %>
 <div>
  <table border ="1">
  <h><b>teacher details:</b></h>
   <tr>
   <td>Emp id</td>
    <td>Name</td>
     <td>Subjects</td>
   </tr>
   <% if(h.isEmpty()){%>
   <tr>no records found
   </tr>
  <%  }
   else{
    for(Teacher s:h){%>
   <tr>
   <td><%=s.getEmpid()%> </td>
   <td><%=s.getName()%> </td>
   <td><%=s.getSub() %></td>
   </tr>
   <%
   }
   }
   %>
   </table>
   </div>
   <br>
   <br>
    
    
    <%
 if(request.getParameter("sub")!=null){
	 int a=Integer.parseInt(request.getParameter("cn"));
	 SectionDaoImpl k=new SectionDaoImpl();
	 Section aa=k.getOneClass(a);
	 List<Subjects> t=aa.getSub();
 %> 
 <h> <b>Details of class <%=a %></b></h>
 <div>
  <table border ="1">
   <tr>
   <td>subcode</td>
   <td>subname</td>
  <td>teacher detail</td>
   </tr>
   <% for(Subjects g: t) {
	 //  Teacher tt=g.getT().get(0);
	   
   %>
   <tr>
   <td><%=g.getSubjectno() %></td>
   <td><%=g.getSubjectname() %></td>
   <td><%=g.getT() %></td>

   </tr>
  <% }%>
   </table>
   </div>
   <br>
   <br>
<% }%>

<div>
<form action ="homepage.html" method="post">
      <input type ="submit" value="go to home">
 </form>
 </div>
</body>
</html>