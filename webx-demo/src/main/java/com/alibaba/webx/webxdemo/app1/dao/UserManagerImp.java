package com.alibaba.webx.webxdemo.app1.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.webx.webxdemo.app1.UserBean;

public class UserManagerImp implements UserManager{

	@Autowired 
	private UserDao ui;
	public UserBean basicQuery(String str) {
		// TODO Auto-generated method stub
		return ui.basicQuery("shen");
	}

}
