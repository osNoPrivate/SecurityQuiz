package com.example.demo.selectModel;

public class SummaryModel {
	
	private int status;
	private String name;
	
	public SummaryModel(int status, String name) {
		this.status = status;
		this.name = name;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
