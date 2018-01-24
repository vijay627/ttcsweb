package com.ttcs.web.command.society;




public class UpdateCustomerCommand {
	
	private Long refCustId;
	private Long custId;	
	private String title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dateOfBirth;
	private Integer mobileNumber;
	private String email;
	private String gender;
	private String maritalStatus;
	private String fatherSpouseName;
	
	private String presentHouseNumber;
	private String presentStreetName;
	private String presentLocality;
	private String presentCity;
	private String presentDist;
	private String presentSate;
	private String presentPIN;
	
	private String permHouseNumber;
	private String permStreetName;
	private String permLocality;
	private String permCity;
	private String permDist;
	private String permSate;
	private String permPIN;
	
	private String employeeId;
	private String designation;
	private String workingAddress;
	
	private String idProof;
	private String idProofNumber;
	private String addressProof;
	private String addressProofNumber;
	
	private String nomineeName;
	private String nomineeDateOfBirth;
	private String relation;
	private String nomineeAddress;
	
	private String bankName;
	private String accountNumber;
	private String branchName;	
	private String micrCode;
	private String accountOpeningChargesColleted;
	private String documentsCollected;
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountOpeningChargesColleted() {
		return accountOpeningChargesColleted;
	}
	public void setAccountOpeningChargesColleted(
			String accountOpeningChargesColleted) {
		this.accountOpeningChargesColleted = accountOpeningChargesColleted;
	}
	public String getAddressProof() {
		return addressProof;
	}
	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}
	public String getAddressProofNumber() {
		return addressProofNumber;
	}
	public void setAddressProofNumber(String addressProofNumber) {
		this.addressProofNumber = addressProofNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDocumentsCollected() {
		return documentsCollected;
	}
	public void setDocumentsCollected(String documentsCollected) {
		this.documentsCollected = documentsCollected;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFatherSpouseName() {
		return fatherSpouseName;
	}
	public void setFatherSpouseName(String fatherSpouseName) {
		this.fatherSpouseName = fatherSpouseName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIdProof() {
		return idProof;
	}
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}
	public String getIdProofNumber() {
		return idProofNumber;
	}
	public void setIdProofNumber(String idProofNumber) {
		this.idProofNumber = idProofNumber;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getMicrCode() {
		return micrCode;
	}
	public void setMicrCode(String micrCode) {
		this.micrCode = micrCode;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public Integer getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getNomineeAddress() {
		return nomineeAddress;
	}
	public void setNomineeAddress(String nomineeAddress) {
		this.nomineeAddress = nomineeAddress;
	}
	public String getNomineeDateOfBirth() {
		return nomineeDateOfBirth;
	}
	public void setNomineeDateOfBirth(String nomineeDateOfBirth) {
		this.nomineeDateOfBirth = nomineeDateOfBirth;
	}
	public String getNomineeName() {
		return nomineeName;
	}
	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}
	public String getPermCity() {
		return permCity;
	}
	public void setPermCity(String permCity) {
		this.permCity = permCity;
	}
	public String getPermDist() {
		return permDist;
	}
	public void setPermDist(String permDist) {
		this.permDist = permDist;
	}
	public String getPermHouseNumber() {
		return permHouseNumber;
	}
	public void setPermHouseNumber(String permHouseNumber) {
		this.permHouseNumber = permHouseNumber;
	}
	public String getPermLocality() {
		return permLocality;
	}
	public void setPermLocality(String permLocality) {
		this.permLocality = permLocality;
	}
	public String getPermPIN() {
		return permPIN;
	}
	public void setPermPIN(String permPIN) {
		this.permPIN = permPIN;
	}
	public String getPermSate() {
		return permSate;
	}
	public void setPermSate(String permSate) {
		this.permSate = permSate;
	}
	public String getPermStreetName() {
		return permStreetName;
	}
	public void setPermStreetName(String permStreetName) {
		this.permStreetName = permStreetName;
	}
	public String getPresentCity() {
		return presentCity;
	}
	public void setPresentCity(String presentCity) {
		this.presentCity = presentCity;
	}
	public String getPresentDist() {
		return presentDist;
	}
	public void setPresentDist(String presentDist) {
		this.presentDist = presentDist;
	}
	public String getPresentHouseNumber() {
		return presentHouseNumber;
	}
	public void setPresentHouseNumber(String presentHouseNumber) {
		this.presentHouseNumber = presentHouseNumber;
	}
	public String getPresentLocality() {
		return presentLocality;
	}
	public void setPresentLocality(String presentLocality) {
		this.presentLocality = presentLocality;
	}
	public String getPresentPIN() {
		return presentPIN;
	}
	public void setPresentPIN(String presentPIN) {
		this.presentPIN = presentPIN;
	}
	public String getPresentSate() {
		return presentSate;
	}
	public void setPresentSate(String presentSate) {
		this.presentSate = presentSate;
	}
	public String getPresentStreetName() {
		return presentStreetName;
	}
	public void setPresentStreetName(String presentStreetName) {
		this.presentStreetName = presentStreetName;
	}
	
	public Long getRefCustId() {
		return refCustId;
	}
	public void setRefCustId(Long refCustId) {
		this.refCustId = refCustId;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWorkingAddress() {
		return workingAddress;
	}
	public void setWorkingAddress(String workingAddress) {
		this.workingAddress = workingAddress;
	}
	
	
}
