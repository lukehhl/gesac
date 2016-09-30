package com.gesac.servlet.android;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.gesac.factory.VoiceDAOFactory;

public class addMission extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addMission() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
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

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String imagesrc = null;
		String eid = null, vtime = null, etime = null, vsrc = null, vsign = null;
		// 为解析类提供配置信息
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 创建解析类的实例
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// 开始解析
		sfu.setFileSizeMax(1024 * 400);
		// 每个表单域中数据会封装到一个对应的FileItem对象上
		try {
			List<FileItem> items = sfu.parseRequest(request);
			// 区分表单域
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
				// isFormField为true，表示这不是文件上传表单域
				if (!item.isFormField()) {
					ServletContext sctx = getServletContext();
					// 获得存放文件的物理路径
					// upload下的某个文件夹 得到当前在线的用户 找到对应的文件夹
					String path = sctx.getRealPath("/voice");
					// 获得文件名
					String fileName = item.getName();
					imagesrc = fileName;
					// 该方法在某些平台(操作系统),会返回路径+文件名
					fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
					File file = new File(path + "\\" + fileName);
					if (!file.exists()) {
						item.write(file);
					}
					vsrc = "voice/" + imagesrc;
				} else {
					if ("eid".equalsIgnoreCase(item.getFieldName())) {
						eid = item.getString("utf-8").replaceAll("\"", "");
					}
					if ("vtime".equalsIgnoreCase(item.getFieldName())) {
						vtime = item.getString("utf-8").replaceAll("\"", "");
					}
					if ("vsign".equalsIgnoreCase(item.getFieldName())) {
						vsign = item.getString("utf-8").replaceAll("\"", "");
					}
				}
			}
			
			
			VoiceDAOFactory.getDAOInstance().doIns(Integer.parseInt(eid), Timestamp.valueOf(vtime),
					Timestamp.valueOf(vtime), vsrc, Integer.parseInt(vsign));
		} catch (Exception e) {
			e.printStackTrace();
		}

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
