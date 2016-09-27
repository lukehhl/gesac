/**
 * 
 */
package com.gesac.pub;

import java.util.List;

import com.gesac.factory.RelationDAOFactory;
import com.gesac.pojo.Relation;

/**
 * @author GE11522
 *
 */
public class GetLeader {
	public static Integer getLeader(int staff, List<Relation> relations) {
		for (int i = 0; i < relations.size(); i++) {
			if (staff == relations.get(i).getStaff()) {
				return relations.get(i).getLeader();
			}
		}
		return null;
	}
}
