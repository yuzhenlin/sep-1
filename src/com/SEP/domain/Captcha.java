package com.SEP.domain;

import java.awt.image.BufferedImage;

public class Captcha {
	 private BufferedImage image;
	 private String captchaCode;
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public String getCaptchaCode() {
		return captchaCode;
	}
	public void setCaptchaCode(String captchaCode) {
		this.captchaCode = captchaCode;
	}
}
