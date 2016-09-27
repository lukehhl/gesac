package com.gesac.pub;

import java.util.ArrayList;
import java.util.List;

import com.gesac.factory.EmployeeDAOFactory;
import com.gesac.factory.RelationDAOFactory;
import com.gesac.pojo.Employee;
import com.gesac.pojo.Relation;
import com.google.gson.Gson;

public class jcbcTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int leaderid = 6;
		List<Relation> relations = RelationDAOFactory.getDAOInstance().finAll();
		for (int i = 0; i < relations.size(); i++) {
			if (relations.get(i).getLeader() != leaderid) {
				relations.remove(i);
				i--;
			}

		}
		List<Employee> emplo = new ArrayList<Employee>();
		List<Employee> employees = EmployeeDAOFactory.getDAOInstance().finAll();
		for (int i = 0; i < relations.size(); i++) {
			for (int j = 0; j < employees.size(); j++) {
				if (relations.get(i).getStaff() == employees.get(j).getEid()) {
					emplo.add(employees.get(j));
					break;
				}
			}

		}
		Gson gson = new Gson();
		System.out.println(gson.toJson(emplo));
	}
}
