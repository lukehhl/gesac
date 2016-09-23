package com.gesac.pub;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.hk.factory.HkeeperDAOFactory;
import com.hk.factory.ServItemDAOFactory;
import com.hk.factory.Sitem_hkDAOFactory;
import com.hk.pojo.HkeeperPOJO;
import com.hk.pojo.ServItemPOJO;
import com.hk.pojo.Sitem_hkPOJO;

public class jcbcTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Sitem_hkPOJO> sihklist = Sitem_hkDAOFactory.getDAOInstance()
				.finBysiid(2);
		List<HkeeperPOJO> hklist = new ArrayList<HkeeperPOJO>();
		for (int i = 0; i < sihklist.size(); i++) {
			HkeeperPOJO hk = HkeeperDAOFactory.getDAOInstance()
					.finByhkid(sihklist.get(i).getHkid()).get(0);
			hk.setHkpic("http://192.168.23.1:8080/housekeeping/" + hk.getHkpic());
			hklist.add(hk);
		}
		Gson gson = new Gson();
		String objectToJSON = gson.toJson(hklist);
        System.out.println(objectToJSON);
	}
}
