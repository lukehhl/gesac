package com.gesac.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gesac.dao.RelationDAO;
import com.gesac.pojo.Relation;

public class RelationDAOImpl implements RelationDAO {

	Connection conn = null;

	public RelationDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Relation> finAll() {
		List<Relation> list = new ArrayList<Relation>();
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			String sql = "select * from Relation";
			stat = this.conn.prepareStatement(sql);
			res = stat.executeQuery();// ÷¥––≤È—Ø”Ôæ‰
			while (res.next()) {
				Relation pojo = new Relation(res.getInt("rid"), res.getInt("leader"), res.getInt("staff"));
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
