package com.quick.pickup.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.quick.pickup.dto.RoleDTO;
import com.quick.pickup.entity.Role;
import com.quick.pickup.service.RoleService;

public class RoleControllerRest {

	private Logger logger=LogManager.getLogger(RoleControllerRest.class);
	@Autowired
	private RoleService roleService;
	private Role role =new Role();
	
	@PostMapping(value="/params/add") //,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE
	public Role addRole(@RequestBody RoleDTO roleDto) {
		
		// converter UserDTO to user entity
		BeanUtils.copyProperties(roleDto, role);
		return roleService.saveRole(role);
	}
	
	@GetMapping(value="/params")
	public List<Role> getAllRole(){
		return roleService.findAllRole();
	}
	
	@DeleteMapping(value="/params/{rolename}")
	public ResponseEntity<String> deleteRole(@PathVariable("rolename") String rolename ) {
		logger.info("suppression de l'utilisateur avec userName = " + rolename + "...");
		roleService.deleteRole(rolename);
		return new ResponseEntity<>("l'utilisateur est supprimer!", HttpStatus.OK);
	}
	
	@PutMapping(value="/params/{rolename}")
	public ResponseEntity<Role> updateRole(@PathVariable("rolename") String nameRole , @RequestBody RoleDTO roleDto){
		// converter UserDTO to user entity
		BeanUtils.copyProperties(roleDto, role);
		roleService.updateRole(nameRole , role);
		return new ResponseEntity<>(role,HttpStatus.OK);
	}
	
}
