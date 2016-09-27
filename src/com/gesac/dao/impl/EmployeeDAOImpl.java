package com.gesac.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gesac.dao.EmployeeDAO;
import com.gesac.pojo.Employee;


public class EmployeeDAOImpl implements EmployeeDAO{

	Connection conn = null;

	public EmployeeDAOImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Employee> finAll() {
		List<Employee> list = new ArrayList<Employee>();
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			String sql = "select * from employee";
			stat = this.conn.prepareStatement(sql);
			res = stat.executeQuery();// ÷¥––≤È—Ø”Ôæ‰
			while (res.next()) {
				Employee pojo = new Employee(res.getInt("eid"),
						res.getString("enumber"), res.getString("ename"),
						res.getString("ejob"), res.getString("edepart"),
						res.getString("etele"),res.getString("ephone"),
						res.getString("email"));
				list.add(pojo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				res.close();
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	

}
