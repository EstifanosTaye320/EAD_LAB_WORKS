package com.itsc.di;

public class University {
	private String name;
	private String cname;
	
	public University (String cname) {
		this.setCname(cname);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
}
