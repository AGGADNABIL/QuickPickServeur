package com.quick.pickup.service;



import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.quick.pickup.dao.GroupeDao;
import com.quick.pickup.dao.RoleDao;
import com.quick.pickup.dao.UserDao;
import com.quick.pickup.entity.Groupe;
import com.quick.pickup.entity.User;
import com.quick.pickup.except.GroupeNotFoundException;

@Service
public class UserDetailsServiceImp  implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user=userDao.findByUsername(username);
		Collection<GrantedAuthority> authorities=new ArrayList<>();
		
		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
			authorities.add(new SimpleGrantedAuthority(user.getGroupe().getNomgroupe()));
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}
}
