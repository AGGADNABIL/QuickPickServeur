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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quick.pickup.dto.GroupDTO;
import com.quick.pickup.entity.Groupe;
import com.quick.pickup.service.GroupeService;
@RestController
public class GroupeControllerRest {

	private Logger logger=LogManager.getLogger(GroupeControllerRest.class);
	@Autowired
	private GroupeService groupeService;
	private Groupe groupe =new Groupe();
	
	@PostMapping(value="/gps/add") //,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE
	public Groupe addGroup(@RequestBody GroupDTO grp) {
		
		// converter UserDTO to user entity
		BeanUtils.copyProperties(grp, groupe);
		return groupeService.saveGroupe(groupe);
	}
	
	@GetMapping(value="/gps")
	public List<Groupe> getAllGroup(){
		return groupeService.findAllGroup();
	}
	
	@DeleteMapping(value="/gps/{nameGroupe}")
	public ResponseEntity<String> deleteGroup(@PathVariable("nameGroupe") String nameGroupe ) {
		logger.info("suppression du groupe avec nameGroupe = " + nameGroupe + "...");
		groupeService.deleteGroup(nameGroupe);
		return new ResponseEntity<>("le groupe est supprimer!", HttpStatus.OK);
	}
	
//	@PutMapping(value="/gps/{nameGroupe}")
//	public ResponseEntity<Groupe> updategroup(@PathVariable("nameGroupe") String nameGroupe , @RequestBody GroupDTO groupDto){
//		// converter UserDTO to user entity
//		BeanUtils.copyProperties(groupDto, groupe);
//		Groupe group=groupeService.findGroupByName(nameGroupe);
//		if(Objects.nonNull(group)) {
//			return new ResponseEntity<>(groupeService.updateGroup(groupe),HttpStatus.OK);
//		}else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}	
//	}


	@PutMapping(value="/gps/{id}")
	public ResponseEntity<Groupe> updategroupById(@PathVariable("id") Integer idGroupe , @RequestBody GroupDTO groupDto){
		// converter UserDTO to user entity
		BeanUtils.copyProperties(groupDto, groupe);
		Optional<Groupe> group=groupeService.findGroupById(idGroupe);
		if(Objects.nonNull(group)) {
			return new ResponseEntity<>(groupeService.updateGroup(groupe),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
