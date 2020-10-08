package requestVideoServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import requestVideoDBUtils.RequestDBUtil;
import requestVideoModels.requestlist;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String Id = request.getParameter("id");
		String Username =request.getParameter("uname");
		
		
		boolean T;
		T= RequestDBUtil.deleteRequestCustomer(Id);
		
		if(T==true) {
			
			List<requestlist> reqlidetails = RequestDBUtil.display(Username);//calling method of database
			request.setAttribute("reqlidetails", reqlidetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("requestresult.jsp");//redirect to requestresult.jsp page
			dis.forward(request, response);
		}
		else {
			
			String usname = request.getParameter("uname");
			
			List<requestlist> reqlidetails = RequestDBUtil.display(usname);
			request.setAttribute("reqlidetails", reqlidetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("requestresult.jsp");//redirect to requestresult.jsp page
			dis.forward(request, response);
		}
		
	}

}
