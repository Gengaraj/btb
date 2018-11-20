package com.stc.api.btb.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findByUserName(@Param("userName") String userName);
	
	List<User> findByUserFirstName(@Param("userFirstName") String userFirstName);
	
	List<User> findByUserLastName(@Param("userLastName") String userLastName);
	
	//List<User> findByuserNameOruserFirstNameOruserLastName(@Param("name") String userName);

}
