package com.quick.pickup.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.pickup.dao.RoleDao;
import com.quick.pickup.entity.Role;

@Service
public class RoleService {
	
	@Autowired
	private RoleDao roleDao;
	
	public List<Role> findAllRole() {
		return roleDao.findAll();
	}

	public Role updateRole(String nameRole, Role r) {
		Role role=roleDao.findByRolename(nameRole);
		role.setAuthorBarre(r.getAuthorBarre());
		role.setAuthorMenu(r.getAuthorMenu());
		role.setMenuId(r.getMenuId());
		role.setRolename(r.getRolename());
		return roleDao.save(role);
	}

	public Role deleteRole(String rolename) {
		return roleDao.deleteByRolename(rolename);
	}

	public Role saveRole(Role r) {
		r.setDateCreation(LocalDate.now());
		return roleDao.save(r);
	}
	
	public void affecterGroupeToRole(Integer idRole , Integer idGroupe){	 
		roleDao.affectGroupToRole(idRole, idGroupe);
	}
	
}
