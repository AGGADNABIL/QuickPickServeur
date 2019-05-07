package com.quick.pickup.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="GWM_SYS")
//@DynamicUpdate
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GWM_KEYU")
	private Integer roleId;
	
	@Column(name="GWM_ALPHA1")
	private String rolename;
	
	@Column(name="GWM_ACCB")
	private Boolean authorBarre;
	@Column(name="GWM_ACCM")
	private Boolean authorMenu;
	@Column(name="GWM_IDME")
	private Integer menuId;
	
	@Column(name="GWM_CRDA")
	@Basic
	private LocalDate dateCreation ;
	
	@Column(name="GWM_CRQI")
	private String quiCreer;

	@ManyToOne()
	@JoinColumn(name="PRW_KEYU")
	private Groupe groupe ;
	
	
	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	
	public Role() {
		
	}

	public Role(Boolean authorBarre, Boolean authorMenu, Integer menuId) {
		super();
		this.authorBarre = authorBarre;
		this.authorMenu = authorMenu;
		this.menuId = menuId;
	}


	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public Boolean getAuthorBarre() {
		return authorBarre;
	}


	public void setAuthorBarre(Boolean authorBarre) {
		this.authorBarre = authorBarre;
	}


	public Boolean getAuthorMenu() {
		return authorMenu;
	}

	public void setAuthorMenu(Boolean authorMenu) {
		this.authorMenu = authorMenu;
	}


	public Integer getMenuId() {
		return menuId;
	}


	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRolename() {
		return rolename;
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

	
}
