package com.ty.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.studentapp.dto.StudentDatabaseOperation;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession(false) != null) {
		resp.setContentType("text/html");
		PrintWriter out =resp.getWriter();
		int sid=Integer.parseInt(req.getParameter("id"));
		StudentDatabaseOperation operation =new StudentDatabaseOperation();
		 operation.deleteById(sid);


		 req.getRequestDispatcher("/display-All").forward(req, resp);
			
			
			}
		else {
			resp.sendRedirect("./logout");
		}
     
           
			
	

}
}
