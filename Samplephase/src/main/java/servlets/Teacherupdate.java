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
import org.hibernate.query.Query;

import SchoolTables.Teacher;
import config.Configmain;

/**
 * Servlet implementation class Teacherupdate
 */
public class Teacherupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacherupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a=Integer.parseInt(request.getParameter("rno"));
	     String b=request.getParameter("name");
	     int d=Integer.parseInt(request.getParameter("exp"));
	     PrintWriter p=response.getWriter();
	     SessionFactory s=Configmain.getsessionfactory();
	     Session ss=s.openSession();
	     Transaction t=ss.beginTransaction();
	     Teacher ko=ss.get(Teacher.class, a);
	     if(ko!=null) {
	    	 Query aa=ss.createQuery("update Teacher s set s.name=:z ,s.experience=:y");
		     aa.setParameter("z", b);
		     aa.setParameter("y", d);
		     aa.executeUpdate();
		     t.commit();
		     Teacher k1=ss.load(Teacher.class, a);
		     request.setAttribute("s1", k1);
			 RequestDispatcher r=request.getRequestDispatcher("teupdate.jsp");
			 r.forward(request, response);
	     }
	     else {
	    	 RequestDispatcher r=request.getRequestDispatcher("teupdate.jsp");
			 r.include(request, response);
	    	 p.print("no records found");
	     }
	}

}
