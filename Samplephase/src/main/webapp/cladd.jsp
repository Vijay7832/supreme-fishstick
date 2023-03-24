<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import= "dao.SectionDaoImpl" %> 
 <%@ page import= "SchoolTables.Section" %> 
 <%@ page import= "SchoolTables.Subjects" %> 
  <%@ page import= "SchoolTables.Students" %> 
 <%@ page import ="java.util.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<h><b> Add class</b> </h>
<form action ="cladd.jsp" method="post">

      class no :<input type="number" name="rno" required><br/>
      <input type ="submit" name ="sub" value="Add">
 </form>
 </div>
 <br>
 
 
 
 
 <div>
 <%
 SectionDaoImpl sd=new SectionDaoImpl();
 if(request.getParameter("sub")!=null){
	 int a=Integer.parseInt(request.getParameter("rno"));
	// SectionDaoImpl sd=new SectionDaoImpl();
	 sd.addsection(a);
 }
 
// SectionDaoImpl j=new SectionDaoImpl();
 List<Section> h=sd.getAll();
 %>
  <table border ="1">
  <h><b>Available classes</b></h>
   
   <% if(h.isEmpty()){%>
   <tr>no records found
   </tr>
  <%  }
   else{
    for(Section s:h){%>
  
   <td><b><%=s.getClassno()%> </b></td>
 
   <%
   }
   }
   
   %>
   </table>
   </div>
   <br>
   <br>
   
    <div>
<h> <b>view class details</b></h> 
 <form action ="cladd.jsp" method="post">

      class no :<input type="number" name="rno1" required><br/>
      <input type ="submit" name ="sub1" value="view">
 </form>
 </div>
   <br>
   <br>
   <br>
   
   
   <div>
     <%
 if(request.getParameter("sub1")!=null){
	 int a=Integer.parseInt(request.getParameter("rno1"));
	 SectionDaoImpl k=new SectionDaoImpl();
	 Section aa=k.getOneClass(a);
	 List<Subjects> t=aa.getSub();
	 List<Students> gt=aa.getL();
 %> 
 <h><b> Details of class <%=a %></b></h>
  <table border ="1">
   <tr>
   <td>subcode</td>
   <td>subname</td>
  <td>teacher detail</td>
   </tr>
   <% for(Subjects g: t) {
	 
	   
   %>
   <tr>
   <td><%=g.getSubjectno() %></td>
   <td><%=g.getSubjectname() %></td>
   <td><%=g.getT() %></td>

   </tr>
  <% }%>
   </table>
   <h> <b>Students List of class <%=a %></b></h>
  <table border ="1">
  <tr>
   <td>student id</td>
   <td>name</td>
  <td>fathername</td>
   </tr>
   <% for(Students g: gt) {   
   %>
  <tr>
   <td><%=g.getRollno() %></td>
   <td><%=g.getName() %></td>
   <td><%=g.getFathername() %></td>

   </tr>
  <% }%>
  </table>
  </div>
  <br>
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