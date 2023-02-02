package com.ty.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/marks-search")
public class MarksSearchServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession(false) != null) {
			resp.setContentType("text/html");
			PrintWriter out =resp.getWriter();
			out.print("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>marks search</title>\r\n"
					+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/nav.css\">\r\n"
					+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/Login.css\">\r\n"
					+ "\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "<header>\r\n"
					+ "<h1> Student App </h1>\r\n"
					+ "<nav>\r\n"
					+ "<ol>\r\n"
					+ "<li><a href=\"./dashboard\"> Search By your Id</a></li>\r\n"
					+ "<li><a href=\"./marks-search\"> Based of on Marks</a></li>\r\n"
					+ "<li><a href=\"./display-All\"> Display All</a></li>\r\n"
					+ "<li><a href=\"./logout\"> Log Out</a></li>\r\n"
					+ "</ol>\r\n"
					+ "</nav>\r\n"
					+ "<hr>\r\n"
					+ "\r\n"
					+ "</header>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "<div class=\"bd\">\r\n"
					+ "<div class=\"Regi\">\r\n"
					+ "<h3>Search based on</h3>\r\n"
					+ "<hr>\r\n"
					+ "<form class=\"form\" action=\"mark\" >\r\n"
					+ "<div class=\"form2\">\r\n"
					+ "<label>  From  </label>\r\n"
					+ "<input type=\"text\" name=\"m1\" required/>\r\n"
					+ "</div>\r\n"
					+ "<div class=\"form2\">\r\n"
					+ "<label>  To  </label>\r\n"
					+ " <input type=\"text\" name=\"m2\" required/>\r\n"
					+ "</div>\r\n"
					+ "<div class=\"btn\">\r\n"
					+ "<button type=\"submit\">Fetch</button>\r\n"
					+ "</div>\r\n"
					+ "</form>\r\n"
					+ "<div class=\"login\">\r\n"
					+ "<a href=\"./logout\">BACK TO LOG IN PAGE</a>\r\n"
					+ "</div>\r\n"
					+ "\r\n"
					+ "</div>\r\n"
					+ "</div>\r\n"
					+ "\r\n"
					+ "<footer>\r\n"
					+ "<div class=\"footer\">\r\n"
					+ "\r\n"
					+ "  <ul>\r\n"
					+ "         <li><a href=\"./Aboutus.html\">About Us</a></li>\r\n"
					+ "          <li><a href=\"#\">Contact Us</a></li>\r\n"
					+ "          <li><a href=\"#\">Mail</a></li>\r\n"
					+ "          <li><a href=\"#\">Help</a></li>\r\n"
					+ "          <li><a href=\"#\">Location</a></li>\r\n"
					+ "          \r\n"
					+ "  </ul>\r\n"
					+ "</div>\r\n"
					+ "</footer>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "</html>");
		}
		else {
			resp.sendRedirect("./logout");
		}
		
		
	}
}
