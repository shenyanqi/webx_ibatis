package com.alibaba.webx.webxdemo.app1.dao;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.webx.webxdemo.app1.InquiryBean;
import com.alibaba.webx.webxdemo.app1.UserBean;

@SuppressWarnings("deprecation")
public class UserDaoImp extends SqlMapClientDaoSupport implements UserDao{

	public UserBean basicQuery(String userId) {
		// TODO Auto-generated method stub
		return (UserBean) getSqlMapClientTemplate().queryForObject("basicQuery",userId);
	}

	public void insertUser(UserBean userBean) {
		// TODO Auto-generated method stub
		SqlMapClientTemplate sqlmapClientTemplate = getSqlMapClientTemplate();
		
		sqlmapClientTemplate.insert("insertUser",userBean);
	}

	public void updateUser(UserBean userBean) {
		// TODO Auto-generated method stub
		SqlMapClientTemplate sqlmapClientTemplate = getSqlMapClientTemplate();
		sqlmapClientTemplate.update("updateUser", userBean);
	}

	public List<UserBean> querylist(InquiryBean inquiryBean) {
		// TODO Auto-generated method stub
		SqlMapClientTemplate sqlmapClientTemplate = getSqlMapClientTemplate();
		return sqlmapClientTemplate.queryForList("querylist", inquiryBean);
	}
	
	

}
