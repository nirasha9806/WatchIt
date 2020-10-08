package paymentServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paymentDBUtils.PaymentDButill;


@WebServlet("/payment")
public class payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  //get parameters
	  int id = Integer.parseInt(request.getParameter("id"));
	  String cardname= request.getParameter("cardname");
	  String cardnumber= request.getParameter("cardnumber");
	  String month= request.getParameter("expmonth");
	  String year= request.getParameter("expyear");
	  String cvv= request.getParameter("cvv");
	  String total= request.getParameter("total");
	  
	  boolean isTrue;
	  isTrue =PaymentDButill.paymentdetails(id, cardname, cardnumber, month, year, cvv, total);//method calling
	   if(isTrue == true) {
		  RequestDispatcher dis = request.getRequestDispatcher("paymentSuccess.jsp");
		  dis.forward(request, response);
		   
	   }else{
		   RequestDispatcher dis2 = request.getRequestDispatcher("error.jsp");
		   dis2.forward(request, response);
	   }
	  
	  
	  
	}

}
