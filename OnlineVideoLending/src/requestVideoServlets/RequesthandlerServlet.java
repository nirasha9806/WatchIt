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
import requestVideoModels.requestvideo;




@WebServlet("/RequesthandlerServlet")
public class RequesthandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String viname = request.getParameter("name");
		String type = request.getParameter("type");
		String uName = request.getParameter("uname");
			List<requestvideo> requestdetails = RequestDBUtil.validate(viname);//calling validating method
			
			if(requestdetails == null) {
				
				
				
				boolean True;//variable
				
				True= RequestDBUtil.insertrequest(viname, type, uName);//calling insert method
				
				if(True == true) {
				
					 RequestDispatcher rd2 = request.getRequestDispatcher("success.jsp");//go to success page 
					 rd2.forward(request, response);
					 
				}
				
			}
             	else {
			
		                  try {
				
		                     request.setAttribute("requestdetails",requestdetails);
				
		                       }
		                catch(Exception e) {
			             e.printStackTrace();
		                           }

		                   RequestDispatcher rd = request.getRequestDispatcher("result.jsp");//go to result page
		                  rd.forward(request, response);
		             }
	   	
		          }
			
}
	
	
	
	

	
	
	

     
