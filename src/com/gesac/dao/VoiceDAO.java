package com.gesac.dao;

import java.sql.Timestamp;
import java.util.List;

import com.gesac.pojo.Voice;

public interface VoiceDAO {
	public List<Voice> finAll();
	
	public boolean doIns(int vid, int eid, Timestamp vtime, String vsrc);


}
