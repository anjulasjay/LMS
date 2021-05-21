package com.lms.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lms.model.Cancellation;
import com.lms.util.UserDBUtil;

/**
 * Servlet implementation class getCancellationDetails
 */
@WebServlet("/getCancellationDetails")
public class getCancellationDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Cancellation> cancellationDetails = UserDBUtil.getCancellationDetails();
		
		if (cancellationDetails == null) {
			response.sendRedirect("Unsuccess.jsp");
		}
		else {
			response.sendRedirect("Success.jsp");
		}
		request.setAttribute("cancellationDetails", cancellationDetails);
		RequestDispatcher dis = request.getRequestDispatcher("regSuccess.jsp");
		dis.forward(request,response);
	}

}
