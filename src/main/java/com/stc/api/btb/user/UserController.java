package com.stc.api.btb.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

//@RepositoryRestController
public class UserController {
	
	//@Autowired
	private UserRepository userRepository;
	
	//@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT, produces="application/hal+json",consumes={"application/hal+json","application/json"})
    public ResponseEntity<User> updateFoo(@RequestBody User user, @PathVariable Long userId) {
		List<User> users=userRepository.findByUserName(user.getUserName());
        return ResponseEntity.ok(user); // simplest use of a ResponseEntity
    }

}
