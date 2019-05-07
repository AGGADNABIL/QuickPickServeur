package com.quick.pickup.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quick.pickup.dto.GroupDTO;
import com.quick.pickup.dto.UserDTO;
import com.quick.pickup.entity.Groupe;
import com.quick.pickup.entity.User;
import com.quick.pickup.service.GroupeService;
import com.quick.pickup.service.UserService;

@RestController
@CrossOrigin
public class UserControllerRest {
	
	private Logger logger=LogManager.getLogger(UserControllerRest.class);
	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupeService groupeService ; 
	
	private User user =new User();
	
	@PostMapping(value="/profils/add") //,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE
	public User addUser(@RequestBody UserDTO u) {
		
		// converter UserDTO to user entity
		BeanUtils.copyProperties(u, user);
		return userService.saveUser(user);
	}
	
	@GetMapping(value="/profils")
	public List<User> getAllUser(){
		return userService.findAllUser();
	}
	
	@DeleteMapping(value="/profils/{username:.+}")
	public ResponseEntity<String> deleteUser(@PathVariable("username") String username ) {
		logger.info("suppression de l'utilisateur avec userName = " + username + "...");
		userService.deleteUser(username);
		return new ResponseEntity<>("l'utilisateur est supprimer!", HttpStatus.OK);
	}
	
//	@PutMapping(value="/profils/{username:.+}")
//	public ResponseEntity<User> updateUser(@PathVariable("username") String username , @RequestBody UserDTO userDto){
//		// converter UserDTO to user entity
//		BeanUtils.copyProperties(userDto, user);
//		User userUpdated=userService.findUser(username);
//		if(Objects.nonNull(userUpdated)) {
//			return new ResponseEntity<>(userService.updateUser(username , user),HttpStatus.OK);
//		}else {
//		     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	
	@PutMapping(value="/profils/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable("id") Integer idUser , @RequestBody UserDTO userDto){
		// converter UserDTO to user entity
		BeanUtils.copyProperties(userDto, user);
		Optional<User> userUpdated=userService.findUserById(idUser);
		if(Objects.nonNull(userUpdated)) {
			return new ResponseEntity<>(userService.updateUserById(user),HttpStatus.OK);
		}else {
		     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping(value="/profils/{id}/{nameGrp}")
	public ResponseEntity<String> affectGroupToUser(@PathVariable("id") Integer idUser ,@PathVariable("nameGrp") String nameGrp){
		
		Groupe groupe=groupeService.findGroupByName(nameGrp);
		Optional<User> userFind=userService.findUserById(idUser);
		if(Objects.nonNull(groupe)) {
			if(Objects.nonNull(userFind)) {
				userService.affecterGroupToUser(idUser, groupe.getGroupId());
				return new  ResponseEntity<>("affectation du groupe à l'utilisateur est éffectuée",HttpStatus.OK);
			}else {
				
				return new ResponseEntity<>("utilisateur inconnu",HttpStatus.NOT_FOUND);
			}
		}else {
				return new ResponseEntity<>("groupe inconnu",HttpStatus.NOT_FOUND);
			}
		}
		
	}
	

