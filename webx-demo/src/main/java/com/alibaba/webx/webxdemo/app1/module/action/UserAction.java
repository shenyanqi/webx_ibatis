package com.alibaba.webx.webxdemo.app1.module.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.service.form.CustomErrors;
import com.alibaba.citrus.service.form.Form;
import com.alibaba.citrus.service.form.FormService;
import com.alibaba.citrus.service.form.Group;
import com.alibaba.citrus.service.requestcontext.parser.ParameterParser;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormField;
import com.alibaba.webx.webxdemo.app1.UserBean;
import com.alibaba.webx.webxdemo.app1.dao.JDBCUserDao;
import com.alibaba.webx.webxdemo.app1.dao.UserDao;
import com.alibaba.webx.webxdemo.app1.dao.UserManager;

public class UserAction {
	@Autowired
	private FormService formService; 
	@Autowired
	private UserDao userDao;

	public void doRegister(@FormField(name = "userId", group = "register") CustomErrors err,Navigator nav
			) throws Exception {
        Form form = formService.getForm(); 

        if (form.isValid()) { 
            Group group = form.getGroup("register"); 

            
            UserBean user = new UserBean(); 
            group.setProperties(user); 
            //UserDaoImp ui = new UserDaoImp();
            //ui.basicQuery("shen");
            UserBean userbool = userDao.basicQuery(user.getUserId());
            
            //JDBCUserDao.inquiryUser(user.getUserId())
            if(userbool != null){
            	Map<String, Object> params = new HashMap<String,Object>();
                params.put("userId", user.getUserId());
            	err.setMessage("duplicatedUserId", params);
            }else{
                //JDBCUserDao.save(user.getUserId(),user.getPassword(),user.getPhone(),user.getEmail());
                userDao.insertUser(user);
            	// 跳转到注册成功页面
                nav.redirectToLocation("welcome?name="+user.getUserId());
                //nav.redirectTo("app1link").withTarget("/welcome").withParameter("name", user.getUserId());
            }
            
        }
    }
}
