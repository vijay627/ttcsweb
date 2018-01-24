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

<title>Customer Details Page</title>

<script type="text/javascript">

	function fnDetails()
	{
		
		alert('page Type '+document.getElementById("pageType").value);
		document.getElementById("customerDetailsForm").submit(); 
		
	}
</script>

</head>

<body >

<div class="container">
	<jsp:include page="menu.inc.jsp"></jsp:include>
	
	<form:form commandName="customerDetailsCommand" id = "customerDetailsForm" name = "customerDetailsForm" action="customerDetails.spr" enctype="multipart/form-data" method="POST" >
	
		<input type="hidden" id="pageType" name="pageType" value="D">
		
		<spring:bind path="customerDetailsCommand.function"> 
		  <input type="hidden" name="<c:out value="${status.expression}"/>"
			id="<c:out value="${status.expression}"/>"
			value="<c:out value="${status.value}"/>" />
	     </spring:bind>
					
		<div class="controlEleContainer" id="controlEleContainer">
			<header class="pageHeader">Customer Details</header>
			<fieldset class="controlBox">					
				<section class="controlSection">
					<div class="row"> 
						<label >Function: <c:out value="${customerDetailsCommand.function}"/></label>
					</div>
				</section>
				
				<section class="controlSection">
					<div class="row">
						<label>Customer Id : <c:out value="${customerDetailsCommand.custId}"/></label>
					</div>
				</section>
			</fieldset>
			
			
			<fieldset class="controlBox">
				<legend class="legendsubhd">Personal Details</legend>
					
					<c:if test="${customerDetailsCommand.function != 'ADD'}">
						<section class="controlSection" style="float:right;">
						
						<img class="custphoto" src="<%=request.getContextPath()%>/cust/${customerDetailsCommand.custId}.jpg" />
						<img class="custsign" src="<%=request.getContextPath()%>/sign/${customerDetailsCommand.custId}.jpg" />
					
						</section>
					</c:if>
					
					<section class="controlSection">
					<label for="custName">First Name:</label>	
					 <spring:bind path="customerDetailsCommand.firstName"> 
						  <input type="text" name="<c:out value="${status.expression}"/>"
							id="<c:out value="${status.expression}"/>"
							value="<c:out value="${status.value}"/>" />
					     </spring:bind>
					</section>
					<section class="controlSection">
					<label for="custName">Last Name:</label>	
					 <spring:bind path="customerDetailsCommand.lastName"> 
						  <input type="text" name="<c:out value="${status.expression}"/>"
							id="<c:out value="${status.expression}"/>"
							value="<c:out value="${status.value}"/>" />
					     </spring:bind>
					</section>
					
					<section class="controlSection"><label for="gender">Gender:</label>
					 <spring:bind path="customerDetailsCommand.gender"> 
						  <select name="<c:out value="${status.expression}"/>"
							  id="<c:out value="${status.expression}"/>"    >
							<option value="MALE" <%if ("MALE".equals(selectedFunction)){ %>selected="selected" <%}%>>MALE</option>
							<option value="FEMALE" <%if ("FEMALE".equals(selectedFunction)){ %>selected="selected" <%}%>>FEMALE</option>
							</select>
						</spring:bind>
					</section>
					<section class="controlSection" ><label for="dateOfBirth"> Date Of Birth:</label>
					 <spring:bind path="customerDetailsCommand.dateOfBirth"> 
						  <input type="date" name="<c:out value="${status.expression}"/>"
							id="<c:out value="${status.expression}"/>"
							value="<c:out value="${status.value}"/>"/>
					     </spring:bind>
					</section> 
					
					<section class="controlSection"><label for="employeeId">Employee Id:</label> 
						 <spring:bind path="customerDetailsCommand.employeeId">
						  <input type="text" name="<c:out value="${status.expression}"/>"
							id="<c:out value="${status.expression}"/>"
							value="<c:out value="${status.value}"/>"/>
					     </spring:bind>
					</section>  
					<section class="controlSection"><label for="fatherSpouseName">Father/Spouse Name:</label>
					 <spring:bind path="customerDetailsCommand.fatherSpouseName"> 
						  <input type="text" name="<c:out value="${status.expression}"/>"
							id="<c:out value="${status.expression}"/>"
							value="<c:out value="${status.value}"/>"/>
					     </spring:bind>
					</section>
					
					<c:if test="${customerDetailsCommand.function == 'ADD'}">
						<section class="controlSection">
						<label for="custPhoto">Customer Photo:</label> 
						 <spring:bind path="customerDetailsCommand.custPhoto"> 
							  <input type="file" name="<c:out value="${status.expression}"/>"
								id="<c:out value="${status.expression}"/>"
								value="<c:out value="${status.value}"/>" placeholder="First Name"/>
						     </spring:bind>
						</section>
						<section class="controlSection">
						<label for="custPhoto">Customer Signature:</label> 
						 <spring:bind path="customerDetailsCommand.custSign"> 
							  <input type="file" name="<c:out value="${status.expression}"/>"
								id="<c:out value="${status.expression}"/>"
								value="<c:out value="${status.value}"/>" placeholder="First Name"/>
						     </spring:bind>
						</section>
					</c:if>
					
					
					
					
					<section class="controlSection"><label for="mobileNumber">Mobile Number:</label>
					 <spring:bind path="customerDetailsCommand.mobileNumber"> 
						  <input type="text" name="<c:out value="${status.expression}"/>"
							id="<c:out value="${status.expression}"/>"
							value="<c:out value="${status.value}"/>"/>
					     </spring:bind>
					</section> 
				
					<section class="controlSection"><label for="email">Email:</label>
					 <spring:bind path="customerDetailsCommand.email"> 
						  <input type="email" name="<c:out value="${status.expression}"/>"
							id="<c:out value="${status.expression}"/>"
							value="<c:out value="${status.value}"/>"/>
					     </spring:bind>
					</section> 
					
				
				
					
					
					
					<section class="controlSection"><label for="presentAddress">Present Address:</label>
					 <spring:bind path="customerDetailsCommand.presentAddress"> 
						  <textarea  name="<c:out value="${status.expression}"/>"
							id="<c:out value="${status.expression}"/>" 
							cols="50" rows="3" > </textarea>
					     </spring:bind>
					</section> 
					<section class="controlSection"><label for="permAddress">Permanent Address :</label>
					<spring:bind path="customerDetailsCommand.permAddress"> 
						  <textarea  name="<c:out value="${status.expression}"/>"
							id="<c:out value="${status.expression}"/>" 
							cols="50" rows="3" > </textarea>
					     </spring:bind>
					</section> 
						
			</fieldset>
			
			<fieldset class="controlBox">
				<legend class="legendsubhd">Identity and Address Proof Details</legend>
				
				<section class="controlSection"><label for="idProof">Id Proof:</label>
				 <spring:bind path="customerDetailsCommand.idProof"> 
					  <input type="text" name="<c:out value="${status.expression}"/>"
						id="<c:out value="${status.expression}"/>"
						value="<c:out value="${status.value}"/>"  />
				     </spring:bind>
				</section> 
				<section class="controlSection"><label for="idProofNumber">Id Proof Number:</label>
				 <spring:bind path="customerDetailsCommand.idProofNumber"> 
					  <input type="text" name="<c:out value="${status.expression}"/>"
						id="<c:out value="${status.expression}"/>"
						value="<c:out value="${status.value}"/>"  />
				     </spring:bind>
				</section> 
			
			
				<section class="controlSection"><label for="addressProof">Address Id:</label>
				 <spring:bind path="customerDetailsCommand.addressProof"> 
					  <input type="text" name="<c:out value="${status.expression}"/>"
						id="<c:out value="${status.expression}"/>"
						value="<c:out value="${status.value}"/>"  />
				     </spring:bind>
				</section> 
				<section class="controlSection"><label for="addressProofNumber">Address Proof Number:</label>
				 <spring:bind path="customerDetailsCommand.addressProofNumber"> 
					  <input type="text" name="<c:out value="${status.expression}"/>"
						id="<c:out value="${status.expression}"/>"
						value="<c:out value="${status.value}"/>"  />
				     </spring:bind>
				</section> 
					
			</fieldset>
			
			<fieldset class="controlBox">
				<legend class="legendsubhd">Nominee Details</legend>
					
				<section class="controlSection"><label for="nomineeName">Nominee Name:</label>
				
				 <spring:bind path="customerDetailsCommand.nomineeName"> 
					  <input type="text" name="<c:out value="${status.expression}"/>"
						id="<c:out value="${status.expression}"/>"
						value="<c:out value="${status.value}"/>"  />
				     </spring:bind>
				</section> 
			
				<section class="controlSection"><label for="nomineeDateOfBirth">Date Of Birth:</label>
				 <spring:bind path="customerDetailsCommand.nomineeDateOfBirth"> 
					  <input type="date" name="<c:out value="${status.expression}"/>"
						id="<c:out value="${status.expression}"/>"
						value="<c:out value="${status.value}"/>"  />
				     </spring:bind>
				</section> 
			
			
				<section class="controlSection"><label for="relation">Relation:</label>
				 <spring:bind path="customerDetailsCommand.relation"> 
					  <input type="text" name="<c:out value="${status.expression}"/>"
						id="<c:out value="${status.expression}"/>"
						value="<c:out value="${status.value}"/>"  />
				     </spring:bind>
				</section> 
				<section class="controlSection"><label for="nomineeAddress">Address:</label>
				 <spring:bind path="customerDetailsCommand.nomineeAddress"> 
					  <input type="text" name="<c:out value="${status.expression}"/>"
						id="<c:out value="${status.expression}"/>"
						value="<c:out value="${status.value}"/>"  />
				     </spring:bind>
				</section> 
				</fieldset>
				
				<section class="btnSection">
					<input type="button" class="btn"  id="btnClear"  onclick="fnClear()" value=" Clear " />
					<input type="button" class="btn"  id="btnDet"  onclick="fnDetails()" value=" Submit " />
					
				</section>
		</div>	
	</form:form>
</div>
</body>
</html>