<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String successMsg = (String)request.getAttribute("successMsg");
String nextPage = (String)request.getAttribute("nextPage");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
</head>
<body>

<div class="container">
<jsp:include page="menu.inc.jsp"></jsp:include>

<div class="controlEleContainer" id="controlEleContainer">
	<fieldset class="controlBox">
		<legend class="legendsubhd">Result</legend>
		
		<section class="controlSection">
			<label><%=successMsg %></label>
		</section>
		
		<section class="btnSection">
			<input type="button" class="btn"  id="btnCrit"  onclick="fnCrit()" value=" Submit "value="OK" onclick="window.location.href='<%=request.getContextPath()%>/view/<%=nextPage %>'" />
		</section>
		
	</fieldset>
</div>

</div>
</body>
</html>