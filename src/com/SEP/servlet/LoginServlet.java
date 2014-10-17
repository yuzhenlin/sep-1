package com.SEP.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.SEP.domain.User;
import com.SEP.service.Service;
import com.SEP.utils.WebUtils;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		//go back login page
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String code1=request.getParameter("captcha").toLowerCase();//jsp page
		String code2=((String) request.getSession().getAttribute("captcha")).toLowerCase();
		if(!code1.equals(code2)){
			request.setAttribute("error", "captcha error");
			doGet(request, response);
			return;
		}
		else{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username==null||password==null){
			request.setAttribute("message", "please entery username and password");
			doGet(request, response);
		}
		password=WebUtils.md5(password);//123456
		Service s=new Service();
		User user=s.find(username, password);
		if(user!=null){
			request.getSession().setAttribute("user", user);			
			request.setAttribute("message", "login successfully<meta http-equiv=\"refresh\" content=\"3;url="+request.getContextPath()+"/index.jsp\">");	
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		request.setAttribute("message", "username or password error");
		doGet(request, response);
		}
	}

}
