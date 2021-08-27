package com.assignment.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.dao.ClassDAO;
import com.assignment.models.StudentClass;


@WebServlet("/AddClass")
public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddClass() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		if(id.isEmpty() || name.isEmpty()) {
			request.setAttribute("message", "Please Enter Class Id And Name.");
		}else {
			StudentClass stc = new StudentClass(id,name);
			if(ClassDAO.saveClass(stc)) {
				request.setAttribute("message", "Successfully Saved!");
			}else {
				request.setAttribute("message", "Register Fail");
			}
		}
		request.getRequestDispatcher("/BUD003.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
