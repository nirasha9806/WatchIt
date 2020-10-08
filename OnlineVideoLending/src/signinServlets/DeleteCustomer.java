package signinServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signinDBUtils.SigninDButill;


@WebServlet("/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		boolean isTrue;
	
		String username = request.getParameter("username");
		
		//calling method
		isTrue = SigninDButill.DeleteCustomer(username);
		if(isTrue) {
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");//redirecting to the login page
			dis.forward(request, response);
		}else {
			RequestDispatcher dis =request.getRequestDispatcher("error.jsp");//if unsuccess displaying error page
			dis.forward(request, response);
		}
		

}
}