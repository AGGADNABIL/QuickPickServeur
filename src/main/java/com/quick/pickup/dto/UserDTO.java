package com.quick.pickup.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;

public class UserDTO implements Serializable {
	
	private Integer userId;
	private String username;
	private String password;	
	private Boolean active;	
	private LocalDate dateCreation ;
	private String heureCreation;	
	private String quiCreer;	
	private LocalDate dateModification ;
	private String heureModification;
	private String quiModifier;
	
	public UserDTO() {

	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	
	public String getQuiCreer() {
		return quiCreer;
	}

	public void setQuiCreer(String quiCreer) {
		this.quiCreer = quiCreer;
	}


	
	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	
	public LocalDate getDateModification() {
		return dateModification;
	}

	public void setDateModification(LocalDate dateModification) {
		this.dateModification = dateModification;
	}

	

	public String getHeureCreation() {
		return heureCreation;
	}

	public void setHeureCreation(String heureCreation) {
		this.heureCreation = heureCreation;
	}

	public String getHeureModification() {
		return heureModification;
	}

	public void setHeureModification(String heureModification) {
		this.heureModification = heureModification;
	}

	public String getQuiModifier() {
		return quiModifier;
	}

	public void setQuiModifier(String quiModifier) {
		this.quiModifier = quiModifier;
	}

	public UserDTO(String username, String password, Boolean active) {
		super();
		this.username = username;
		this.password = password;
		this.active = active;
	} 
	public UserDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

}
