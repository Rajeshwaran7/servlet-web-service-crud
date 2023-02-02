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

@WebServlet("/logout")
public class StudentLogout extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession session = req.getSession(false);	
		if(session != null) {

				session.invalidate();
             resp.sendRedirect("./LogIn.html");
	}
		else {
	             resp.sendRedirect("./LogIn.html");

			}
	 	

}
}