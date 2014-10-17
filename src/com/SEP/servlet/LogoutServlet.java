package com.SEP.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session!=null){
			session.removeAttribute("user");
			request.setAttribute("message", "logout successfully<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/login.jsp'>");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
