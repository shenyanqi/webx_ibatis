package com.alibaba.webx.webxdemo.app2.module.screen.simple;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

public class Nihao {

	 @Autowired
	    private HttpServletResponse response;

	    public void execute() throws Exception {
	        // 设置content type，但不需要设置charset。框架会设置正确的charset。
	        response.setContentType("text/plain");

	        // 如同servlet一样：取得输出流。
	        PrintWriter out = response.getWriter();

	        out.println("Hi there, how are you doing today 2 ?");
	    }
}
