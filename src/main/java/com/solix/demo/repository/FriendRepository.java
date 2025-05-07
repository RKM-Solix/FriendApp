package com.solix.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.solix.demo.entity.FriendEntity;

@Repository
public interface FriendRepository extends JpaRepository<FriendEntity, Integer> {

	@Query(value = "select count(*) from friend_entity f where f.phone_number = ?1 and f.friend_number = ?2", nativeQuery = true)
	Integer checkFriendContact(Long phoneNumber, Long friendNumber);
	
	@Query(value = "select friend_number from friend_entity f where f.phone_number = ?1", nativeQuery = true)
	List<Long> findFriendsContactNumbers(Long phoneNumber);
}
