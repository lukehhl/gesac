package com.gesac.pub;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	public static final String DRIVER = "com.mysql.jdbc.Driver";//定义驱动程序的路径
	public static final String URL = "jdbc:mysql://60.205.178.163:3306/gesac?characterEncoding=UTF-8";//配置数据库连接池
	public static final String DATANAME = "root";//数据库用户名
	public static final String PASSWORD  = "1505898";//密码
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,DATANAME,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
