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

import SchoolTables.Section;
import SchoolTables.Subjects;
import SchoolTables.Teacher;
import config.Configmain;
import dao.SectionDaoImpl;

/**
 * Servlet implementation class ClassTeacheradd
 */
public class ClassTeacheradd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassTeacheradd() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int a=Integer.parseInt(request.getParameter("cno"));
		 int b=Integer.parseInt(request.getParameter("empid"));
		 int c=Integer.parseInt(request.getParameter("sno"));
	     PrintWriter p=response.getWriter();
	     SessionFactory s=Configmain.getsessionfactory();
	     Session ss=s.openSession();
	     Transaction t=ss.beginTransaction();
	     SectionDaoImpl j=new SectionDaoImpl();
	     Section ko=ss.get(Section.class, a);
	     Teacher sw= ss.get(Teacher.class, b);
	     Subjects sx=ss.get(Subjects.class, c);
	     if(ko!=null && sw!=null && sx!=null) {
	    	//link btwn teacher and class
	    	 ko.getTec().add(sw);
	    	 ss.save(sw);
	    	 ss.save(ko);
	    	 //link between class and subjects
	    	/* ko.getSub().add(sx);
	    	 ss.save(sx);
	    	 ss.save(ko); */
	    	 //link between teacher and subjects:
	    	 sx.getT().add(sw);
	    	 ss.save(sw);
		     ss.save(sx);
		     t.commit();
		     p.print("finished");
		     Section k=ss.getReference(Section.class, a);
			 request.setAttribute("s1", k);
			 RequestDispatcher r=request.getRequestDispatcher("clteach.jsp");
			 r.forward(request, response);
	     }
	     else {
	    	 RequestDispatcher r=request.getRequestDispatcher("clteach.jsp");
			 r.include(request, response);
	    	 p.print("class or subjects records not found");
	    	 
	     }
		
		
		
		
	}

}
