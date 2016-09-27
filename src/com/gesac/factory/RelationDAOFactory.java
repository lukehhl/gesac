package com.gesac.factory;

import com.gesac.dao.RelationDAO;
import com.gesac.dao.proxy.RelationDAOProxy;

public class RelationDAOFactory {
	public static RelationDAO getDAOInstance() {
		return new RelationDAOProxy();
	}
}
