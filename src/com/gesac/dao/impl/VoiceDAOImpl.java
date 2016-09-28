package com.gesac.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.gesac.dao.VoiceDAO;
import com.gesac.pojo.Voice;

public class VoiceDAOImpl implements VoiceDAO {

	Connection conn = null;

	public VoiceDAOImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Voice> finAll() {
		List<Voice> list = new ArrayList<Voice>();
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			String sql = "select * from voice";
			stat = this.conn.prepareStatement(sql);
			res = stat.executeQuery();// ÷¥––≤È—Ø”Ôæ‰
			while (res.next()) {
				Voice pojo = new Voice(res.getInt("vid"),
						res.getInt("eid"), res.getTimestamp("vtime"),
						res.getString("vsrc"));
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

	@Override
	public boolean doIns(int eid, Timestamp vtime, String vsrc) {
		boolean sign = false;
		PreparedStatement stat = null;
		try {
			String sql = "insert into voice(eid,vtime,vsrc) values(?,?,?)";
			stat = this.conn.prepareStatement(sql);
			stat.setInt(1, eid);
			stat.setTimestamp(2, vtime);
			stat.setString(3, vsrc);
			stat.executeUpdate();// ÷¥––≤Â»Î”Ôæ‰
			sign = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stat.close();
				return sign;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sign;
	}

}
