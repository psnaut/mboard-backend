package com.homework.mboard.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.homework.mboard.models.Posts;

public interface PostsRepository extends MongoRepository<Posts, String> {
	
	List<Posts> findByUser(String user);
	Posts findByUserAndComment(String user, String comment);

}
