import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class babyServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
	//Etape1.Sp�cifierle type MIME ducontenu de lar�ponse
	response.setContentType("text/html");
	//Etape2.  R�cup�re le PrintWriterpourenvoyer des donn�esau client
	PrintWriter out = response.getWriter();
	// Step 3.Envoyer l�informationau client
	out.println("<html>");
	out.println("<head><title>Bonjour</title></head>");
	out.println("<body>");
	out.println("<h1>Bonjour� tous</h1>");
	out.println("Il est: " + new java.util.Date());
	out.println("</body></html>");
}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
}
}