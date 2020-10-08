package logoutServlet;

//servlet for logout

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/UserLogoutServlet")
public class UserLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UserLogoutServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("useDetails");//remove the attribute that created when login
             
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");//redirecting to the login page after logout
            dispatcher.forward(request, response);
	}

}
}