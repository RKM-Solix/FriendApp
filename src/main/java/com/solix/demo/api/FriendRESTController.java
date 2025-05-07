package com.solix.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solix.demo.entity.FriendEntity;
import com.solix.demo.service.FriendService;

@RestController
@RequestMapping(value = "/api2")
public class FriendRESTController {

	@Autowired
	FriendService friendService;
	
	@PostMapping(value = "/friend/save", consumes = "application/json")
	public ResponseEntity<FriendEntity> addFriend(@RequestBody FriendEntity friend){
		FriendEntity newEntity = friendService.addFriend(friend);
		
		if(newEntity == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(newEntity, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/friend/{phoneNumber}", produces = "application/json")
	public List<Long> getFriendsContacts(@PathVariable Long phoneNumber){
		return friendService.getFriendsContacts(phoneNumber);
	}
}
