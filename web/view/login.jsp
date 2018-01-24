<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to TTCS</title>
<link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/view/css/ttcsweb.css">
<link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/view/css/font.css">
<link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/view/css/menu.css">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/view/engine1/style.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/view/engine1/jquery.js"></script>

<script type="text/javascript">
		function fnSubmitLogin()
		{
			//alert('hi');
			document.getElementById("userDetailsForm").submit(); 
		}
	</script>
</head>
<body class="bg-cyan">
	<div class="container">
		<header> 
			<img class="banner" alt="TTCS Banner" src="/ttcsweb/view/img/ttcsbanner.png"></header>
		<nav>
			<ul class="sky-mega-menu sky-mega-menu-response-to-icons sky-mega-menu-anim-flip">
				<li><a href="#"><i class="fa fa-edit fa-home"></i>Home</a></li>
				<li><a href="#"><i class="fa fa-edit"></i>Savings</a></li>
				<li><a href="#"><i class="fa fa-edit"></i>Loans</a></li>
				<li><a href="#"><i class="fa fa-edit"></i>Insurance</a></li>
				<li><a href="#"><i class="fa fa-edit"></i>Calculators</a></li>
				<li><a href="#"><i class="right"></i>Contacts</a></li>
				
			</ul>
		</nav>
		
		
		
		<div class="contentbox" id="slideshow">
			
			<div id="wowslider-container1">
			<div class="ws_images"><ul>
					<li><img src="<%=request.getContextPath()%>/view/data1/images/education_loans.jpg" alt="Education Loans" title="Education Loans" id="wows1_0"/></li>
					<li><img src="<%=request.getContextPath()%>/view/data1/images/fixed_deposits.jpg" alt="Fixed Deposits" title="Fixed Deposits" id="wows1_1"/></li>
					<li><img src="<%=request.getContextPath()%>/view/data1/images/general_savings.jpg" alt="General Savings" title="General Savings" id="wows1_2"/></li>
					<li><img src="<%=request.getContextPath()%>/view/data1/images/medical_loans.jpg" alt="Medical Loans" title="Medical Loans" id="wows1_3"/></li>
					<li><img src="<%=request.getContextPath()%>/view/data1/images/recurring_deposits.jpg" alt="css slider" title="Recurring Deposits" id="wows1_4"/></li>
					<li><img src="<%=request.getContextPath()%>/view/data1/images/wedding_loans.jpg" alt="Wedding Loans" title="Wedding Loans" id="wows1_5"/></li>
				</ul></div>
				<div class="ws_bullets"><div>
					<a href="#" title="Education Loans"><span><img src="<%=request.getContextPath()%>/view/data1/tooltips/education_loans.jpg" alt="Education Loans"/>1</span></a>
					<a href="#" title="Fixed Deposits"><span><img src="<%=request.getContextPath()%>/view/data1/tooltips/fixed_deposits.jpg" alt="Fixed Deposits"/>2</span></a>
					<a href="#" title="General Savings"><span><img src="<%=request.getContextPath()%>/view/data1/tooltips/general_savings.jpg" alt="General Savings"/>3</span></a>
					<a href="#" title="Medical Loans"><span><img src="<%=request.getContextPath()%>/view/data1/tooltips/medical_loans.jpg" alt="Medical Loans"/>4</span></a>
					<a href="#" title="Recurring Deposits"><span><img src="<%=request.getContextPath()%>/view/data1/tooltips/recurring_deposits.jpg" alt="Recurring Deposits"/>5</span></a>
					<a href="#" title="Wedding Loans"><span><img src="<%=request.getContextPath()%>/view/data1/tooltips/wedding_loans.jpg" alt="Wedding Loans"/>6</span></a>
				</div>
			<div class="ws_shadow"></div>
			</div>	
			<script type="text/javascript" src="<%=request.getContextPath()%>/view/engine1/wowslider.js"></script>
			<script type="text/javascript" src="<%=request.getContextPath()%>/view/engine1/script.js"></script>
				
		
			</div>
		</div>
	
		
		
		
		<div class="contentbox" id="leftsection">
			<div id="userloginbox" >
			<img src="<%=request.getContextPath()%>/view/img/loginhdr.jpg" class="loginImgheader">
					
			
			<form:form commandName="userDetailsCommand" id = "userDetailsForm" action="userLogin.spr" method="post" >
				
				<input type="hidden" id="function" name="function" value="L">
				
					<span class="errorMessage"><c:out value="${userDetailsCommand.errorMessage}"/></span>
				
				   <div class="loginElement">
								<input type="text" id="userId" name="userId" placeholder="User name" >
								<i class="icon-append fa fa-user"></i>
								
					</div>
					<div class="loginElement">			
								<input type="password" id="userPassword" name="userPassword" placeholder="Password">
								<i class="icon-append fa fa-lock"></i>
					</div>
					<div class="loginElement">
								<button  value= " " id="loginBtnId"  onclick="fnSubmitLogin()"> </button>
								<div class="note"><a href="#" class="modal-opener">Forgot password?</a></div>
					</div>
				
			</form:form>
			</div>
			<img src="<%=request.getContextPath()%>/view/img/founders.jpg" class="leftImgheader">
							    										
			<img src="<%=request.getContextPath()%>/view/img/photo/photo1.png" class="photo" > 
			<img src="<%=request.getContextPath()%>/view/img/photo/photo2.png" class="photo">
			<img src="<%=request.getContextPath()%>/view/img/photo/photo3.png" class="photo" >
			<img src="<%=request.getContextPath()%>/view/img/photo/photo4.png" class="photo" >
			<img src="<%=request.getContextPath()%>/view/img/photo/photo5.png" class="photo" >
			<img src="<%=request.getContextPath()%>/view/img/photo/photo6.png" class="photo" >
				
			
			<img src="<%=request.getContextPath()%>/view/img/photo/photo7.png" class="photo" >
			<img src="<%=request.getContextPath()%>/view/img/photo/photo8.png" class="photo" >
			
		</div>
		
		<div id="about">
			<img src="<%=request.getContextPath()%>/view/img/mainpage.png" class="aboutbox" >
			<img src="<%=request.getContextPath()%>/view/img/photo/Sec1_1.png" class="aboutbox" >
			<img src="<%=request.getContextPath()%>/view/img/photo/Sec1_2.png" class="aboutbox" >

		
		</div>
		
	</div>
</body>
</html>