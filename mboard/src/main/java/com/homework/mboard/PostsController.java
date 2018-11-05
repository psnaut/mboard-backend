package com.homework.mboard;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homework.mboard.models.AddReply;
import com.homework.mboard.models.Posts;
import com.homework.mboard.models.Replies;
import com.homework.mboard.repositories.PostsRepository;

//Definitely not secure, only using this for first iteration. 
@CrossOrigin
@RestController
@RequestMapping("/posts")
public class PostsController {
	
	@Autowired
	private PostsRepository postsRepo;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Posts> getAllPosts() {
		return postsRepo.findAll();
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public List<Posts> getPostsByUser(@PathVariable("username") String userName) {
		return postsRepo.findByUser(userName);
	}
	
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
	
	// Test for duplicate user-reply combo
	// TODO: Add anti-XSS measures to block or sanitize unsafe replies.
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public void addReply(@Valid @RequestBody AddReply addreply) {
		if (addreply == null) {
			return;
		}
		// Make Sure empty reply doesn't get posted.
		if (!isNullOrEmpty(addreply.getReply().getUser()) && !isNullOrEmpty(addreply.getReply().getComment())) {
			Posts post = postsRepo.findByUserAndComment(addreply.getUser(), addreply.getComment());
			if (post != null) {
				List<Replies> replies = post.getReplies();
				if (replies != null) {
					replies.add(addreply.getReply());
					post.setReplies(replies);
				} else {
					Replies reply = addreply.getReply();
					List<Replies> newReplies = new ArrayList<Replies>();
					newReplies.add(reply);
					post.setReplies(newReplies);
				}
				postsRepo.save(post);
			}
		}
	}
	
	private boolean isNullOrEmpty(String input) {
		if (input == null || input.trim().equals("")) {
			return true;
		}
		return false;
	}

	
	

}
