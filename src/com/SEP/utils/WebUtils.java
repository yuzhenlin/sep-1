package com.SEP.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.SEP.domain.Captcha;


import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;

public class WebUtils {
	
	public static <T> T request2Bean(HttpServletRequest request,Class<T> beanClass){
		
		try{
			T t = beanClass.newInstance();
			Map map = request.getParameterMap();
			
			BeanUtils.populate(t, map);
			return t;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	public static String md5(String password){
		//把密码转为md5再转为base64返回
		try {
			MessageDigest md=MessageDigest.getInstance("md5");
			byte[] md5=md.digest(password.getBytes());
			BASE64Encoder encoder=new BASE64Encoder();
			return encoder.encode(md5);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	public static final int WIDTH=120;
	public static final int HEIGHT=30;
	public static Captcha getCaptcha(){
		Captcha captcha=new Captcha();
		BufferedImage image=new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	//create image,set width,height,color type RGB
		Graphics2D g=(Graphics2D) image.getGraphics();
		//get graphics change to Graphics2D,because graphics cannot rotate,2D can rotate
		
		//set background color
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		//set border
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, WIDTH-1, HEIGHT-1);

		//draw some line
		g.setColor(Color.PINK);
		for(int i=0;i<10;i++){
			int x1=new Random().nextInt(WIDTH-1);
			int y1=new Random().nextInt(HEIGHT-1);
			int x2=new Random().nextInt(WIDTH-1);
			int y2=new Random().nextInt(HEIGHT-1);
			g.drawLine(x1, y1, x2, y2);
		}
		
		
		//draw 4 num
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		String captchaCode="";
		for(int i=0;i<4;i++){
			int degree=new Random().nextInt(60)-30;//rotate degree
			g.rotate(degree*Math.PI/180, 15+i*25, 0);//set rotate degree,degree=x° *3.14/180
			String num=(char)creativeNum()+"";//create char type
			captchaCode+=num;
			g.drawString(num, 5+i*25, 25);//draw num
			g.rotate(-degree*Math.PI/180, 5+i*30, 0);
			//rotate back,for next time use
			}
		
		captcha.setImage(image);
		captcha.setCaptchaCode(captchaCode);
		return captcha;
		
	} 
	
	private static int creativeNum() {
		//recursion
		//48-57(0-9), 65-90(a-z), 97-122(A-Z) ASCII
		int num=new Random().nextInt(122);		
		if(((num>=48&&num<=57)||(num>=65&&num<=90)||(num>=97&&num<=122))==false){
			num=creativeNum();
		}
		//System.out.println(num);
		return num;
	}
	
}
