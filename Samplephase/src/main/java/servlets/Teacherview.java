package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SchoolTables.Teacher;
import dao.TeacherDaoImpl;

/**
 * Servlet implementation class Teacherview
 */
public class Teacherview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacherview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		TeacherDaoImpl j=new TeacherDaoImpl();
	    List<Teacher> h=j.getAll();
		request.setAttribute("s1", h);
		RequestDispatcher r=request.getRequestDispatcher("teaview.jsp");
		r.forward(request, response);
	}
}
