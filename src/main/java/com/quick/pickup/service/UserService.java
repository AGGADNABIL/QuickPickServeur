package com.quick.pickup.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quick.pickup.commun.IDateFormatter;
import com.quick.pickup.dao.UserDao;
import com.quick.pickup.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public User saveUser(User user) {
		 user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		 user.setActive(true);
	     user.setDateCreation(LocalDate.now());
	     user.setHeureCreation(IDateFormatter.currentHour());
	     User u=userDao.save(user);
	     return u;
	}
	
	public User updateUser(User user) {
	     user.setDateModification(LocalDate.now());
	     user.setHeureModification(IDateFormatter.currentHour());
	     User u=userDao.save(user);
	     return u;
	}
	
	
	public User disableUser(User user) {
		 user.setActive(false);
	     user.setDateModification(LocalDate.now());
	     // IdateFormater pour formater la l'heure sous format hhmmss
	     user.setHeureModification(IDateFormatter.currentHour());
	     User u=userDao.save(user);
	     return u;
	}
	
	public User findUser(String username) {
		return userDao.findByUsername(username);
	}
	
	public Optional<User> findUserById(Integer id) {
		return userDao.findById(id);
	}
	public List<User> findAllUser() {
		return userDao.findAll();
	}
	@Transactional
	public User deleteUser(String username) {
		return userDao.deleteByUsername(username);
	}
	
	@Transactional
	public User updateUser(String username, User u) {
		User user =userDao.findByUsername(username);			
		user.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		user.setActive(u.getActive());
		user.setDateModification(LocalDate.now());
	    user.setHeureModification(IDateFormatter.currentHour());
		return userDao.save(user);
	}

	@Transactional
	public User updateUserById(User user) {
		user.setDateModification(LocalDate.now());
	    user.setHeureModification(IDateFormatter.currentHour());
	    return userDao.save(user);
	}
	
	@Transactional
	public void  affecterGroupToUser(Integer idUser , Integer idGroupe){
		 userDao.affecteUserTogroup(idUser, idGroupe);
	}
	
}
