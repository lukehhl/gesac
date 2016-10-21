package com.gesac.dao;

import java.sql.Timestamp;
import java.util.List;

import com.gesac.pojo.Mission;

public interface MissionDAO {
	public List<Mission> finAll();

	public boolean doIns(int eid,String vcustomer,String vdes, Timestamp vtime, Timestamp etime, String vsrc, int vsign);

	public boolean doDel(int vid);

	public boolean updMistate(int vid, int state);

	public boolean updMission(int vid, int eid,String vcustomer, String vdes, Timestamp vtime, Timestamp etime, String vsrc, int vsign);

}
