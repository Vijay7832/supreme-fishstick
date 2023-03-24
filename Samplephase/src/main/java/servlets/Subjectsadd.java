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

import SchoolTables.Subjects;
import config.Configmain;
import dao.SectionDaoImpl;

/**
 * Servlet implementation class Subjectsadd
 */
public class Subjectsadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Subjectsadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int c=Integer.parseInt(request.getParameter("sno"));
		 int a=Integer.parseInt(request.getParameter("sno"));
	     String b=request.getParameter("name");
	     PrintWriter p=response.getWriter();
	     SessionFactory s=Configmain.getsessionfactory();
	     Session ss=s.openSession();
	     Transaction t=ss.beginTransaction();
	     SectionDaoImpl j=new SectionDaoImpl();
	     Subjects ko=ss.get(Subjects.class, a);
	     
	     if(ko==null) {
	    	 Subjects pp=new Subjects(a,b);
		     ss.save(pp);
		     t.commit();
		     Subjects k=ss.getReference(Subjects.class, a);
			 request.setAttribute("s1", k);
			 RequestDispatcher r=request.getRequestDispatcher("suadd.jsp");
			 r.forward(request, response);
	    	 
	     }
	     else {
	    	 RequestDispatcher r=request.getRequestDispatcher("suadd.jsp");
			 r.include(request, response);
	    	 p.print("records already found");
	     }
	}

}
