package com.alibaba.webx.webxdemo.app1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUserDao {

	private static String url = "jdbc:mysql://localhost:3306/shen";
	private static String user = "root";
	private static String passwd = "root";
	static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
	public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, passwd);
    }
	public static int save(String userId,String pw,String phone,String email){
		int re = 0;
		try {
			Connection connect = JDBCUserDao.getConnection();
			Statement stmt = connect.createStatement();
			re = stmt.executeUpdate("insert into user values('"+userId+"','"+pw+"','"+phone+"','"+email+"')");
		    stmt.close();
		    connect.close();
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	public static boolean inquiryUser(String userId){
		boolean re = false;
		try {
			ResultSet rs = null;
			Connection connect = null;
			connect = JDBCUserDao.getConnection();
			Statement stmt = connect.createStatement();
			rs = stmt.executeQuery("select name from user where name = '"+userId+"'");
			if(rs.next()) re = true;
			stmt.close();
			connect.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
		
	}
}
