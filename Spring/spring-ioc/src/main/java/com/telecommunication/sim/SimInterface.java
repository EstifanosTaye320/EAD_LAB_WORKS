package com.telecommunication.sim;

public interface SimInterface {
	public void call();
	public void data();

	public void setOperatorName(String opeartorName);
	public String getOperatorName();
	
	public void setPhoneNumber(String phoneNumber);
	public String getPhoneNumber();
	
	public void setProperty(String property);
	public String getProperty();
}
