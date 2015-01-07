package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestHeadersServlet
 */
@WebServlet(urlPatterns={"/headers"}, name="RequestHeadersServlet")
public class RequestHeadersServlet extends HttpServlet 
  {
	private static final long serialVersionUID = 1L;
       
    public RequestHeadersServlet() 
      {
        super();
        // TODO Auto-generated constructor stub
      }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	  {
		// TODO Auto-generated method stub
		
		// el getservletcontext trae el objeto servlet
		System.out.println("servlet context path: " + request.getContextPath());		
		System.out.println("servlet path: " + request.getServletPath());
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		Enumeration<String> headerNames = request.getHeaderNames();
		
		//Iterator ite = headers.
		while(headerNames.hasMoreElements())
		  { // Mientras haya mas nombres de encabezados (TOP)
			String headerName = headerNames.nextElement();
			pw.write("> " + headerName);
			pw.write("<BR>");
			Enumeration<String> headers = request.getHeaders(headerName);
			while(headers.hasMoreElements())
			  { //
				String headerValue = headers.nextElement();
				pw.write(">> " + headerValue);
			  } //
			pw.write("<BR>");
		  } // Mientras haya mas nombres de encabezados (BOTTOM)
		pw.write("<BR>");
		pw.write("USER-AGENTE: ");
		pw.write(">>" + request.getHeader("User-Agent"));
		pw.write("<BR>");
		pw.write("Remote addr: ");
		pw.write(">>" + request.getRemoteAddr());
		pw.write("<BR>");
		pw.write("host : ");
		pw.write(">>" + request.getRemoteHost());
		pw.write("<BR>");
		pw.write("protocol : ");
		pw.write(">>" + request.getProtocol());
		
		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		
		System.out.println("param1>> " + param1);
		System.out.println("param2>> " + param2);
				
		
		if (request.getServletPath().equals("/headers"))
		  { // Si el path es /headers (TOP)
			PrintWriter writer =  response.getWriter();
			writer.write("<H2>HELLO WORLD</H2>");
		  } // Si el path es /headers (TOP)
	  }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	  {
		// TODO Auto-generated method stub
	  }
  }
