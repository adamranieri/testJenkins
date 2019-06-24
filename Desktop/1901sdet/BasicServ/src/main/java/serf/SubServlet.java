package serf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SubServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Welcome to the SubServlet");
		HttpSession sess = request.getSession();
		System.out.println(sess.getAttribute("name"));
		response.getWriter().append("Welcome to the SubServlet").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
