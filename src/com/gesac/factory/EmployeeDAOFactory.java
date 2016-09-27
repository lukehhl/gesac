package com.gesac.factory;

import com.gesac.dao.EmployeeDAO;
import com.gesac.dao.proxy.EmployeeDAOProxy;

public class EmployeeDAOFactory {
	public static EmployeeDAO getDAOInstance() {
		return new EmployeeDAOProxy();
	}
}
