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
import SchoolTables.Section;
import config.Configmain;
import dao.SectionDaoImpl;

/**
 * Servlet implementation class Classsubjectadd
 */
public class Classsubjectadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Classsubjectadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int a=Integer.parseInt(request.getParameter("cno"));
		 int b=Integer.parseInt(request.getParameter("sco"));
		 String c=request.getParameter("sname");
	     PrintWriter p=response.getWriter();
	     SessionFactory s=Configmain.getsessionfactory();
	     Session ss=s.openSession();
	     Transaction t=ss.beginTransaction();
	     SectionDaoImpl j=new SectionDaoImpl();
	     Section ko=ss.get(Section.class, a);
	     if(ko==null) {
	    	 ko=new Section(a);
	     }
	     Subjects kk=new Subjects(b,c);
    	 ko.getSub().add(kk);
    	 ss.save(kk);
    	 ss.save(ko);
	     t.commit();
	     request.setAttribute("s1", ko);
		 RequestDispatcher r=request.getRequestDispatcher("clsub.jsp");
		 r.forward(request, response);
	 
	}

}
