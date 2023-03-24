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

import SchoolTables.Subjects;
import SchoolTables.Teacher;
import config.Configmain;
import dao.SectionDaoImpl;

/**
 * Servlet implementation class Teachersetup
 */
public class Teachersetup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teachersetup() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int a=Integer.parseInt(request.getParameter("emno"));
	     int d=Integer.parseInt(request.getParameter("sub"));
	     PrintWriter p=response.getWriter();
	     SessionFactory s=Configmain.getsessionfactory();
	     Session ss=s.openSession();
	     Transaction t=ss.beginTransaction();
	     SectionDaoImpl j=new SectionDaoImpl();
	     Teacher ko=ss.get(Teacher.class, a);
	     Subjects sw= ss.get(Subjects.class, d);
	     if(ko!=null && sw!=null) {
	    	 sw.getT().add(ko);
	    	 ss.save(ko);
		     ss.save(sw);
		     t.commit();
		     p.print("finished");
		     Teacher k=ss.getReference(Teacher.class, a);
		   
			 request.setAttribute("s1", k);
			 RequestDispatcher r=request.getRequestDispatcher("tesetup.jsp");
			 r.forward(request, response);
	     }
	     else {
	    	 RequestDispatcher r=request.getRequestDispatcher("tesetup.jsp");
			 r.include(request, response);
	    	 p.print("Teacher or subjects records not found");
	    	 
	     }
	}

}
