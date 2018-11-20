package com.stc.api.btb.user;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/btb/api") 
public class UserApiController {

	public static final Logger logger = LoggerFactory.getLogger(UserApiController.class);
	
	@Autowired 
	private UserService userService;

	@PostMapping(path = "/users")
	public @ResponseBody ResponseEntity<String> addNewUser(@RequestBody User user) {
		user.setUserStatus('A');
		user.setCreatedBy(user.getId() == null ? 1 : user.getId());
		user.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		user.setUpdatedBy(user.getId() == null ? 1 : user.getId());
		user.setUpdatedOn(new Timestamp(System.currentTimeMillis()));
		user.setSsoId("SSOKC1");
		userService.addUser(user);
		return new ResponseEntity<String>("User Successfully Saved", HttpStatus.OK);
	}

	/*//@PutMapping(path = "/users")
	public @ResponseBody ResponseEntity<String> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseEntity<String>("User Successfully Updated", HttpStatus.OK);
	}

	//@GetMapping(path = "/users")
	public @ResponseBody ResponseEntity<Map<String,Iterable<User>>> getAllUsers() {
		Map<String,Iterable<User>> profiles= new HashMap<String,Iterable<User>>();
		profiles.put("profiles",userService.getAllUsers());
		return new ResponseEntity<Map<String,Iterable<User>>>(profiles, HttpStatus.OK);
		//return new ResponseEntity<Iterable<User>>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	//@GetMapping(path = "/users/searchByName")
	public @ResponseBody ResponseEntity<Iterable<User>> findByName(@RequestParam String name) {
		return new ResponseEntity<Iterable<User>>(userService.findUserByName(name), HttpStatus.OK);
	}

	//@GetMapping(path = "/users/count")
	public @ResponseBody ResponseEntity<Long> getUsersCount() {
		return new ResponseEntity<Long>(userService.getUserCounts(), HttpStatus.OK);
	}

	//@GetMapping(path = "/users/{id}")
	public @ResponseBody ResponseEntity<User> isUserExist(@PathVariable("id") Long id) {
		User user=userService.findUserById(id);
		user.setAppreciations(userService.getEmpAprreciations(id));
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	//@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
		logger.info("Fetching & Deleting User with id {}", id);
		User user = userService.findUserById(id);
		if (user == null) {
			logger.error("Unable to delete. User with id {} not found.", id);
			return new ResponseEntity<String>("Unable to delete. User with id " + id + " not found.",
					HttpStatus.NOT_FOUND);
		}
		user.setUserStatus('I');
		userService.updateUser(user);
		return new ResponseEntity<String>("User Successfully deleted", HttpStatus.NO_CONTENT);
	}
	

	//@RequestMapping(value = "/users/", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAllUsers() {
		logger.info("Deleting All Users");
		userService.getAllUsers().forEach(u -> {
			u.setUserStatus('I');
			userService.updateUser(u);
		});
		return new ResponseEntity<String>("All Users are deleted ", HttpStatus.NO_CONTENT);
	}*/

}
