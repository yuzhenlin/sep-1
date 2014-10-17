package com.SEP.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.SEP.domain.Captcha;
import com.SEP.utils.WebUtils;

public class CaptchaServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Captcha captcha=WebUtils.getCaptcha();
		response.setContentType("image/jpeg");
		
		response.setDateHeader("expries", -1);
		response.setHeader("Chche-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		request.getSession().setAttribute("captcha", captcha.getCaptchaCode());
		
		ImageIO.write(captcha.getImage(), "jpg", response.getOutputStream());
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
