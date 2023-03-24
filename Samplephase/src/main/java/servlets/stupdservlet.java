package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import SchoolTables.Section;
import SchoolTables.Students;
import config.Configmain;

import dao.SectionDaoImpl;
import dao.StudentDaoImpl;

/**
 * Servlet implementation class stupdservlet
 */
public class stupdservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stupdservlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int a=Integer.parseInt(request.getParameter("rno"));
	     String b=request.getParameter("fname");
	     String c=request.getParameter("name");
	     int d=Integer.parseInt(request.getParameter("cla"));
	     PrintWriter p=response.getWriter();
	     Session ss=StudentDaoImpl.getsession1();
	     Transaction t=ss.beginTransaction();
	     Students ko=ss.get(Students.class, a);
	     if(ko!=null) {
	    	 Query aa=ss.createQuery("update Students s set s.fathername=:z ,s.name=:y,s.s.classno=:x where s.rollno=:w");
		     aa.setParameter("z", b);
		     aa.setParameter("y", c);
		     aa.setParameter("x", d);
		     aa.setParameter("w", a);
		     aa.executeUpdate();
		     t.commit();
		     Students k1=ss.getReference(Students.class, a);
		     request.setAttribute("s1", k1);
			 RequestDispatcher r=request.getRequestDispatcher("stupd.jsp");
			 r.forward(request, response);
	     }
	     else {
	    	 RequestDispatcher r=request.getRequestDispatcher("stupd.jsp");
			 r.include(request, response);
	    	 p.print("no records found");
	     }
	}

}
