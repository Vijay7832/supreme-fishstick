package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import SchoolTables.Students;
import SchoolTables.Section;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import config.Configmain;

import dao.SectionDaoImpl;

/**
 * Servlet implementation class stud2
 */
public class stud2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stud2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int a=Integer.parseInt(request.getParameter("rno"));
	     String b=request.getParameter("fname");
	     String c=request.getParameter("name");
	     int d=Integer.parseInt(request.getParameter("cla"));
	     PrintWriter p=response.getWriter();
	     SessionFactory s=Configmain.getsessionfactory();
	     Session ss=s.openSession();
	     Transaction t=ss.beginTransaction();
	     SectionDaoImpl j=new SectionDaoImpl();
	     Students ko=ss.get(Students.class, a);
	     if(ko==null) {
	    	 Section cc;
		     cc=ss.get(Section.class, d);
		     if(cc==null) {
		    	 cc=new Section(d);
		     }
		     Students pp=new Students(a,c,b);
			 cc.getL().add(pp);
			 pp.setS(cc);
			 ss.save(cc);
		     ss.save(pp);
		     t.commit();
		     Students k=ss.getReference(Students.class, a);
			 request.setAttribute("s1", k);
			 RequestDispatcher r=request.getRequestDispatcher("stadd.jsp");
			 r.forward(request, response);
	    	 
	     }
	     else {
	    	 RequestDispatcher r=request.getRequestDispatcher("stadd.jsp");
			 r.include(request, response);
	    	 p.print("records already found");
	    	 
	     }
	}
}
