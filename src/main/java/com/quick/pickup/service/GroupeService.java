package com.quick.pickup.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.pickup.commun.IDateFormatter;
import com.quick.pickup.dao.GroupeDao;
import com.quick.pickup.entity.Groupe;


@Service
public class GroupeService {
	
	@Autowired
	private GroupeDao groupeDao ;

	public Groupe saveGroupe(Groupe groupe) {
		groupe.setDateCreation(LocalDate.now());
		groupe.setHeureCreation(IDateFormatter.currentHour());
		return groupeDao.save(groupe);
	}

	public List<Groupe> findAllGroup() {
		
		return groupeDao.findAll();
	}

	public void deleteGroup(String namegroupe) {
		groupeDao.deleteByNomgroupe(namegroupe);
	}
	
	public Groupe findGroupByName(String name) {
		return groupeDao.findByNomgroupe(name);
	}

	public Optional<Groupe> findGroupById(Integer id) {
		return groupeDao.findById(id);
	}

	public Groupe updateGroup(Groupe group) {
		group.setDateModification(LocalDate.now());
		group.setHeureModification(IDateFormatter.currentHour());
		return groupeDao.save(group);
	}

}
