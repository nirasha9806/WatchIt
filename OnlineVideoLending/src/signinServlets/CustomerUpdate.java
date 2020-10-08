package signinServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signinDBUtils.SigninDButill;
import signinModels.User;


@WebServlet("/CustomerUpdate")
public class CustomerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get parameters
		int id= Integer.parseInt(request.getParameter("id"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		
		boolean isTrue;
		isTrue= SigninDButill.updatecustomer(id,fname,lname,email,password);//method calling
		
		if(isTrue == true) {
			
			List <User> useDetails = SigninDButill.display(username); //assign the list object to validate
			 request.setAttribute("useDetails", useDetails); 
			
			RequestDispatcher dis =request.getRequestDispatcher("UserProfile.jsp");//if success displaying useprofile
			dis.forward(request, response);
		}else {
			RequestDispatcher dis= request.getRequestDispatcher("error.jsp");//error page
			dis.forward(request, response);
		}
		
		
		
	}
	
	

}
