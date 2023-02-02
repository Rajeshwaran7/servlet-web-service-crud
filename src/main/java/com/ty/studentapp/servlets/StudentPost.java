package com.ty.studentapp.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.studentapp.dao.Student;
import com.ty.studentapp.dto.StudentDatabaseOperation;

@WebServlet("/post")
public class StudentPost extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 resp.setContentType("text/html");
 PrintWriter out =resp.getWriter(); 

       int sid=Integer.parseInt(req.getParameter("sid"));
        String name=req.getParameter("name");
        double marks= Double.parseDouble(req.getParameter("marks"));
        String email =req.getParameter("email");
        String pwd=req.getParameter("password");

        Student st=new Student();
        st.setsId(sid);
        st.setName(name);
        st.setMarks(marks);
        st.setEmailId(email);
        st.setPwd(pwd);
        StudentDatabaseOperation operation=new StudentDatabaseOperation();
        boolean ss=operation.insertRow(st);
        if(ss) {
                RequestDispatcher dispatcher =req.getRequestDispatcher("/LogIn.html");
                dispatcher.forward(req, resp);
        }
        else {

            RequestDispatcher dispatcher =req.getRequestDispatcher("/Post.html");
            dispatcher.forward(req, resp);
        }
        out.close();
}
}
