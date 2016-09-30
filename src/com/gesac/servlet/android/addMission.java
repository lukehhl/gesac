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
		// Ϊ�������ṩ������Ϣ
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// �����������ʵ��
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// ��ʼ����
		sfu.setFileSizeMax(1024 * 400);
		// ÿ�����������ݻ��װ��һ����Ӧ��FileItem������
		try {
			List<FileItem> items = sfu.parseRequest(request);
			// ���ֱ���
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
				// isFormFieldΪtrue����ʾ�ⲻ���ļ��ϴ�����
				if (!item.isFormField()) {
					ServletContext sctx = getServletContext();
					// ��ô���ļ�������·��
					// upload�µ�ĳ���ļ��� �õ���ǰ���ߵ��û� �ҵ���Ӧ���ļ���
					String path = sctx.getRealPath("/voice");
					// ����ļ���
					String fileName = item.getName();
					imagesrc = fileName;
					// �÷�����ĳЩƽ̨(����ϵͳ),�᷵��·��+�ļ���
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
