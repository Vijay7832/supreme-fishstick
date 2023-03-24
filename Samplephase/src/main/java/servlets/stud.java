package servlets;
import SchoolTables.Students;
import config.Configmain;

import dao.StudentDaoImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class stud
 */
public class stud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		StudentDaoImpl j=new StudentDaoImpl();
	    List<Students> h=j.getAll();
		request.setAttribute("s1", h);
		RequestDispatcher r=request.getRequestDispatcher("stud1.jsp");
		r.forward(request, response);
	}
}
