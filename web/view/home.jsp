<%@ page language="java" 
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>

<head>

<title>TTCS Home Page</title>


</head>

<body>

<div class="container">
<jsp:include page="menu.inc.jsp"></jsp:include>
	<div class="tilesContainer" id="tilesContainer">
		
		<div class="tilebox" id="leftmenu">
		
		<span class="subhd">Administrator</span>
		
		<fieldset class="settings">
			<legend class="menuItem  icon-append fa fa-wrench">&nbsp;Settings</legend>
			<ul class="homemenu">
				<li><a href="<%=request.getContextPath()%>/adminParamGS.spr"  class="menuItem">Deposits</a> </li>
				<li><a href="<%=request.getContextPath()%>/adminParamHL.spr"  class="menuItem">Loans</a> </li>
	   			<li><a href="<%=request.getContextPath()%>/adminParamGI.spr"  class="menuItem">Insurance</a> </li>
	   			<li>&nbsp; </li>
  			</ul>
  		</fieldset>
  		<fieldset class="settings">
			<legend class="menuItem">&nbsp;Others</legend>
			<ul class="homemenu">
			<li><a href="<%=request.getContextPath()%>/userDetails.spr"  class="menuItem">User</a> </li>
			<li>&nbsp; </li>	
			<li><a href="<%=request.getContextPath()%>/userDetails.spr"  class="menuItem">Backup</a> </li>
			
			</ul>
		</fieldset>
			
		</div>
		
		<div class="tilebox" id="rightmenu">
			
				<span class="subhd">Balance Sheet</span>
			<fieldset class="summarySubDiv">
				<legend class="menuItem">Savings</legend>
    			<div class="summary"></div>
    		</fieldset> 
    		<fieldset class="summarySubDiv">
				<legend class="menuItem">Loans</legend>
    			<div class="summary"></div>
    		</fieldset> 
    		<fieldset class="summarySubDiv">
				<legend class="menuItem">Insurance</legend>
    			<div class="summary"></div>
    		</fieldset> 
	    	
			
		</div>
		
		
		<div class="tilebox" id="tile1">
			<ul class="homemenu">
    			<li><a href="<%=request.getContextPath()%>/view/customerCriteria.jsp"  class="menuItem icon-append fa fa-user crm">&nbsp;Customer Relationship Management</a> </li>
	    	</ul>
			
		</div>
		<div class="tilebox" id="tile2">
			<ul class="homemenu">
    			<li><a href="<%=request.getContextPath()%>/existingCutomer.spr"  class="menuItem icon-append fa fa-list accSummary">&nbsp;Account Summary</a> </li>    			
	    	</ul>
			
		</div>
		<div class="tilebox" id="tile3">
			<span class="subhd"> Deposits</span>
			<ul class="homemenu">
    			<li><a href="<%=request.getContextPath()%>/newGenSavings.spr"  class="menuItem"> Non Recurring Deposit</a> </li>
    			<li><a href="<%=request.getContextPath()%>/newFixedDeposits.spr"  class="menuItem"> Fixed Deposit</a> </li>
    			<li><a href="<%=request.getContextPath()%>/newRecurringDesposits.spr"  class="menuItem"> Recurring Deposit</a>
    			<li><a href="<%=request.getContextPath()%>/adminParamTD.spr"  class="menuItem">10% Deposit</a> </li>
	    	</ul>
			
		</div>
		<div class="tilebox" id="tile4">
			<span class="subhd">Loans</span>
			<ul class="homemenu">
				<li><a href="<%=request.getContextPath()%>/adminParamHL.spr"  class="menuItem">Hand Loan</a> </li>
	   			<li><a href="<%=request.getContextPath()%>/adminParamPL.spr"  class="menuItem">Personal Loan</a> </li>
	   			<li><a href="<%=request.getContextPath()%>/adminParamML.spr"  class="menuItem">Medical Loans</a> </li>
	   			<li><a href="<%=request.getContextPath()%>/adminParamEL.spr"  class="menuItem">Education Loans</a> </li>
	   			<li><a href="<%=request.getContextPath()%>/adminParamML.spr"  class="menuItem">Marriage Loans</a> </li>
   			</ul>
			
		</div>
		<div class="tilebox" id="tile5">
			<span class="subhd">Insurance</span>
			<ul class="homemenu">
				<li><a href="<%=request.getContextPath()%>/adminParamGI.spr"  class="menuItem">General Insurance</a> </li>
	   			<li><a href="<%=request.getContextPath()%>/adminParamLI.spr"  class="menuItem">Loan Insurance</a> </li>
   			</ul>
		</div>
		<div class="tilebox" id="reports">
		
			<ul class="homemenu">
    			<li><a href="<%=request.getContextPath()%>/userCriteria.spr"  class="menuItem">Reports</a> </li>
	    	</ul>
			
		</div>
		<div class="tilebox" id="tile6">
			<span class="subhd">Office Accounts</span>
			<ul class="homemenu tablecell">
				<li><a href="<%=request.getContextPath()%>/officeDepositAccount.spr"  class="menuItem">Ledger Account</a> </li>
    			<li><a href="<%=request.getContextPath()%>/officeDepositAccount.spr"  class="menuItem">Savings Account</a> </li>
    			<li><a href="<%=request.getContextPath()%>/officeLoanAccount.spr"  class="menuItem">Loan Account</a> </li>
    			<li><a href="<%=request.getContextPath()%>/officeInsuranceAccount.spr"  class="menuItem">Insurance Account</a> </li>
    			<li><a href="<%=request.getContextPath()%>/officeChargesAccount.spr"  class="menuItem">Charges Account</a> </li>
    			<li><a href="<%=request.getContextPath()%>/officeExpendatureAccount.spr"  class="menuItem">Expenditure Account</a> </li>
    			<li><a href="<%=request.getContextPath()%>/officeCorpusFundAccount.spr"  class="menuItem">Corpus Fund Account</a> 
    		</ul>
		</div>
		
	</div>
</div>
</body>
</html>