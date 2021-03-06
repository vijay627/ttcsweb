<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.ttcs.constants.TtcsConstants" %>
<%@ page import="com.ttcs.web.command.society.UserDetailsCommand" %>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
UserDetailsCommand userDetailsCommand = (UserDetailsCommand)session.getAttribute(TtcsConstants.USER_DETAILS);
String userName = "";

if(userDetailsCommand !=null)
{
	userName = userDetailsCommand.getUserName();	
}

%>
<!DOCTYPE html">
<html>
<head>


<link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/view/css/ttcsweb.css">
<link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/view/css/font.css">
<link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/view/css/menu.css">
<link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/view/css/sky-forms.css">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/engine1/style.css" />
<script src="<%=request.getContextPath()%>/view/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/view/js/jquery.form.min.js"></script>
<script src="<%=request.getContextPath()%>/view/js/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath()%>/view/js/jquery.modal.js"></script>

<script type="text/javascript">

</script>

</head>
<body class="bg-cyan">
	<div class="menucontainer">
		<header> 
			<img class="banner" alt="TTCS Banner" src="/ttcsweb/view/img/ttcsbanner.png"></header>
		<nav>
			<ul class="sky-mega-menu sky-mega-menu-response-to-icons sky-mega-menu-anim-flip">
				<li><a href="#"><i class="fa fa-home"></i>Home</a></li>
				<li><a href="#"><i class="fa fa-edit"></i>Savings</a></li>
				<li><a href="#"><i class="fa fa-edit"></i>Loans</a></li>
				<li><a href="#"><i class="fa fa-edit"></i>Insurance</a></li>
				<li><a href="#"><i class="fa fa-edit"></i>Calculators</a></li>
				<li><a href="#"><i class="fa fa-edit"></i>Contacts</a></li>
				<li><a href="#sky-form2" class="modal-opener"><i class="right"></i>Welcome <%=userName %></a> </li>
				
			</ul>
		</nav>
		
	</div>
	
	<form action="#" id="sky-form2" class="sky-form sky-form-modal">
			<header class="modal-header">User Details<i class=" fa fa-times modal-closer"></i></header>
			
			<fieldset class="modalfields">					
				<section>
					<div class="row">
						<label >User Name: <c:out value="${userDetailsCommand.userName}"/></label>
					</div>
				</section>
				
				<section>
					<div class="row">
						<label>Email Id : <c:out value="${userDetailsCommand.userEmailId}"/></label>
					</div>
				</section>
				<section>
					<div class="row">
						<label >Mobile Number : <c:out value="${userDetailsCommand.userMobileNumber}"/></label>
					</div>
				</section>
			</fieldset>
			
				
			
	</form>
</body>
</html>