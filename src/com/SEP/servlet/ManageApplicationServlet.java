package com.SEP.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SEP.service.Service;

public class ManageApplicationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Service s=new Service();
		String method=request.getParameter("method");
		if(method.equals("save")){
			
		}
		else if(method.equals("submit")){
			
			
		}else if(method.equals("edit")){
			
			
		}
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
