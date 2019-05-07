package com.quick.pickup.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quick.pickup.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	//@Query("select u from User u where u.username= ?1")
   public User findByUsername(String username);
   public User deleteByUsername(String username);
   @Modifying(clearAutomatically = true)
   @Transactional
   @Query("UPDATE User user SET user.groupe.groupId =:idGrp  WHERE user.userId=:idUsr")
   //@Query(value="UPDATE USW_DAT SET PRW_KEYU =:idGrp  WHERE USW_KEYU=:idUsr" , nativeQuery = true)
   public void affecteUserTogroup(@Param("idUsr") Integer idUser ,@Param("idGrp") Integer idGroupe);
   
}
