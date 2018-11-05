package com.homework.mboard;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homework.mboard.models.Posts;
import com.homework.mboard.repositories.PostsRepository;

//Definitely not secure, only using this for first iteration. 
@CrossOrigin
@RestController
@RequestMapping("/posts")
public class PostsController {
	
	@Autowired
	private PostsRepository postsRepo;
	
	// TODO: Add anti-XSS measures to block or sanitize unsafe posts.
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void addPost(@Valid @RequestBody Posts post) {
		if (post == null) {
			return;
		}
		if (isNullOrEmpty(post.getUser()) || isNullOrEmpty(post.getComment()) || isNullOrEmpty(post.getCity())) {
			return;
		}
		Posts existingPost = postsRepo.findByUserAndComment(post.getUser(), post.getComment());
		// TODO: Return a non-200 response if existing post is found and handle in the front end.
		if (existingPost == null) {
			post.set_id(ObjectId.get());
			postsRepo.save(post);
		}
	}
	
	private boolean isNullOrEmpty(String input) {
		if (input == null || input.trim().equals("")) {
			return true;
		}
		return false;
	}

	
	

}
