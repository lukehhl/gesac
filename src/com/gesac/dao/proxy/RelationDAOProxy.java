package com.gesac.dao.proxy;

import java.sql.Connection;
import java.util.List;

import com.gesac.dao.RelationDAO;
import com.gesac.dao.impl.RelationDAOImpl;
import com.gesac.pojo.Relation;
import com.gesac.pub.GetConnection;

public class RelationDAOProxy implements RelationDAO {
	Connection conn = null;
	RelationDAOImpl impl = null;

	public RelationDAOProxy() {
		this.conn = GetConnection.getConnection();
		this.impl = new RelationDAOImpl(this.conn);
	}

	public void close() {
		try {
			this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Relation> finAll() {
		List<Relation> list = this.impl.finAll();
		this.close();
		return list;
	}

}
