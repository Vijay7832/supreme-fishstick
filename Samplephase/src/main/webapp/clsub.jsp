<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import= "dao.SectionDaoImpl" %> 
<%@ page import= "dao.SubjectDaoImpl" %> 
 <%@ page import= "SchoolTables.Section" %> 
 <%@ page import= "SchoolTables.Subjects" %> 
 <%@ page import ="java.util.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<h><b>view class details</b></h>
<form action ="clsub.jsp" method="post">
      classno :<input type="number" name="cn" required><br/>
      <input type ="submit"  name="sub" value="view">
 </form>
 </div>
 <br>

<div>
<h><b>set class subjects</b></h>
<form action ="clsubset" method="post">

      classno :<input type="number" name="cno" required><br/>
      Subcode : <input type="number" name="sco" required><br/>
      Subname : <input type="name" name="sname" required><br/>
      <input type ="submit" value="Add">
 </form>
 </div>
 <br>
 <br>
 
 <div>
   <%
  // Section hh=(Section)request.getAttribute("s1");
 if(request.getParameter("sub")!=null){
	 int a=Integer.parseInt(request.getParameter("cn"));
	 SectionDaoImpl k=new SectionDaoImpl();
	 Section aa=k.getOneClass(a);
	 if(aa==null){%>
		 <h> records not found</h>
		 
	<%  }
	 else{
	 List<Subjects> t=aa.getSub();
 %> 
 <h> <b>subjects of class <%=a %></b></h>
  <table border ="1">
   <tr>
   <td>subno</td>
   <td>subname</td>
   </tr>
   <% for(Subjects g: t) {%>
   <tr>
   <td><%=g.getSubjectno() %></td>
   <td><%=g.getSubjectname() %></td>
   </tr>
  <% }}}%>
   </table>
   
   
   <%
   try{
  Section hh=(Section)request.getAttribute("s1");
   if(hh!=null){%>

  
   <h><b>subjects details of class <%= hh.getClassno()%> </b></h>
   <table border ="1">
   <tr>
   <td>subcode</td>
   <td>subname</td>
   </tr>
   <% 
   List<Subjects> jj=hh.getSub();
   for(Subjects g: jj){%>
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
   </div>
   <br>
   <br>
   <br>
   
<div>   
   <form action ="homepage.html" method="post">
      <input type ="submit" value="go to home">
 </form>
 </div>
 
</body>
</html>