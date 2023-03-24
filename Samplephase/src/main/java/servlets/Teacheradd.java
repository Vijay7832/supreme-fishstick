package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import SchoolTables.Teacher;
import config.Configmain;
import dao.TeacherDaoImpl;

/**
 * Servlet implementation class Teacheradd
 */
public class Teacheradd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacheradd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int a=Integer.parseInt(request.getParameter("rno"));
	     String b=request.getParameter("name");
	     int d=Integer.parseInt(request.getParameter("exp"));
	     PrintWriter p=response.getWriter();
	     
	     Session ss=TeacherDaoImpl.getsession1();
	     Transaction t=ss.beginTransaction();
	     
	     Teacher ko=ss.get(Teacher.class, a);
	     if(ko==null) {
		     Teacher pp=new Teacher(a,b,d);
		     ss.save(pp);
		     t.commit();
		     Teacher k=ss.getReference(Teacher.class, a);
			 request.setAttribute("s1", k);
			 RequestDispatcher r=request.getRequestDispatcher("teadd.jsp");
			 r.forward(request, response);
	    	 
	     }
	     else {
	    	 RequestDispatcher r=request.getRequestDispatcher("teadd.jsp");
			 r.include(request, response);
	    	 p.print("records already found");
	    	 
	     }
	}

}
