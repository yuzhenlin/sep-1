<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <form action="${pageContext.request.contextPath}/login.jsp"   method="post">
                username:<input type="text" name="username" /><br />
                password:<input type="password" name="password" /><br />
              	
              	<input type="text" name="captcha" size="5">
         		<img src="${pageContext.request.contextPath}/servlet/CaptchaServlet">
          		<span id="error" style="color:red">${error}</span>
        
              
                <input type="submit" value="submit">
                </form>
                ${message}<br />
                
				
  
  </body>
</html>
