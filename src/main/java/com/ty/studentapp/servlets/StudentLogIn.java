package com.ty.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.studentapp.dao.Student;
import com.ty.studentapp.dto.StudentDatabaseOperation;

@WebServlet("/login")
public class StudentLogIn extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 resp.setContentType("text/html");
	 PrintWriter out =resp.getWriter();
	 String email=req.getParameter("email");
	 String pwd= req.getParameter("password");
	 StudentDatabaseOperation operation= new StudentDatabaseOperation();
	 Student  ss = operation.logIn(email,pwd);
	 
	 if(ss != null) {
			HttpSession session = req.getSession(true);
			if(session != null) {
					 req.getRequestDispatcher("./dashboard").forward(req, resp);

			}else {
				out.print("<h3> "
						+ "NOT RESPONSE!!!"
						+ "</h3>");
	         req.getRequestDispatcher("./logout").include(req, resp);
			}
	 }
	 else {
		 out.print(" <h3> "
		 		+ "In Valid!!!   "
		 		+ "</h3>");
	         req.getRequestDispatcher("./LogIn.html").include(req, resp);

	}

	}
}