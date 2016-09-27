package com.gesac.dao.proxy;

import java.sql.Connection;
import java.util.List;

import com.gesac.dao.EmployeeDAO;
import com.gesac.dao.impl.EmployeeDAOImpl;
import com.gesac.pojo.Employee;
import com.gesac.pub.GetConnection;


public class EmployeeDAOProxy implements EmployeeDAO {
	Connection conn = null;
	EmployeeDAOImpl impl = null;

	public EmployeeDAOProxy() {
		this.conn = GetConnection.getConnection();
		this.impl = new EmployeeDAOImpl(this.conn);
	}

	public void close() {
		try {
			this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<Employee> finAll() {
		List<Employee> list = this.impl.finAll();
		this.close();
		return list;
	}

}
