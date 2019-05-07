package com.quick.pickup;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.quick.pickup.dao.RoleDao;
import com.quick.pickup.dao.UserDao;
import com.quick.pickup.entity.Role;

@SpringBootApplication
public class QuickPickupServeurApplication implements CommandLineRunner {
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserDao userDao;
	//https://www.youtube.com/user/abolkog/playlists
	
	public static void main(String[] args) {
		SpringApplication.run(QuickPickupServeurApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println(passwordEncoder.encode("nabil"));
		
	//=======
		//userDao.affecteUserTogroup(3, 2);
		
	//=========
//		Optional<Role> findById = roleDao.findById(162);
//		if(Objects.nonNull(findById)) {
//			roleDao.affectGroupToRole(162,2);
//			
//	}
		
	}
	
	
}

	