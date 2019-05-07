package com.quick.pickup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quick.pickup.entity.Groupe;
import com.quick.pickup.entity.User;

@Repository
public interface GroupeDao extends JpaRepository<Groupe, Integer> {
	
	public Groupe findByNomgroupe(String nomgroupe);
	public Groupe deleteByNomgroupe(String nomgroupe);
	public Groupe findByGroupId(Integer groupId);
	
}
