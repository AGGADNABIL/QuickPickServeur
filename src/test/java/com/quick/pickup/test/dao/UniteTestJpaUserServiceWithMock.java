package com.quick.pickup.test.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.quick.pickup.dao.UserDao;
import com.quick.pickup.entity.User;
import com.quick.pickup.service.UserService;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UniteTestJpaUserServiceWithMock {

	Logger logger = LogManager.getLogger(UniteTestJpaUserServiceWithMock.class);

	@MockBean
	private UserDao userDao;
	
	
	@Autowired
	private UserService userService;
	
	@TestConfiguration
	static class UserDaoServiceImpTestConfiguration {
		@Bean
		public UserService userService() {
			return new UserService();
		}
	}
	
	@Test
	public void testAddUser() {
		User user = new User("salah", "salah");
		 User u =new User("salah", "salah");
		 DateTimeFormatter tf=DateTimeFormatter.ofPattern("hhmmss");
		 user.setActive(true);
		 user.setDateCreation(LocalDate.now());
		 user.setHeureCreation(tf.format(LocalTime.now()));
		when(userDao.save(user)).thenReturn(u);
		
		assertThat(userService.saveUser(user)).isEqualTo(u);
	    assertEquals(userService.saveUser(user).getPassword(), u.getPassword());
	    
	    when(userDao.findAll()).thenReturn(Stream.of(new User("test","test") , new User("nabil","nabil")).collect(Collectors.toList()));
	    assertEquals(userService.findAllUser().size(), 2);
	}

	@Test
	public void testFindUser() {
		
		when(userDao.findByUsername("admin")).thenReturn(new User("admin","admin"));
		assertThat(userService.findUser("admin").getPassword()).isEqualTo("admin");
	}
	
	@Test
	public void testDeleteUser() {
		User user=new User("admin","admin");
		userService.deleteUser(user.getUsername());
		verify(userDao, times(1)).deleteByUsername(user.getUsername());
	}
	@Test
	public void testUpdateUser() {
		User updated=new User("admin","admin");
		User person=new User("admin","salam");
		when(userDao.save(updated)).thenReturn(person);
		assertThat(userService.updateUser(updated)).isEqualTo(person);
	}
	
	@Test
	public void testIfRepositoryIsEmpty() {
		
		Iterable<User> users=userService.findAllUser();
		assertThat(users).isEmpty();
		
	}
	
	
	
}
