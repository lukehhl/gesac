package com.gesac.factory;

import com.gesac.dao.MissionDAO;
import com.gesac.dao.proxy.MissionDAOProxy;

public class MissionDAOFactory {
	public static MissionDAO getDAOInstance() {
		return new MissionDAOProxy();
	}
}
	
