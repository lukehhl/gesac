package com.gesac.pub;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	public static final String DRIVER = "com.mysql.jdbc.Driver";//�������������·��
	public static final String URL = "jdbc:mysql://60.205.178.163:3306/gesac?characterEncoding=UTF-8";//�������ݿ����ӳ�
	public static final String DATANAME = "root";//���ݿ��û���
	public static final String PASSWORD  = "1505898";//����
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
