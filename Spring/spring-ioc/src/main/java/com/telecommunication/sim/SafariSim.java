package com.telecommunication.sim;

public class SafariSim implements SimInterface {
	String operatorName;
	String phoneNumber;
	String property;
	
	SafariSim(String operatorName, String phoneNumber) {
		this.operatorName = operatorName;
		this.phoneNumber = phoneNumber;
	}
	
	
	@Override
	public void call() {
		System.out.println("Calling with SafariSim");
	}

	@Override
	public void data() {
		System.out.println("Browsing with SafariSim");
	}

	@Override
	public void setOperatorName(String opeartorName) {
		this.operatorName = opeartorName;
		
	}

	@Override
	public String getOperatorName() {
		return "Name of the operator is: " + this.operatorName;
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String getPhoneNumber() {
		return "Phone Number: " + this.phoneNumber;
	}

	@Override
	public void setProperty(String property) {
		this.property = property;
		
	}

	@Override
	public String getProperty() {
		return "Property: " + this.property;
	}

}
