package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(name="DispatcherServlet", urlPatterns={"/dispatcher/*"})
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	  {
		// TODO Auto-generated method stub
	  }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	  {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String param1 =  request.getParameter("param1");
		System.out.println("servlet path >> " + request.getServletPath());
		System.out.println("info>> " + request.getPathInfo());
		
		if (request.getServletPath().concat(request.getPathInfo()).equals("/dispatcher/page1"))
		  { // Si el uri es /dispatcher/page1 (TOP)
			System.out.println("entro a comparacion -- ");
			request.getRequestDispatcher("/welcomePage.jsp").forward(request, response);
		  }  // Si el uri es /dispatcher/page1 (BOTTOM)
		else
			System.out.println("no entro..");
	  }
}
