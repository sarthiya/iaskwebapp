package com.cisco.iask.auth;


import java.io.Serializable;

/**
 * Created by sarthiya on 16/04/16.
 */

public class LoginResponse implements Serializable{

    private String username;
    private String firstname;
    private String lastname;
    private String errorMsg;
    private boolean isSignupDone;
    
	public LoginResponse(String firstname, String lastname, String name) {
		// TODO Auto-generated constructor stub
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = name;
		this.isSignupDone = true;
	}
	public LoginResponse() {
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public boolean isSignupDone() {
		return isSignupDone;
	}
	public void setSignupDone(boolean isSignupDone) {
		this.isSignupDone = isSignupDone;
	}
}
