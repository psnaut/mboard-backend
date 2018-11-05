package com.homework.mboard;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework.mboard.models.Posts;
import com.homework.mboard.repositories.PostsRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PostsController.class)
public class PostsControllerTests {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PostsRepository postsRepo;
	
	@Test
	public void verifyPostWithNullCommentNotAdded() throws Exception {
		Posts postWithNullComment = new Posts();
		postWithNullComment.setCity("city");
		postWithNullComment.setComment(null);
		postWithNullComment.setUser("user");
		postWithNullComment.setLatitude(null);
		postWithNullComment.setLongitude(null);
		postWithNullComment.setReplies(null);

		ObjectMapper objectMapper = new ObjectMapper();

		String newPostJson = objectMapper.writeValueAsString(postWithNullComment);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/posts/").accept(MediaType.APPLICATION_JSON)
				.content(newPostJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());
		Mockito.verifyZeroInteractions(postsRepo);

	}

	@Test
	public void verifyPostWithNullCityNotAdded() throws Exception {
		Posts postWithNullCity = new Posts();
		postWithNullCity.setCity(null);
		postWithNullCity.setComment("comment");
		postWithNullCity.setUser("user");
		postWithNullCity.setLatitude(null);
		postWithNullCity.setLongitude(null);
		postWithNullCity.setReplies(null);

		ObjectMapper objectMapper = new ObjectMapper();

		String newPostJson = objectMapper.writeValueAsString(postWithNullCity);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/posts/").accept(MediaType.APPLICATION_JSON)
				.content(newPostJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());
		Mockito.verifyZeroInteractions(postsRepo);

	}

	@Test
	public void verifyPostWithNullUserNotAdded() throws Exception {
		Posts postWithNullUser = new Posts();
		postWithNullUser.setCity("city");
		postWithNullUser.setComment("comment");
		postWithNullUser.setUser(null);
		postWithNullUser.setLatitude(null);
		postWithNullUser.setLongitude(null);
		postWithNullUser.setReplies(null);

		ObjectMapper objectMapper = new ObjectMapper();

		String newPostJson = objectMapper.writeValueAsString(postWithNullUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/posts/").accept(MediaType.APPLICATION_JSON)
				.content(newPostJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());
		Mockito.verifyZeroInteractions(postsRepo);

	}

	@Test
	public void verifyPostWithEmptyCommentNotAdded() throws Exception {
		Posts postWithEmptyComment = new Posts();
		postWithEmptyComment.setCity("city");
		postWithEmptyComment.setComment("      ");
		postWithEmptyComment.setUser("user");
		postWithEmptyComment.setLatitude(null);
		postWithEmptyComment.setLongitude(null);
		postWithEmptyComment.setReplies(null);

		ObjectMapper objectMapper = new ObjectMapper();

		String newPostJson = objectMapper.writeValueAsString(postWithEmptyComment);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/posts/").accept(MediaType.APPLICATION_JSON)
				.content(newPostJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());
		Mockito.verifyZeroInteractions(postsRepo);
	}

	@Test
	public void verifyPostWithEmptyCityNotAdded() throws Exception {
		Posts postWithEmptyCity = new Posts();
		postWithEmptyCity.setCity("   ");
		postWithEmptyCity.setComment("comment");
		postWithEmptyCity.setUser("user");
		postWithEmptyCity.setLatitude(null);
		postWithEmptyCity.setLongitude(null);
		postWithEmptyCity.setReplies(null);

		ObjectMapper objectMapper = new ObjectMapper();

		String newPostJson = objectMapper.writeValueAsString(postWithEmptyCity);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/posts/").accept(MediaType.APPLICATION_JSON)
				.content(newPostJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());
		Mockito.verifyZeroInteractions(postsRepo);

	}

	@Test
	public void verifyPostWithEmptyUserNotAdded() throws Exception {
		Posts postWithEmptyUser = new Posts();
		postWithEmptyUser.setCity("city");
		postWithEmptyUser.setComment("comment");
		postWithEmptyUser.setUser("    ");
		postWithEmptyUser.setLatitude(null);
		postWithEmptyUser.setLongitude(null);
		postWithEmptyUser.setReplies(null);

		ObjectMapper objectMapper = new ObjectMapper();

		String newPostJson = objectMapper.writeValueAsString(postWithEmptyUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/posts/").accept(MediaType.APPLICATION_JSON)
				.content(newPostJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());
		Mockito.verifyZeroInteractions(postsRepo);

	}

	@Test
	public void verifyLegitPostAdded() throws Exception {
		Posts legitPost = new Posts();
		legitPost.setCity("city");
		legitPost.setComment("comment");
		legitPost.setUser("user");
		legitPost.setLatitude(null);
		legitPost.setLongitude(null);
		legitPost.setReplies(null);

		ObjectMapper objectMapper = new ObjectMapper();

		String newPostJson = objectMapper.writeValueAsString(legitPost);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/posts/").accept(MediaType.APPLICATION_JSON)
				.content(newPostJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());
		Mockito.verify(postsRepo, Mockito.times(1)).save(Mockito.any());

	}

	@Test
	public void verifyPostWithDuplicateUserCommentNotAdded() throws Exception {
		Posts legitPost = new Posts();
		legitPost.setCity("city");
		legitPost.setComment("comment");
		legitPost.setUser("user");
		legitPost.setLatitude(null);
		legitPost.setLongitude(null);
		legitPost.setReplies(null);

		Posts existingPost = new Posts();
		existingPost.setCity("city2");
		existingPost.setComment("comment");
		existingPost.setUser("user");
		existingPost.setLatitude("0.056");
		existingPost.setLongitude("-0.067");
		existingPost.setReplies(null);

		ObjectMapper objectMapper = new ObjectMapper();

		String newPostJson = objectMapper.writeValueAsString(legitPost);
		
		Mockito.when(postsRepo.findByUserAndComment(Mockito.any(), Mockito.any())).thenReturn(existingPost);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/posts/").accept(MediaType.APPLICATION_JSON)
				.content(newPostJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());
		Mockito.verify(postsRepo, Mockito.times(0)).save(Mockito.any());

	}
	
}
