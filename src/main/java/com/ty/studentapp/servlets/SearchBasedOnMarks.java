package com.ty.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.studentapp.dao.Student;
import com.ty.studentapp.dto.StudentDatabaseOperation;
@WebServlet("/mark")
public class SearchBasedOnMarks extends HttpServlet{

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

		double m1= Double.parseDouble(req.getParameter("m1"));
		double m2= Double.parseDouble(req.getParameter("m2"));
		
		StudentDatabaseOperation operation =new StudentDatabaseOperation();
		List<Student> st= operation.searchOnMarks(m1,m2);
		
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
  				+"</tr>";
        
       for (Student student : st) {
			
        String html2="<tr>"
     				+"<td> "+student.getsId()+"</td>"
     				+"<td> "+student.getName()+"</td>"
     			    +"<td> "+student.getMarks()+"</td>"
     			    +"<td> "+student.getEmailId()+"</td>"

     			    

     				+ "</tr>";
              html+=html2;
		}

        
       out.print(html);
      
		        
	

    }	else {
	
    	resp.sendRedirect("./logout");
        
       }
	}
	
	}

