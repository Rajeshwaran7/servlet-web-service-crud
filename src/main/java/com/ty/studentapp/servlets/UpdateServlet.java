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
@WebServlet("/edit")
public class UpdateServlet extends HttpServlet{

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

		int id= Integer.parseInt(req.getParameter("id"));

		StudentDatabaseOperation operation=new StudentDatabaseOperation();
               
		Student s= operation.getStudent(id);
		 if(s != null) {
		
	
		  String html="<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Registration</title>\r\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/nav.css\">\r\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/Style.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ " 	\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "<div class=\"bd\">\r\n"
				+ "<div class=\"Regi\">\r\n"
				+ "<h3>UPDATE HERE !!!</h3>\r\n"
				+ "<hr>\r\n"
				+ "\r\n"
				+ "<form class=\"form\" action=\"editForms\">\r\n"
				+ "<div class=\"form2\">\r\n"
				+ "<label>StudentId   </label>\r\n"
				+ "<input type=\"number\" name=\"sid\" value ='"+s.getsId()+"' readonly />\r\n"
				+ "</div>\r\n"
				+ "<div class=\"form2\">\r\n"
				+ "<label>Name      </label>\r\n"
				+ "<input type=\"text\" name=\"name\"  value ='"+s.getName()+"'/>\r\n"
				+ "</div>\r\n"
				+ "<div class=\"form2\">\r\n"
				+ "<label> Marks     </label>\r\n"
				+ "<input type=\"text\" name=\"marks\"  value ='"+s.getMarks()+"'/>\r\n"
				+ "</div>\r\n"
				
				+ "<div class=\"form2\">\r\n"
				+ "<label>Email     </label>\r\n"
				+ "<input type=\"email\" name=\"email\"  value ='"+s.getEmailId()+"'/>\r\n"
				+ "</div>\r\n"
				+ "<div class=\"btn\">\r\n"
				+ "<button type=\"submit\">Submit</button>\r\n"
				+ "</div>\r\n"
				+ "</form>\r\n"
				+ "<div class=\"login\">\r\n"
				+ "<a href=\"./display-All\">Back</a>\r\n"
				+ "</div>\r\n"
				+ "\r\n"
				+ "</div>\r\n"
				+ "</div>\r\n"
				+ "\r\n"
				+ "<footer>\r\n"
				+ "<div class=\"footer\">\r\n"
				+ "\r\n"
				+ "  <ul>\r\n"
				+ "         <li><a href=\"#\">About Us</a></li>\r\n"
				+ "          <li><a href=\"#\">Contact Us</a></li>\r\n"
				+ "          <li><a href=\"#\">Mail</a></li>\r\n"
				+ "          <li><a href=\"#\">Help</a></li>\r\n"
				+ "          <li><a href=\"#\">Location</a></li>\r\n"
				+ "          \r\n"
				+ "                \r\n"
				+ "  </ul>\r\n"
				+ "</div>\r\n"
				+ "</footer>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>";
		             
		      out.print(html);
	        }
			
		 
     }else {
			resp.sendRedirect("./logout");
		}
	}
}
