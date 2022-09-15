package com.example.demo.form;

import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserForm {
	
	private Integer id;
	@NotBlank
	private String account;
	@NotBlank
	private String name;
	@NotBlank
	@Pattern(regexp="^[0-9A-Za-z]+$")
	private String password;
	@NotBlank
	@Pattern(regexp="^[0-9A-Za-z]+$")
	private String checkPassword;
	@Max(2)
	@Min(1)
	private Integer summary;
	private Date createdDate;
	private Date updatedDate;
	
	@AssertTrue
	public boolean ismatchPassword() {
	if (password.matches(checkPassword)) {
		return true;
	}
		return false;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCheckPassword() {
		return checkPassword;
	}
	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}
	public Integer getSummary() {
		return summary;
	}
	public void setSummary(Integer summary) {
		this.summary = summary;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
