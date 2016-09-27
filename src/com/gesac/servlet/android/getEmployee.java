package com.gesac.servlet.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gesac.factory.EmployeeDAOFactory;
import com.gesac.factory.RelationDAOFactory;
import com.gesac.pojo.Employee;
import com.gesac.pojo.Relation;
import com.gesac.pub.GetLeader;
import com.google.gson.Gson;

public class getEmployee extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public getEmployee() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");

		if ("getEmployee".equalsIgnoreCase(method)) {
			int leaderid = Integer.parseInt(request.getParameter("leaderid"));
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
			out.print(gson.toJson(emplo));
		} else if ("getLeader".equalsIgnoreCase(method)) {
			int staffid = Integer.parseInt(request.getParameter("staffid"));
			List<Integer> leaders = new ArrayList<Integer>();
			List<Relation> relations = RelationDAOFactory.getDAOInstance().finAll();
			Integer leaderid = GetLeader.getLeader(staffid, relations);
			if (leaderid != null) {
				leaders.add(leaderid);
			}
			for (int i = 0; i < leaders.size(); i++) {
				Integer id = GetLeader.getLeader(leaders.get(i), relations);
				if (id != null) {
					leaders.add(id);
				}
			}
			List<Employee> employees1 = EmployeeDAOFactory.getDAOInstance().finAll();
			List<Employee> employees2 = new ArrayList<Employee>();
			for (int i = 0; i < leaders.size(); i++) {
				for (int j = 0; j < employees1.size(); j++) {
					if (leaders.get(i) == employees1.get(j).getEid()) {
						employees2.add(employees1.get(j));
						break;
					}
				}
			}
			Gson gson = new Gson();
			out.print(gson.toJson(employees2));
		}
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
