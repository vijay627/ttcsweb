<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.ttcs.constants.TtcsConstants" %>
<%@ page import="com.ttcs.web.command.society.UserDetailsCommand" %>

<%
	String selectedFunction = (String)request.getAttribute("selectedFunction");
%>
<!DOCTYPE html">
<html>

<head>

<title>Customer Criteria Page</title>

<script type="text/javascript">

	function fnCrit()
	{
		var varFunction = document.getElementById("function").value;
		var custId = document.getElementById("custId").value;
		
		if(varFunction == '' || varFunction == 'B')
		{
			
			alert('Function should not be blank');
			
		}else if(varFunction != 'ADD' && custId =='')
		{
			alert('Customer Id should not be blank');
		}else
		{
			document.getElementById("customerCriteriaForm").submit(); 
		}
		
		
	}
</script>

</head>

<body>

<div class="container">
	<jsp:include page="menu.inc.jsp"></jsp:include>
	
	<form:form commandName="customerDetailsCommand" id = "customerCriteriaForm" name = "customerCriteriaForm" action="../customerDetails.spr" method="POST" >
		
		<input type="hidden" id="pageType" name="pageType" value="C">
		
		<div class="controlEleContainer" id="controlEleContainer">
			<fieldset class="controlBox">
				<legend class="legendsubhd">Customer Criteria</legend>
				<section class="controlSection">
					<label for="function">Function:</label>
					  <select name="function"  id="function" >
						<option value="B" <%if ("B".equals(selectedFunction)){ %>selected="selected" <%}%>></option>
						<option value="ADD" <%if ("ADD".equals(selectedFunction)){ %>selected="selected" <%}%>>ADD</option>
						<option value="UPDATE" <%if ("UPDATE".equals(selectedFunction)){ %>selected="selected" <%}%>>UPDATE</option>
						<option value="INQUIRY" <%if ("INQUIRY".equals(selectedFunction)){ %>selected="selected" <%}%>>INQUIRY</option>
						<option value="DELETE" <%if ("D".equals(selectedFunction)){ %>selected="selected" <%}%>>DELETE</option>
					</select>
					
				</section>
				
				<section class="controlSection">
					<label for="customerId">Customer Id:</label>
					<img src="<%=request.getContextPath()%>/view/img/search.gif" id="searchImg" name="searchImg" class="searchImg"/>	
					<input type="number" name="custId" id="custId"/>
					
				</section>
				
				<section class="btnSection">
					<input type="button" class="btn"  id="btnClear"  onclick="fnClear()" value=" Clear " />
					<input type="button" class="btn"  id="btnCrit"  onclick="fnCrit()" value=" Submit " />
					
				</section>
				
			</fieldset>
		</div>	
	</form:form>
	
	
</div>
</body>
</html>