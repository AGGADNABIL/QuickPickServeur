package com.quick.pickup.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.quick.pickup.entity.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer>{
	public Role findByRolename(String rolename);
	public Role deleteByRolename(String rolename);
	  @Modifying(clearAutomatically = true)
	  @Transactional
	  //@Query(value="UPDATE GWM_SYS SET PRW_KEYU=:idGrp  WHERE GWM_KEYU=:idRole", nativeQuery = true)
	  @Query("UPDATE Role  role SET role.groupe.groupId=:idGrp  WHERE role.roleId=:idRole")
	  public void affectGroupToRole(@Param("idRole") Integer idRole ,@Param("idGrp") Integer idGroupe);
	  
	  @Query("select r from Role r where r.groupe.groupId=:grpId")
	  public String[] findByIdgroupe(@Param("grpId") Integer groupId);
	  
}
