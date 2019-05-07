package com.quick.pickup.test.grp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.security.acl.Group;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.quick.pickup.dao.GroupeDao;
import com.quick.pickup.entity.Groupe;
import com.quick.pickup.service.GroupeService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UniteTestJpaGroupService {

	@MockBean
	private GroupeDao groupeDao;
	
	@Autowired
	private GroupeService groupeService ;
	
	 @TestConfiguration 
	static class GroupeServiceTestConfiguration {
		 @Bean
		 public GroupeService groupeService() {
			 return new GroupeService();
		 }
	 }
	
	@Test @Ignore
	public void testFindGroup() {
		
		Groupe groupe = new Groupe("Administrateur", "CD");
		Mockito.when(groupeDao.findByNomgroupe("Administrateur")).thenReturn(groupe);
		assertThat(groupeService.findGroupByName("Administrateur")).isEqualTo(groupe);
	}
	
	@Test @Ignore
	public void testFindAllGroup() {
		
		Mockito.when(groupeDao.findAll())
			   .thenReturn(Stream.of(new Groupe("Administrateur", "CD"),
					   				 new Groupe("cariste", "CD")).collect(Collectors.toList()));
		assertThat(groupeService.findAllGroup().size()).isEqualTo(2);
	}
	@Test @Ignore
	public void testDeleteGroup() {
		
		Groupe groupe =new Groupe("admin", "CD");
		groupeService.deleteGroup(groupe.getNomgroupe());
		Mockito.verify(groupeDao).deleteByNomgroupe(groupe.getNomgroupe());
	}
	@Test @Ignore
	public void testAddGroup() {
		Groupe groupe= new Groupe("Administrateur", "CD");
		Groupe groupe1= new Groupe("Admin", "CD");
		
		Mockito.when(groupeDao.save(groupe)).thenReturn(groupe1);
		assertThat(groupeService.saveGroupe(groupe).getNomgroupe()).isEqualTo(groupe1.getNomgroupe());
		
	}
	 
	@Test 
	public void testUpadateGroupe() {
		
		Groupe groupe=new Groupe("Administrateur", "CD");
		Groupe groupe1= new Groupe("Admin", "CD");
		Mockito.when(groupeDao.save(groupe)).thenReturn(groupe1);
		// à tester la ligne ci-après ??????????????????????????????????
		//Mockito.verify(groupeService).updateGroup(groupe1) ;
		assertThat(groupeService.updateGroup(groupe)).isEqualTo(groupe1);
		assertEquals(groupeService.updateGroup(groupe).getNomgroupe(), "Admin");
		
		
	}
	
}
