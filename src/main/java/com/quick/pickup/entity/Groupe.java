package com.quick.pickup.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="PRW_DAT")
//@DynamicUpdate
public class Groupe implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRW_KEYU")
	private Integer groupId;
	@Column(name="PRW_INTI", unique=true)
	private String nomgroupe;
	
	@Column(name="PRW_COIN", unique=true)
	private String codeGroupe;
	
	@Column(name="PRW_CRDA")
	private LocalDate dateCreation;
	
	@Column(name="PRW_ALPHA1")
	private String heureCreation;
	
	@Column(name="PRW_ALPHA2")
	private String heureModification;
	
	@Column(name="PRW_DATE1")
	private LocalDate dateModification;

	@Column(name="PRW_CRQI")
	private String quiCreer ;
	
	@Column(name="ACT_CODE")
	private String codeActivite;
	
	public Groupe(String nomgroupe, String codeGroupe, String codeActivite) {
		super();
		this.nomgroupe = nomgroupe;
		this.codeGroupe = codeGroupe;
		this.codeActivite = codeActivite;
	}

	public String getCodeGroupe() {
		return codeGroupe;
	}

	public void setCodeGroupe(String codeGroupe) {
		this.codeGroupe = codeGroupe;
	}

	
	
	public Groupe() {
		
	}
	
	public Groupe(String nomgroupe, String codeActivite) {
		super();
		this.nomgroupe = nomgroupe;
		this.codeActivite = codeActivite;
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

	public LocalDate getDateModification() {
		return dateModification;
	}

	public void setDateModification(LocalDate dateModification) {
		this.dateModification = dateModification;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getNomgroupe() {
		return nomgroupe;
	}

	public void setNomgroupe(String nomgroupe) {
		this.nomgroupe = nomgroupe;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getQuiCreer() {
		return quiCreer;
	}

	public void setQuiCreer(String quiCreer) {
		this.quiCreer = quiCreer;
	}

	public String getCodeActivite() {
		return codeActivite;
	}

	public void setCodeActivite(String codeActivite) {
		this.codeActivite = codeActivite;
	}
	
}
