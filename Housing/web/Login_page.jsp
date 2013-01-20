<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, ua.epam.servlet.filter.*, ua.epam.servletcontroller.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ЖЕК №81</title>
 <style type="text/css">
    /*<![CDATA[*/
      body {
        font-family: Arial, "Times New Roman", Times, serif;
          margin: 10px 0px;
      }
    </style>
</head>

<body bgproperties="fixed" bgcolor="#CCCCFF">
	<form name="auth" action="authUser.do" method="POST">
		<%@ page import="java.util.*"%>
		<%@ page import="java.sql.*"%>
		<%@ page import="java.text.*"%>
		<%@ page import="java.sql.Date"%>
		<%@ page language="java"%>
		<%!int flag = 0;%>
		<%!int ctr = 0;%>

		<p align="center"></p>

<table>
    <tr>
	
		<hr>
		<table border="0" width="100%" height="42">
			<tr>
				<td width="50%" height="36"><b><font size="5"><i>Добро пожаловать на страницу ЖЕК</i> </font> </b>
				</td>
				<td width="50%" height="36"></td>
			</tr>
			<tr>
				<td width="50%" height="36"><b><font size="5"><i>Для продолжения работы необходимо авторизоваться</i> </font> </b>
				</td>
				<td width="50%" height="36"></td>
			</tr>
		</table>
		<p align="left">
			<%
				String url = request.getRequestURI();
				String message;
				
				if ((request.getAttribute(UMConstants.ERRORMESSAGE) !=null)) {
					String theName = request.getParameter("txtUserName");
					String thePass = request.getParameter("txtUsrPwd");
					message = (String)request.getAttribute(UMConstants.ERRORMESSAGE);
			%>
			<b><font size="4" color="red"><%=message%></b></font><br></br>

			<%
				}
			%>
		</p>
	
		<p>
			<font>Имя пользователя:&nbsp;&nbsp;&nbsp; </font>
                        <input type="text" name="txtUserName" size="20">
		</p>
		<p>
			<font>Пароль:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font>
                        <input type="password" name="txtUsrPwd" size="20">&nbsp;
		</p>
		<p align="left">
			
			<input type="submit" value="Принять" name="login">&nbsp;<input
				type="button" value="Отменить" name="cancel" onClick="home()">
		</p>
	</form>
	<p>&nbsp;</p>
	<script language="JavaScript">
		function home() {
			open("Home_page.html");
		}
	</script>
</body>
</html>
