package com.quick.pickup.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="USW_DAT")
//@DynamicUpdate
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USW_KEYU")
	private Integer userId;
	
	@Column(name="USW_LOGN",unique=true)
	private String username;
	
	@Column(name="USW_NOMP")
	private String userDesc ;

	@Column(name="USW_PASS")
	private String password;
	
	@Column(name="USW_ACTF")
	private Boolean active;
	
	@Column(name="USW_CRDA")
	@Basic
	private LocalDate dateCreation ;
	
	@Column(name="USW_ALPHA1")
	@Basic
	private String heureCreation;
	
	@Column(name="USW_CRQI")
	private String quiCreer;
	
	@Column(name="USW_DATE1")
	@Basic
	private LocalDate dateModification ;
	
	@Column(name="USW_ALPHA2")
	@Basic
	private String heureModification;
	
	@Column(name="USW_ALPHA3")
	private String quiModifier;
	
	@ManyToOne
	@JoinColumn(name="PRW_KEYU")
	private Groupe groupe;
	
	public User() {
	}

	
	public String getUserDesc() {
		return userDesc;
	}


	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
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

	public User(String username, String password, Boolean active) {
		super();
		this.username = username;
		this.password = password;
		this.active = active;
	} 
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(Integer userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	
	

}
