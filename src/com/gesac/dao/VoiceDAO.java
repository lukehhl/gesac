package com.gesac.dao;

import java.sql.Timestamp;
import java.util.List;

import com.gesac.pojo.Voice;

public interface VoiceDAO {
	public List<Voice> finAll();

	public boolean doIns(int eid, Timestamp vtime, Timestamp etime, String vsrc, int vsign);

	public boolean doDel(int vid);
	
	public boolean finMis(int vid);

}
