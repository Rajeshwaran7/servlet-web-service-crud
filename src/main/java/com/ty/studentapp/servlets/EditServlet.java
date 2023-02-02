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

@WebServlet("/editForms")
public class EditServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
		
	resp.setContentType("text/html");
	PrintWriter out =resp.getWriter();
	
	 int sid=Integer.parseInt(req.getParameter("sid"));
     String name=req.getParameter("name");
     double marks= Double.parseDouble(req.getParameter("marks"));
     String email =req.getParameter("email");

     
     StudentDatabaseOperation operation=new StudentDatabaseOperation();
     boolean dataUpdated= operation.updateData(sid,name,marks,email);
      if(dataUpdated) {
      req.getRequestDispatcher("/display-All").forward(req, resp);
      }
      else {
    	  req.getRequestDispatcher("/edit").forward(req, resp);
      }
	
	
}
}
