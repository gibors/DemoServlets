package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileServletUpload
 */

//**  Dudas **
// ¿Como obtener tamaño en disco del server  desde el servlet ?

@WebServlet(name="FileServletUpload", urlPatterns={"/upload"})
@MultipartConfig
public class FileServletUpload extends HttpServlet
  {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(FileServletUpload.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileServletUpload()
      {
        super();
        // TODO Auto-generated constructor stub
      }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	  {
	 	// TODO Auto-generated method stub
	  }

	@SuppressWarnings("resource")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	  { // si se va hacer uso de un multipart/form-data, es necesario hacer uso del metodo POST y no GET
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("Context path " + request.getContextPath());
		System.out.println("Servlet Path " + request.getServletPath());		

		final Part filePart = request.getPart("file");
		String partHeader = filePart.getHeader("content-disposition");
		String fileName = getFileName(filePart);
	    	    
		System.out.println(" file Name>> " + fileName);
		
		OutputStream out = null;
		InputStream fileContent = null;
		PrintWriter pw = response.getWriter();
		
		try
		  { // Try - Guarda archivo en servidor (TOP)
			out = new FileOutputStream(new File("C:\\archivos" + File.separator + fileName));
			
			fileContent = filePart.getInputStream();
			
			
			int read = 0; // longitud de bytes (caracteres)
			byte bytes[] = new byte[1024];
			long sizeFile = filePart.getSize(); // tamaño del archivo en bytes
			
			while( (read = fileContent.read(bytes)) != -1 )
			  { // mientras haya contenido (TOP) 
				out.write(bytes,0,read);	
			  } // mientras haya contenido (BOTTOM)
			
			pw.println("Nuevo archivo agregado " + fileName + " agregado, tamaño>> " + sizeFile/1024 + " Kbytes");
		  } // Try - Guarda archivo en servidor (BOTTOM)
		catch(FileNotFoundException  exFNF)
		  { // Catch - Muestra error (TOP)
			//exIO.printStackTrace();
			//throw new IOException("Error de entrada / salida - Archivo no encontrado   " + exFNF.toString());
			pw.println("You either did not specify a file to upload or are "
	                + "trying to upload a file to a protected or nonexistent "
	                + "location.");
	        pw.println("<br/> ERROR: " + exFNF.getMessage());
	        
	        LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
	                new Object[]{exFNF.toString()});
		  } // Catch - Muestra error (BOTTOM)
		finally
		  { //Exista o no error cerramos recursos (TOP)
			if(out != null)
				out.close();
			if(fileContent != null)
				fileContent.close();
			if(pw != null)
				pw.close();
		  }  //Exista o no error cerramos recursos (BOTTOM)
	  }
	
	private String getFileName(final Part part) 
	  { // Obtiene el nombre del archivo (TOP)
	    final String partHeader = part.getHeader("content-disposition");
	    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
	    for (String content : part.getHeader("content-disposition").split(";")) 
	      {
	        if (content.trim().startsWith("filename"))
	          { // Si el header comienza con filename (TOP)
	        	return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	          } // Si el header comienza con filename (BOTTOM)
	      }
	    return null;
	  } // Obtiene el nombre del archivo (BOTTOM)

}
