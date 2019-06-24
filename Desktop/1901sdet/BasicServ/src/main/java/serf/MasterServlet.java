package serf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public MasterServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Welcome to the Master Servlet");
		response.getWriter().append("Hello welcome to the Master Servlet");
		
		//Servlet Configuration is configurations for a single servlet
		ServletConfig scon = this.getServletConfig();
		
		String configstring = this.getInitParameter("Quarterback");
		System.out.println(configstring);
		//Servlet Context is where all servlets live and can shared values
		// or configurations
		ServletContext sconxt = this.getServletContext();
		
		String contextstring = sconxt.getInitParameter("Team");
		System.out.println(contextstring);
		
		//This is redirecting the request
		// This a 300 http status code
		if(request.getRequestURI().equals("/BasicServ/subredirect.do")) {
			
			response.sendRedirect("/BasicServ/SubServlet");
		}
		
		if(request.getRequestURI().equals("/BasicServ/subforward.do")) {
			
			// Forward requires the RequestDispatcher
			RequestDispatcher rd = request.getRequestDispatcher("/SubServlet");
			rd.forward(request, response);		
		
	
		}
		// sessions are a way to maintain the use user 'session experience'
		//server side
		if(request.getRequestURI().equals("/BasicServ/sess.do")) {
			
			HttpSession sess = request.getSession();
			sess.setAttribute("name", "Adam");
			System.out.println(sess.getId());
			
			// this will create a small text file client side
			// JavaScript can access these cookies
			Cookie c = new Cookie("Age","19");
			response.addCookie(c);
			
			RequestDispatcher rd = request.getRequestDispatcher("/SubServlet");
			rd.forward(request, response);	
			
			
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);
		
		// Get is used to retrive information from a server
		// you can use get to send information, and it is faster than post,
		// but it is less secure and there is a size limit
		// Post is used to send information to a server
		// A post will send information in the body of the http request
		// more secure slightly slower
		if(request.getRequestURI().equals("/BasicServ/hello.do")) {
			
			String name =  request.getParameter("name");
			response.getWriter().append("Welcome " +name+ " Nice to see you!!").close();
			
		}
		
		
	}

}
