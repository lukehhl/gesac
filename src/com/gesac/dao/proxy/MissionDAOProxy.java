package com.gesac.dao.proxy;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

import com.gesac.dao.MissionDAO;
import com.gesac.dao.impl.MissionDAOImpl;
import com.gesac.pojo.Mission;
import com.gesac.pub.GetConnection;

public class MissionDAOProxy implements MissionDAO {
	Connection conn = null;
	MissionDAOImpl impl = null;

	public MissionDAOProxy() {
		this.conn = GetConnection.getConnection();
		this.impl = new MissionDAOImpl(this.conn);
	}

	public void close() {
		try {
			this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Mission> finAll() {
		List<Mission> list = this.impl.finAll();
		this.close();
		return list;
	}

	@Override
	public boolean doIns(int eid, String vcustomer, String vdes, Timestamp vtime, Timestamp etime, String vsrc,
			int vsign) {
		boolean sign = this.impl.doIns(eid, vcustomer, vdes, vtime, etime, vsrc, vsign);
		this.close();
		return sign;

	}

	@Override
	public boolean doDel(int vid) {
		boolean sign = this.impl.doDel(vid);
		this.close();
		return sign;
	}

	@Override
	public boolean updMistate(int vid, int state) {
		boolean sign = this.impl.updMistate(vid, state);
		this.close();
		return sign;
	}

	@Override
	public boolean updMission(int vid, int eid, String vcustomer, String vdes, Timestamp vtime, Timestamp etime,
			String vsrc, int vsign) {
		boolean sign = this.impl.updMission(vid, eid, vcustomer, vdes, vtime, etime, vsrc, vsign);
		this.close();
		return sign;
	}

}
