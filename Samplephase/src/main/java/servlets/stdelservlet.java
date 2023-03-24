package servlets;
import java.util.*;
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
import SchoolTables.Students;
import SchoolTables.Teacher;
import SchoolTables.Section;
import config.Configmain;

import dao.StudentDaoImpl;

/**
 * Servlet implementation class stdelservlet
 */
public class stdelservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stdelservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	     
	     PrintWriter p=response.getWriter();
		 int a=Integer.parseInt(request.getParameter("rno"));
	     
	     Session ss=StudentDaoImpl.getsession1();
	     Transaction t=ss.beginTransaction();
	     Students ko=ss.get(Students.class, a);
	     if(ko!=null) {
	    	 Query aa1=ss.createQuery("delete from Students s  where s.rollno=:nn");
			 aa1.setParameter("nn", a);
			 aa1.executeUpdate();
			 t.commit();
			 request.setAttribute("s1", ko);
			 RequestDispatcher r=request.getRequestDispatcher("stdel.jsp");
			 r.forward(request, response);
	     }
	     else {
	    	 RequestDispatcher r=request.getRequestDispatcher("stdel.jsp");
			 r.include(request, response);
	    	 p.print("records not found");
	    	 
	     }
	     
	}


}
