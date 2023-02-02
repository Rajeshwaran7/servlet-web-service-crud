package com.ty.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.studentapp.dao.Student;
import com.ty.studentapp.dto.StudentDatabaseOperation;

@WebServlet("/display-All")
public class DisplayAll extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		if(req.getSession(false) != null) {
		
		resp.setContentType("text/html");
		PrintWriter out =resp.getWriter();
		req.getRequestDispatcher("./Nav.html").include(req, resp);
		StudentDatabaseOperation operation=new StudentDatabaseOperation();
		ArrayList<Student> list=operation.getAllStudent();
		


		String  html=
  				"<link rel='stylesheet' type='text/css' href='./css/table2.css'>"
  				+"<div class='tdiv'>"
  				+"<h1>Student Details</h1>"
  				+"<table class='table' border:'1' >"
  				+"<tr>"
  				+"<th> Id</th>"
  				+"<th> Name</th>"
  				+"<th> Marks</th>"
  				+"<th> Email</th>"
  				+"<th colspan='2'> Action</th>"
  				+"</tr>";
				         
		for (Student student : list) {
					
		  String html2="<tr>"
		      				+"<td> "+student.getsId()+"</td>"
		      				+"<td> "+student.getName()+"</td>"
		      			    +"<td> "+student.getMarks()+"</td>"
		      			    +"<td> "+student.getEmailId()+"</td>"

				      	    +"<td> "+"<a href='./edit?id="+student.getsId()+"'>EDIT</a>"+"</td>"
				      	    +"<td> "+"<a href='./delete?id="+student.getsId()+"'>DELETE</a>"+"</td>"


		      				+ "</tr>";
                       html+=html2;
				}
		
		          out.print(html);
	    	}
		else {

			resp.sendRedirect("./logout");
	   }
		
	}
	
}
