package com.quick.pickup.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class GroupDTO implements Serializable {

	private Integer groupId;
	private String nomGroupe;
	private LocalDate dateCreation;
	private String quiCreer ;
	private String codeActivite;
	
	public GroupDTO() {
		
	}

	
	public GroupDTO(String nomGroupe, String codeActivite) {
		super();
		this.nomGroupe = nomGroupe;
		this.codeActivite = codeActivite;
	}


	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
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
