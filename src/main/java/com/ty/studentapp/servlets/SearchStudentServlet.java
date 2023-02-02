package com.ty.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.studentapp.dao.Student;
import com.ty.studentapp.dto.StudentDatabaseOperation;

@WebServlet("/search")
public class SearchStudentServlet extends HttpServlet{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
	 if(req.getSession(false )!= null) {
	 
	  resp.setContentType("text/html");
	  PrintWriter out=resp.getWriter();
	  int sid = Integer.parseInt(req.getParameter("stuid"));
	  
	  StudentDatabaseOperation stuOb =new StudentDatabaseOperation();
	  
	    Student st=stuOb.byId(sid);
	    String html=null;
	 
	 
	  if (st !=null) {
		 
		 	html="<!doctype HTML>"
				+"<html>"
				+"<head>"
				+"<title>student table</title>"
				+"<link rel='stylesheet' type='text/css' href='./css/nav.css'>"
				+"<link rel='stylesheet' type='text/css' href='./css/table.css'>"
				+"</head>"
				+"<body>"			
				+"<header>"
				+"<h1> Student App </h1>"
				+"<nav>"
				+"<ol>"
				+"<li><a href='./Home.html'> Home</a></li>"
				+"<li><a href='./marks.html'> Based of on Marks</a></li>"
                +"<li><a href='./display-All'> Display All</a></li>"
				+"<li><a href='./logout'> Log Out</a></li>"
				+"<li><a href='./search.html'> Search By your Id</a></li>"
				+"</ol>"
				+"</nav>"
				+"<hr>"
				+"</header>"
				+"<div class='tdiv'>"
				+"<h1>Student Details</h1>"
				+"<table class='table' border:'1' >"
				+"<tr>"
				+"<th> Id</th>"
				+"<th> Name</th>"
				+"<th> Marks</th>"
				+"<th> Email</th>"
				+"</tr>"
				+"<tr>"
				+"<td> "+st.getsId()+"</td>"
				+"<td> "+st.getName()+"</td>"
			    +"<td> "+st.getMarks()+"</td>"
			    +"<td> "+st.getEmailId()+"</td>"
				+ "</tr>"
				+"</table>"
				+"</div>"
				+"<footer>"
				+"<div class='footer'>"

				  +"<ul>"
				         +"<li><a href='#'>About Us</a></li>"
				          +"<li><a href='#'>Contact Us</a></li>"
				          +"<li><a href='#'>Mail</a></li>"
				          +"<li><a href='#'>Help</a></li>"
				          +"<li><a href='#'>Location</a></li>"
				                
				 + "</ul>"
				+"</div>"
				+"</footer>"

				+"</body>"
		        +"</html>";
			 out.print(html);

		 }
		 
	 else {
        	out.print("<h3>Id Not Present With "+sid);
        	req.getRequestDispatcher("./dashboard").include(req, resp);
        }
 }
	 else {
			resp.sendRedirect("./logout");
		}
  
}

}
