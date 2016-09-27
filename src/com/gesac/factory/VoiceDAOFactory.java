package com.gesac.factory;

import com.gesac.dao.VoiceDAO;
import com.gesac.dao.proxy.VoiceDAOProxy;

public class VoiceDAOFactory {
	public static VoiceDAO getDAOInstance() {
		return new VoiceDAOProxy();
	}
}
	
