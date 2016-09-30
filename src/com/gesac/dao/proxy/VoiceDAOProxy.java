package com.gesac.dao.proxy;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

import com.gesac.dao.VoiceDAO;
import com.gesac.dao.impl.VoiceDAOImpl;
import com.gesac.pojo.Voice;
import com.gesac.pub.GetConnection;

public class VoiceDAOProxy implements VoiceDAO {
	Connection conn = null;
	VoiceDAOImpl impl = null;

	public VoiceDAOProxy() {
		this.conn = GetConnection.getConnection();
		this.impl = new VoiceDAOImpl(this.conn);
	}

	public void close() {
		try {
			this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Voice> finAll() {
		List<Voice> list = this.impl.finAll();
		this.close();
		return list;
	}

	@Override
	public boolean doIns(int eid, Timestamp vtime, Timestamp etime, String vsrc, int vsign) {
		boolean sign = this.impl.doIns(eid, vtime, etime, vsrc, vsign);
		this.close();
		return sign;

	}

	@Override
	public boolean doDel(int vid) {
		boolean sign = this.impl.doDel(vid);
		this.close();
		return sign;
	}

}
