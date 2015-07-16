package com.alibaba.webx.webxdemo.app1.dao;

import java.util.List;

import com.alibaba.webx.webxdemo.app1.InquiryBean;
import com.alibaba.webx.webxdemo.app1.UserBean;

public interface UserDao {

	UserBean basicQuery(String userId);
	void insertUser(UserBean userBean);
	void updateUser(UserBean userBean);
	List<UserBean> querylist(InquiryBean inquiryBean);
} 
