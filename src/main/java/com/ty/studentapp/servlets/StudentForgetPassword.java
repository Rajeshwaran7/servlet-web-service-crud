package com.ty.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.studentapp.dto.StudentDatabaseOperation;

@WebServlet("/forgot")
public class StudentForgetPassword extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String email=req.getParameter("email");
		String pwd =req.getParameter("password");
	    StudentDatabaseOperation operation =new StudentDatabaseOperation();
	    boolean stu =operation.updatePassword(email,pwd);
	    if(stu) {
	    	req.getRequestDispatcher("./LogIn.html").include(req, resp);
	    }
	    else {
	    	out.print("<h3>PASSWORD NOT UPDATED !!!!</h3>");
	    	req.getRequestDispatcher("./forgot.html").include(req, resp);

	    }
	}

} 
