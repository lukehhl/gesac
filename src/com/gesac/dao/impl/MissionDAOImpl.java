package com.gesac.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.gesac.dao.MissionDAO;
import com.gesac.pojo.Mission;

public class MissionDAOImpl implements MissionDAO {

	Connection conn = null;

	public MissionDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Mission> finAll() {
		List<Mission> list = new ArrayList<Mission>();
		PreparedStatement stat = null;
		ResultSet res = null;
		try {
			String sql = "select * from mission";
			stat = this.conn.prepareStatement(sql);
			res = stat.executeQuery();// ÷¥––≤È—Ø”Ôæ‰
			while (res.next()) {
				Mission pojo = new Mission(res.getInt("vid"), res.getInt("eid"), res.getInt("vsign"), res.getTimestamp("vtime"),
						res.getTimestamp("etime"), res.getString("vsrc"), res.getString("vdes"),res.getString("vcustomer"));
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
	public boolean doIns(int eid, String vcustomer,String vdes, Timestamp vtime, Timestamp etime, String vsrc, int vsign) {
		boolean sign = false;
		PreparedStatement stat = null;
		try {
			String sql = "insert into mission(eid,vcustomer,vdes,vtime,etime,vsrc,vsign) values(?,?,?,?,?,?,?)";
			stat = this.conn.prepareStatement(sql);
			stat.setInt(1, eid);
			stat.setString(2, vcustomer);
			stat.setString(3, vdes);
			stat.setTimestamp(4, vtime);
			stat.setTimestamp(5, etime);
			stat.setString(6, vsrc);
			stat.setInt(7, vsign);
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
			String sql = "delete from mission where vid = ?";
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

	public boolean updMistate(int vid, int state) {
		PreparedStatement stat = null;

		try {
			String sql = "update mission set vsign = ? where vid = ?";
			stat = this.conn.prepareStatement(sql);
			stat.setInt(1, state);
			stat.setInt(2, vid);
			stat.executeUpdate();// ÷¥––≤È—Ø”Ôæ‰
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean updMission(int vid, int eid, String vcustomer, String vdes, Timestamp vtime, Timestamp etime, String vsrc, int vsign) {
		PreparedStatement stat = null;

		try {
			String sql = "update mission set eid = ?, vcustomer = ?, vdes = ?, vtime = ?, etime = ?, vsrc = ?, vsign = ? where vid = ?";
			stat = this.conn.prepareStatement(sql);
			stat.setInt(1, eid);
			stat.setString(2, vcustomer);
			stat.setString(3, vdes);
			stat.setTimestamp(4, vtime);
			stat.setTimestamp(5, etime);
			stat.setString(6, vsrc);
			stat.setInt(7, vsign);
			stat.setInt(8, vid);
			stat.executeUpdate();// ÷¥––≤È—Ø”Ôæ‰
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
