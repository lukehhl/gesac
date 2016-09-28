<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<h3 align="center">新增保姆</h3>
	<form action="addMission.do" method="post"
		enctype="multipart/form-data">
		<table width="300" border="0" align="center">
			
			<tr>
				<th>eid</th>
				<td><input name="eid" type="text" />
				</td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<th>time</th>
				<td><input name="vtime" type="text" />
				</td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<th>保姆头像</th>
				<td><input name="vsrc" type="file" />
				</td>
			</tr>
			<tr>
				<td><br />
				</td>
			</tr>
		</table>
		<div align="center">
			<input type="submit" value="添加" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="hkeeper.jsp">返回上级</a>
		</div>
	</form>
</body>
</html>
