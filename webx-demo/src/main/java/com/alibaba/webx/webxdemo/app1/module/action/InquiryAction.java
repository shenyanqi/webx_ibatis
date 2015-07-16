package com.alibaba.webx.webxdemo.app1.module.action;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.service.form.CustomErrors;
import com.alibaba.citrus.service.form.Form;
import com.alibaba.citrus.service.form.FormService;
import com.alibaba.citrus.service.form.Group;
import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormField;
import com.alibaba.webx.webxdemo.app1.InquiryBean;
import com.alibaba.webx.webxdemo.app1.UserBean;
import com.alibaba.webx.webxdemo.app1.dao.UserDao;

public class InquiryAction {
	@Autowired
	private FormService formService;
	@Autowired
	private UserDao userDao;
	public void doRegister(Navigator nav,Context context) throws Exception {
	
		Form form = formService.getForm(); 

        if (form.isValid()) { 
            Group group = form.getGroup("inquiry"); 
            InquiryBean inquirybean = new InquiryBean();
            group.setProperties(inquirybean);
            List<UserBean> list = userDao.querylist(inquirybean);
            System.out.println(list);
            context.put("inquiry", list);
            System.out.println(inquirybean.getInquiryType() + " " + inquirybean.getInquiryContent());
        }
	}

}
