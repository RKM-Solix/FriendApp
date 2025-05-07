package com.solix.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solix.demo.entity.FriendEntity;
import com.solix.demo.repository.FriendRepository;

@Service
public class FriendService {

	@Autowired
	FriendRepository friendRepository;
	
	public FriendEntity addFriend(FriendEntity friend) {
		Integer count = friendRepository.checkFriendContact(friend.getPhoneNumber(), friend.getFriendNumber());
		
		if(count == 0) {
			FriendEntity newEntity = friendRepository.saveAndFlush(friend);
			return newEntity;
		}
		return null;
	}

	public List<Long> getFriendsContacts(Long phoneNumber) {
		
		return friendRepository.findFriendsContactNumbers(phoneNumber);
	}

}
