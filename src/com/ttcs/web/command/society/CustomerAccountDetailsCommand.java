package com.ttcs.web.command.society;




public class CustomerAccountDetailsCommand {
	
	private CustomerDetailsCommand customerDetailsCommand;
	
	private GenSavingsDetailsCommand genSavingsDetailsCommand;
	
	private PersonalLoanDetailsCommand personalLoanDetailsCommand;
	
	private HandLoanDetailsCommand handLoanDetailsCommand;
	

	public GenSavingsDetailsCommand getGenSavingsDetailsCommand() {
		return genSavingsDetailsCommand;
	}

	public void setGenSavingsDetailsCommand(
			GenSavingsDetailsCommand genSavingsDetailsCommand) {
		this.genSavingsDetailsCommand = genSavingsDetailsCommand;
	}

	public PersonalLoanDetailsCommand getPersonalLoanDetailsCommand() {
		return personalLoanDetailsCommand;
	}

	public void setPersonalLoanDetailsCommand(
			PersonalLoanDetailsCommand personalLoanDetailsCommand) {
		this.personalLoanDetailsCommand = personalLoanDetailsCommand;
	}

	public CustomerDetailsCommand getCustomerDetailsCommand() {
		return customerDetailsCommand;
	}

	public void setCustomerDetailsCommand(
			CustomerDetailsCommand customerDetailsCommand) {
		this.customerDetailsCommand = customerDetailsCommand;
	}

	public HandLoanDetailsCommand getHandLoanDetailsCommand() {
		return handLoanDetailsCommand;
	}

	public void setHandLoanDetailsCommand(
			HandLoanDetailsCommand handLoanDetailsCommand) {
		this.handLoanDetailsCommand = handLoanDetailsCommand;
	}

	
	
	
}
