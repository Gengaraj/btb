package com.stc.api.btb.appreciation;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stc.api.btb.user.UserApiController;

//@Controller
//@RequestMapping(path = "/btb/api") 
public class AppreciationApiController {
	
public static final Logger logger = LoggerFactory.getLogger(UserApiController.class);
	
	@Autowired 
	private AppreciationService appreciationService;
	
	//@PostMapping(path = "/appreciations")
	public @ResponseBody ResponseEntity<String> submitNewAppreciation(@RequestBody Appreciation empAppreciation) {
		empAppreciation.setAppreciationStatus('P');
		empAppreciation.setCreatedTimeStamp(new Timestamp(System.currentTimeMillis()));
		empAppreciation.setUpdatedTimeStamp(new Timestamp(System.currentTimeMillis()));
		appreciationService.addAppreciation(empAppreciation);
		return new ResponseEntity<String>("Appreciation Successfully Submitted", HttpStatus.OK);
	}

	//@PutMapping(path = "/appreciations")
	public @ResponseBody ResponseEntity<String> updateAppreciation(@RequestBody Appreciation empAppreciation) {
		appreciationService.updateAppreciation(empAppreciation);
		return new ResponseEntity<String>("Appreciation Successfully Updated", HttpStatus.OK);
	}

	//@GetMapping(path = "/appreciations/byUser")
	public @ResponseBody ResponseEntity<Iterable<Appreciation>> findApprcaitionByUser(@RequestParam Integer userId) {
		return new ResponseEntity<Iterable<Appreciation>>(appreciationService.findAppreciationsGivenByUser(userId), HttpStatus.OK);
	}

	//@GetMapping(path = "/appreciations/toUser")
	public @ResponseBody ResponseEntity<Iterable<Appreciation>> findAppreciationToUser(@RequestParam Integer userId) {
		return new ResponseEntity<Iterable<Appreciation>>(appreciationService.findAppreciationsGivenToUser(userId), HttpStatus.OK);
	}
	
}
