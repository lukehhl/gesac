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
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(relations));
	}
}
