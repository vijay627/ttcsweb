package com.ttcs.web.command.society;





import org.springframework.web.multipart.commons.CommonsMultipartFile;





public class CustomerDetailsCommand extends CommandBean{
	
	
	
	private String employeeId;
	private long custId;	
	private String firstName;
	private String lastName;
	private CommonsMultipartFile custPhoto;
	private String dateOfBirth;
	private long mobileNumber;
	private String email;
	private String gender;
	private CommonsMultipartFile custSign;
	private String fatherSpouseName;
	
	
	private String presentAddress;
	private String permAddress;
	
	
	private String idProof;
	private String idProofNumber;
	private String addressProof;
	private String addressProofNumber;
	
	private String nomineeName;
	private String nomineeDateOfBirth;
	private String relation;
	private String nomineeAddress;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public CommonsMultipartFile getCustPhoto() {
		return custPhoto;
	}
	public void setCustPhoto(CommonsMultipartFile custPhoto) {
		this.custPhoto = custPhoto;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public CommonsMultipartFile getCustSign() {
		return custSign;
	}
	public void setCustSign(CommonsMultipartFile custSign) {
		this.custSign = custSign;
	}
	public String getFatherSpouseName() {
		return fatherSpouseName;
	}
	public void setFatherSpouseName(String fatherSpouseName) {
		this.fatherSpouseName = fatherSpouseName;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	public String getPermAddress() {
		return permAddress;
	}
	public void setPermAddress(String permAddress) {
		this.permAddress = permAddress;
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
	public String getNomineeName() {
		return nomineeName;
	}
	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}
	public String getNomineeDateOfBirth() {
		return nomineeDateOfBirth;
	}
	public void setNomineeDateOfBirth(String nomineeDateOfBirth) {
		this.nomineeDateOfBirth = nomineeDateOfBirth;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getNomineeAddress() {
		return nomineeAddress;
	}
	public void setNomineeAddress(String nomineeAddress) {
		this.nomineeAddress = nomineeAddress;
	}
	
	
	
	
	
}
