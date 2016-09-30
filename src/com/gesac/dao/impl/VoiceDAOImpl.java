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
				Voice pojo = new Voice(res.getInt("vid"), res.getInt("eid"), res.getTimestamp("vtime"),
						res.getTimestamp("etime"), res.getString("vsrc"), res.getInt("vsign"));
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
	public boolean doIns(int eid, Timestamp vtime, Timestamp etime, String vsrc, int vsign) {
		boolean sign = false;
		PreparedStatement stat = null;
		try {
			String sql = "insert into voice(eid,vtime,etime,vsrc,vsign) values(?,?,?,?,?)";
			stat = this.conn.prepareStatement(sql);
			stat.setInt(1, eid);
			stat.setTimestamp(2, vtime);
			stat.setTimestamp(3, etime);
			stat.setString(4, vsrc);
			stat.setInt(5, vsign);
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

	@Override
	public boolean doDel(int vid) {
		boolean sign = false;
		PreparedStatement stat = null;
		try {
			String sql = "delete from voice where vid = ?";
			stat = this.conn.prepareStatement(sql);
			stat.setInt(1, vid);
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
