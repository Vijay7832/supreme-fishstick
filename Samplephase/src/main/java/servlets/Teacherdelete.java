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


import SchoolTables.Teacher;
import config.Configmain;
import dao.StudentDaoImpl;
import dao.TeacherDaoImpl;

/**
 * Servlet implementation class Teacherdelete
 */
public class Teacherdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacherdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter p=response.getWriter();
		 int a=Integer.parseInt(request.getParameter("empno"));
	     Session ss=TeacherDaoImpl.getsession1();
	     Transaction t=ss.beginTransaction();
	     Teacher ko=ss.get(Teacher.class, a);
	     if(ko!=null) {
	    	 Query aa1=ss.createQuery("delete from Teacher s  where s.empid=:nn");
			 aa1.setParameter("nn", a);
			 aa1.executeUpdate();
			 t.commit();
			 request.setAttribute("s1", ko);
			 RequestDispatcher r=request.getRequestDispatcher("tedelete.jsp");
			 r.forward(request, response);
	     }
	     else {
	    	 RequestDispatcher r=request.getRequestDispatcher("tedelete.jsp");
			 r.include(request, response);
	    	 p.print("records not found");
	    	 
	     }
	}

}
